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
public class FilmVO extends BaseVO {
	
	RoleVO[] cast;
	RoleVO[] crew;
	
	/**
	 * @return the cast
	 */
	public RoleVO[] getCast() {
		return cast;
	}
	/**
	 * @param cast 
	 *                 cast to set
	 */
	public void setCast(RoleVO[] cast) {
		this.cast = cast;
	}
	/**
	 * @return the crew
	 */
	public RoleVO[] getCrew() {
		return crew;
	}
	/**
	 * @param crew 
	 *                 crew to set
	 */
	public void setCrew(RoleVO[] crew) {
		this.crew = crew;
	}

}
