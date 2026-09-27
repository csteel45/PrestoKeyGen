package com.jackbe.keygen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Verifies the core license key generation logic in {@link DEcrypter}, since
 * this is the piece PrestoKeyGen actually exists to provide.
 */
public class DEcrypterTest {

	private LicenseInfo buildLicense() {
		LicenseInfo license = new LicenseInfo();
		license.setProduct("PMP");
		license.setEmail("john.crupi@jackbe.com");
		license.setName("John Crupi");
		license.setEdition("D");
		license.setVersion("3.5");
		license.setType("P");
		license.setMonths("365");
		license.setHostname("test-host");
		license.setOptions("mobile=true,sharepoint=false,sharepointcount=0");
		license.setUserLimit(10);
		license.setAnonLimit(5);
		return license;
	}

	@Test
	public void testGeneratedKeyIsNonNullAndValidFormat() {
		String key = DEcrypter.encode(buildLicense());

		assertNotNull("Generated key must not be null", key);
		assertFalse("Generated key must not be empty", key.isEmpty());
		// The key is a Base64 payload followed by a 7 char ROT13'd password
		// suffix, so it should only ever contain Base64 alphabet characters.
		assertTrue("Generated key must be composed of Base64 characters",
				key.matches("^[A-Za-z0-9+/=]+$"));
		assertTrue("Generated key must be longer than the appended password suffix",
				key.length() > 7);
	}

	@Test
	public void testGeneratedKeyRoundTripsBackToOriginalLicenseInfo() {
		LicenseInfo original = buildLicense();
		String key = DEcrypter.encode(original);

		LicenseInfo decoded = DEcrypter.decode(key);

		assertEquals(original.getEmail(), decoded.getEmail());
		assertEquals(original.getName(), decoded.getName());
		assertEquals(original.getProduct(), decoded.getProduct());
		assertEquals(original.getEdition(), decoded.getEdition());
		assertEquals(original.getVersion(), decoded.getVersion());
		assertEquals(original.getHostname(), decoded.getHostname());
		assertEquals(original.getUserLimit(), decoded.getUserLimit());
		assertEquals(original.getAnonLimit(), decoded.getAnonLimit());
	}
}
