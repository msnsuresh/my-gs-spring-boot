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

package com.suresh.cube.v2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.cube.v2.VO.ActorVO;
import com.suresh.cube.v2.VO.Reply;
import com.suresh.cube.v2.VO.SearchDataVO;
import com.suresh.cube.v2.helper.MinDegreeHelper;
import com.suresh.cube.v2.helper.RESTClientHelper;

/**
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DegreeController {
	
	@RequestMapping(value="/getDegree", method=RequestMethod.POST)
	@ResponseBody
	Reply getDegree(@RequestBody SearchDataVO searchData) {
		MinDegreeHelper mdh = new MinDegreeHelper();
		
		return mdh.getMinDegree(searchData.getSource(), searchData.getDestination());
		
	}

}
