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
public class Node {
	
	ActorVO personalInfo;
	String personalRole;
	
	Node parentInfo;
	String parentRole;
	
	String commonMovieUrlName;
	String commonMovieName;
	
	public Node(ActorVO actor) {
		this.personalInfo = actor;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getPersonalInfo().getUrl();
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
		if (!(obj instanceof Node))
			return false;
		Node other = (Node) obj;
		if (personalInfo.url == null) {
			if (other.personalInfo.url != null)
				return false;
		} else if (!personalInfo.url.equals(other.personalInfo.url))
			return false;
		return true;
	}
	
	/**
	 * @return the personalInfo
	 */
	public ActorVO getPersonalInfo() {
		return personalInfo;
	}
	/**
	 * @param personalInfo 
	 *                 personalInfo to set
	 */
	public void setPersonalInfo(ActorVO personalInfo) {
		this.personalInfo = personalInfo;
	}
	/**
	 * @return the personalRole
	 */
	public String getPersonalRole() {
		return personalRole;
	}
	/**
	 * @param personalRole 
	 *                 personalRole to set
	 */
	public void setPersonalRole(String personalRole) {
		this.personalRole = personalRole;
	}
	/**
	 * @return the parentInfo
	 */
	public Node getParentInfo() {
		return parentInfo;
	}
	/**
	 * @param parentInfo 
	 *                 parentInfo to set
	 */
	public void setParentInfo(Node parentInfo) {
		this.parentInfo = parentInfo;
	}
	/**
	 * @return the parentRole
	 */
	public String getParentRole() {
		return parentRole;
	}
	/**
	 * @param parentRole 
	 *                 parentRole to set
	 */
	public void setParentRole(String parentRole) {
		this.parentRole = parentRole;
	}
	/**
	 * @return the commonMovieUrlName
	 */
	public String getCommonMovieUrlName() {
		return commonMovieUrlName;
	}
	/**
	 * @param commonMovieUrlName 
	 *                 commonMovieUrlName to set
	 */
	public void setCommonMovieUrlName(String commonMovieUrlName) {
		this.commonMovieUrlName = commonMovieUrlName;
	}
	/**
	 * @return the commonMovieName
	 */
	public String getCommonMovieName() {
		return commonMovieName;
	}
	/**
	 * @param commonMovieName 
	 *                 commonMovieName to set
	 */
	public void setCommonMovieName(String commonMovieName) {
		this.commonMovieName = commonMovieName;
	}
	
	
	

}
