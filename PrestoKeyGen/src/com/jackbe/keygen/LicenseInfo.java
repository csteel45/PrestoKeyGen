/*
 * Copyright (c) 2006 JackBe Corporation, 4600 North Park Avenue, Suite 200,
 * Chevy Chase, MD 20815. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of JackBe
 * Corporation ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with JackBe.
 * 
 * JACKBE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT. JACKBE SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 * 
 * @author Girish Ippadi @date Oct 9, 2008
 */

package com.jackbe.keygen;

import java.util.HashMap;

public class LicenseInfo {
	private String product; 
	private String edition; 
	private String version; 
	private String type; // P or T (Permanent or Temporary)
	private String  months; 
	private String email; 
	private String name;
	private String key;
	
	// 3.0
	private String options;
	private int userLimit;
	private int anonLimit;
	private String hostname;
	
	boolean status = false;
	
	private static HashMap<String, String> mappings;
	static {
		mappings = new HashMap<String, String>();
		mappings.put("PMP", "Presto Mashup Platform"); // product name

		// 
		mappings.put("D", "Developer"); 
		mappings.put("E", "Enterprise");
		mappings.put("W", "Workgroup");

		// types
		mappings.put("T", "Evaluation"); // temporary
		mappings.put("P", "Permanent");
		mappings.put("F", "Permanent");
	}
	
	public LicenseInfo() {
	}
	
	public LicenseInfo(String product, String edition, String version, String type, String months, String email, String name) {
		this.product=product;
		this.edition=edition;
		this.version=version;
		this.type=type;
		this.months=months;
		this.email=email;
		this.name=name;
	}

	public LicenseInfo(String product, String edition, String version, String type, String months, String email, String name, String options, String hostname, int userLimit, int anonLimit) {
		this(product, edition, version, type, months, email, name);
		this.options = options;
		this.hostname = hostname;
		this.userLimit = userLimit;
		this.anonLimit = anonLimit;
	}

	public static String getMappedValue(String key) {
		if(mappings.containsKey(key)) {
			return (String) mappings.get(key);
		}
		return key;
	}
	
	public boolean isValid() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEdition() {
		if(mappings.containsKey(edition)) {
			return (String)mappings.get(edition);
		}
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		if(months==null || months.trim().length()==0) 
			this.months = "0";
		else 
			this.months = months;
	}
	public String getProduct() {
		if(mappings.containsKey(product)) {
			return (String) mappings.get(product);
		}
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getType() {
		if(mappings.containsKey(type)) {
			return (String) mappings.get(type);
		}
		return type;
	}
	public void setType(String type) {
		if(type==null || type.trim().length()==0) 
			this.type = "P";
		else 
			this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	} 

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getUserLimit() {
		return userLimit;
	}

	public void setUserLimit(int userLimit) {
		this.userLimit = userLimit;
	}

	public int getAnonLimit() {
		return anonLimit;
	}

	public void setAnonLimit(int anonLimit) {
		this.anonLimit = anonLimit;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer(128)
		.append(email).append("^")
		.append(name).append("^")
		.append(product).append("^")
		.append(edition).append("^")
		.append(version).append("^")
		.append(type).append("^")
		.append(months);
		
		if(Float.parseFloat(version) > 2.7) {
			sb.append("^")
			.append(hostname).append("^")
			.append(options).append("^")
			.append(userLimit).append("^")
			.append(anonLimit);
		}
		return sb.toString();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
