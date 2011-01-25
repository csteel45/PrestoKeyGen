package com.jackbe.keygen;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.Base64;

public class DEcrypter {
	private static final String PASSWORD = "H4VZdZS";
	
	public static String decrypt(String str, String password) {
		byte[] decodedText = Base64.decodeBase64(str.toString().getBytes());
		str = new String(decodedText);

		StringBuffer sb = new StringBuffer(str);
		int lenStr = str.length();
		int lenKey = password.length();

		//
		// For each character in our string, encrypt it...
		for (int i = 0, j = 0; i < lenStr; i++, j++) {

			if (j >= lenKey)
				j = 0; // Wrap 'round to beginning of key string.
			// XOR the chars together. Must cast back to char to avoid compile
			// error
			sb.setCharAt(i, (char) (str.charAt(i) ^ password.charAt(j)));
		}
		return (sb.toString());

	}

	public static String encrypt(String str, String password) {

		StringBuffer sb = new StringBuffer(str);
		int keyLength = str.length();
		int passLength = password.length();

		//
		// For each character in our string, encrypt it...
		for (int i = 0, j = 0; i < keyLength; i++, j++) {

			if (j >= passLength)
				j = 0; // Wrap 'round to beginning of key string.
			// XOR the chars together. Cast back to char to avoid compile error
			sb.setCharAt(i, (char) (str.charAt(i) ^ password.charAt(j)));
		}

		byte[] encodedText = Base64.encodeBase64(sb.toString().getBytes());
		String encryptedKey = new String(encodedText);

		//Make sure encrypted key can be decrypted
		String decodedKey = decrypt(encryptedKey, rot13(password));
		assert(decodedKey.equals(str));
		
		return encryptedKey;
	}

	public static LicenseInfo decode(String key) {
		//Password is last 7 chars on end 
		String pw = key.substring(key.length() - 7);
		//UnROT password ONLY
		pw = DEcrypter.rot13(pw);
		System.out.println("Real unROTted password = " + pw);

		// System.out.println(pw);
		// System.out.println("-----> " +
		// key.substring(0,key.lastIndexOf(".")));
		// String decryptedKey =
		// DEcrypter.decrypt(key.substring(0,key.lastIndexOf(".")), pw);

		//Decrypt key with unROTted password
		String decryptedKey = DEcrypter.decrypt(key.substring(0, key.length() - 7), pw);
		System.out.println("decrypted key = " + decryptedKey);

		LicenseInfo info = new LicenseInfo();
		info.setKey(key);

		StringTokenizer tokenizer = new StringTokenizer(decryptedKey, "^");
		info.setEmail(tokenizer.nextToken());
		info.setName(tokenizer.nextToken());
		info.setProduct(tokenizer.nextToken());
		info.setEdition(tokenizer.nextToken());
		info.setVersion(tokenizer.nextToken());
		info.setType(tokenizer.nextToken());
		info.setMonths(tokenizer.nextToken());

		if(Float.parseFloat(info.getVersion()) > 2.7) {
			info.setHostname(tokenizer.nextToken());
			info.setOptions(tokenizer.nextToken());
			info.setUserLimit(Integer.parseInt(tokenizer.nextToken()));
			info.setAnonLimit(Integer.parseInt(tokenizer.nextToken()));
		}
		// System.out.println(decryptedKey);
		
		//chris.steel@jackbe.com^Chris^PMP^D^3.0^1287783057593^60
		//
		return info;
	}
	
	public static String encode(LicenseInfo key) {
		
		if(!key.getEdition().equalsIgnoreCase("Developer") && null == key.getHostname()) {
			try {
			    InetAddress addr = InetAddress.getLocalHost();
			    byte[] ipAddr = addr.getAddress();
			    key.setHostname(addr.getHostName());
			} catch (UnknownHostException e) {
				key.setHostname("xxxx");
			}
		}
		if(key.getEdition().equalsIgnoreCase("Developer") && null == key.getHostname()) {
			key.setHostname("xxxx");
		}
		String tokenizedKey = key.toString();
		System.out.println("tokenized key = " + tokenizedKey);
		String encodedKey = encrypt(tokenizedKey, PASSWORD);
		encodedKey = encodedKey + rot13(PASSWORD);
		//assert(encodedKey.equals());
		return encodedKey;
	}


	public static String rot13(String s) {
		StringBuffer sb = new StringBuffer(s.length());
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'm')
				c += 13;
			else if (c >= 'n' && c <= 'z')
				c -= 13;
			else if (c >= 'A' && c <= 'M')
				c += 13;
			else if (c >= 'A' && c <= 'Z')
				c -= 13;
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("Pass1 = " + rot13(PASSWORD));
		System.out.println("Pass2 = " + rot13(rot13(PASSWORD)));
		System.out.println("Pass3 = " + rot13(rot13(rot13(PASSWORD))));
		LicenseInfo info = DEcrypter.decode(args[0]);
		System.out.println("License info: \n" + info);
		info.setMonths("9999");
		String newKey = DEcrypter.encode(info);
		System.out.println("New key: \n" + newKey);
		System.out.println("NBkfEAl5OCMUCBU6PSo0Gg8cVDQkOi8uEQg+OHciGRwfOxUHPD0nPgl4eUAzSEhufmFDXklMbnxhSDNKTGcVLwkVASQkIzYDCAkVPiUjTBkLDzJnJBkMCx8nJD4fGRoVIiUjTF9MJGcVZw==JdzlmJX");
		info = DEcrypter.decode(newKey);
		System.out.println("New License info: \n" + info);
		
		
		//info.setVersion("3.1");
		//info.setType(new String(System.currentTimeMillis()));
		//info.setMonths("9999");
		//String s = DEcrypter.rot13(info);
		//System.out.println();
	}


}
