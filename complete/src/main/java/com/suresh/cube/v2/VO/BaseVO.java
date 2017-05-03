/**
 * ================================================================================================
 *                                Copyright (C) Hospira, Inc.
 *                                    All rights reserved
 * ================================================================================================
 * Notice:  All Rights Reserved.
 * This material contains the trade secrets and confidential information of Hospira, Inc., which 
 * embody substantial creative effort, ideas and expressions. No part of this material may be 
 * reproduced or transmitted in any form or by any means, electronic, mechanical, optical or 
 * otherwise, including photocopying and recording, or in connection with any information storage 
 * or retrieval system, without written permission from:
 * 
 * Hospira, Inc.
 * 13520 Evening Creek Dr., Suite 200
 * San Diego, CA 92128
 * www.hospira.com
 * ================================================================================================
 */

package com.suresh.cube.v2.VO;

/**
 *
 */
public class BaseVO {
	
	String url;
	String name;
	String type;
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url 
	 *                 url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 
	 *                 name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type 
	 *                 type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseVO))
			return false;
		BaseVO other = (BaseVO) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
