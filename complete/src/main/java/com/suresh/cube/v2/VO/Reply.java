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

import java.util.List;

/**
 *
 */
public class Reply {
	
	int level;
	List path;
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level 
	 *                 level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the path
	 */
	public List getPath() {
		return path;
	}
	/**
	 * @param path 
	 *                 path to set
	 */
	public void setPath(List path) {
		this.path = path;
	}
	
	
}
