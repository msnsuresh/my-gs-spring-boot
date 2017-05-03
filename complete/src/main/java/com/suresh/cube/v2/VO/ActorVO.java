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
public class ActorVO extends BaseVO {
	
	RoleVO[] movies;

	/**
	 * @return the movies
	 */
	public RoleVO[] getMovies() {
		return movies;
	}

	/**
	 * @param movies 
	 *                 movies to set
	 */
	public void setMovies(RoleVO[] movies) {
		this.movies = movies;
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
		if (!(obj instanceof ActorVO))
			return false;
		ActorVO other = (ActorVO) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
