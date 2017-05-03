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

package com.suresh.cube.v2.helper;

import java.net.URI;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.suresh.cube.v2.VO.ActorVO;
import com.suresh.cube.v2.VO.FilmVO;

/**
 *
 */
public class RESTClientHelper {
	
	private static RestTemplate restTemplate;
	
	static {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
	            HttpClientBuilder.create().build());
		restTemplate = new RestTemplate(clientHttpRequestFactory);
	}
	
	public static FilmVO getForFlim(String filmUrlName) {
		try {
			return restTemplate.getForObject(new URI("http://data.moviebuff.com/" + filmUrlName), FilmVO.class);
		} catch (Exception e) { }
		return null;
	}
	
	public static ActorVO getForActor(String actorUrlName) {
		try {
			return restTemplate.getForObject(new URI("http://data.moviebuff.com/" + actorUrlName), ActorVO.class);
		} catch (Exception e) { }
		return null;
	}

}
