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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale.LanguageRange;

import com.suresh.cube.v2.VO.ActorVO;
import com.suresh.cube.v2.VO.Entity;
import com.suresh.cube.v2.VO.FilmVO;
import com.suresh.cube.v2.VO.Node;
import com.suresh.cube.v2.VO.Reply;
import com.suresh.cube.v2.VO.RoleVO;

/**
 *
 */
public class MinDegreeHelper {
	
	LinkedList<Node> queue1 = new LinkedList<Node>();
	LinkedList<Node> queue2 = new LinkedList<Node>();
	LinkedList<String> visitedNode1 = new LinkedList<String>();
	LinkedList<String> visitedFilms1 = new LinkedList<String>();
	LinkedList<String> visitedNode2 = new LinkedList<String>();
	LinkedList<String> visitedFilms2 = new LinkedList<String>();
	
	private LinkedList<Node> getConnections(LinkedList<Node> list, LinkedList<String> visitedNode, LinkedList<String> visitedFilms) {		
		
		// Iterate each item in queue
		// For each item
		// get list of movies actor acted
		// with list of movies, get list of connections
		// stuff the parent-child relation details into the node
		// add to the return list
		
		LinkedList<Node> newQueue = new LinkedList<Node>();
		LinkedList<String> newQueueString = new LinkedList<String>();
		RoleVO[] moviesList = null;
		FilmVO film = null;
		HashMap<String, Node> castCrewList = new HashMap<String, Node>();
		Node tempNode = null;
		ActorVO tempActor = null;
		
		
		for(Node node : list) {
			if(!visitedNode.contains(node.getPersonalInfo().getUrl())) {
				visitedNode.add(node.getPersonalInfo().getUrl());
				moviesList = node.getPersonalInfo().getMovies();
				for(RoleVO movie : moviesList) {
					if(!visitedFilms.contains(movie.getUrl())) {
						film = RESTClientHelper.getForFlim(movie.getUrl());
						if(film != null) visitedFilms.add(movie.getUrl());
						
						if(film != null && film.getCast() != null) {
							RoleVO[] castMemebrsList = film.getCast();
							
							for(RoleVO castMember : castMemebrsList) {
								if(castMember.getUrl().equals(node.getPersonalInfo().getUrl())) {
									node.setPersonalRole(castMember.getRole());
									break;
								}
							}
							
							for(RoleVO castMember : castMemebrsList) {
								if(!visitedNode.contains(castMember.getUrl()) && !newQueueString.contains(castMember.getUrl())) {
									tempActor = RESTClientHelper.getForActor(castMember.getUrl());
									if(tempActor != null) {
										tempNode = new Node(tempActor);
										tempNode.setPersonalRole(castMember.getRole());
										
										tempNode.setParentInfo(node);
										tempNode.setParentRole(node.getPersonalRole());
										
										tempNode.setCommonMovieUrlName(film.getUrl());
										tempNode.setCommonMovieName(film.getName());
										
										newQueue.add(tempNode);
										newQueueString.add(castMember.getUrl());
									}
								}
							}
							
						}
						
						//TODO craete function
						if(film != null && film.getCrew() != null) {
							RoleVO[] crewMemebrsList = film.getCrew();
							
							for(RoleVO crewMember : crewMemebrsList) {
								if(crewMember.getUrl().equals(node.getPersonalInfo().getUrl())) {
									node.setPersonalRole(crewMember.getRole());
									break;
								}
							}
							
							for(RoleVO crewMember : crewMemebrsList) {
								if(!visitedNode.contains(crewMember.getUrl()) && !newQueueString.contains(crewMember.getUrl())) {
									tempActor = RESTClientHelper.getForActor(crewMember.getUrl());
									if(tempActor != null) {
										tempNode = new Node(tempActor);
										tempNode.setPersonalRole(crewMember.getRole());
										
										tempNode.setParentInfo(node);
										tempNode.setParentRole(node.getPersonalRole());
										
										tempNode.setCommonMovieUrlName(film.getUrl());
										tempNode.setCommonMovieName(film.getName());
										
										newQueue.add(tempNode);
										newQueueString.add(crewMember.getUrl());
									}
								}
							}
							
						}
					}
				}
			}
		}
		
		return newQueue;
	}
	
	private Reply isQueuesIntersecting(LinkedList<Node> list1, LinkedList<Node> list2, int degree) {
		
		for(Node node1 : list1) {
			for(Node node2 : list2) {
				if(node2.toString().equals(node1.toString()))
					if(degree != 1) {
						return mergeNodes(node1, node2, degree);
					} else {
						return replyNode(node1);
					}
//					return true;
			}
		}
		
		
		return null;
	}
	
	private Reply replyNode(Node node1) {
		Reply reply = new Reply();
		LinkedList<LinkedList<Entity>> path = new LinkedList<>();
		reply.setLevel(1);
		
		Entity movie = new Entity(node1.getCommonMovieName(), "Movie");
		Entity parent = new Entity(node1.getParentInfo().getPersonalInfo().getName(), node1.getParentInfo().getPersonalRole());
		Entity current = new Entity(node1.getPersonalInfo().getName(), node1.getPersonalRole());
		
		LinkedList<Entity> tempList = new LinkedList<>();
		tempList.add(movie);
		tempList.add(parent);
		tempList.add(current);
		
		path.add(tempList);
		
		reply.setPath(path);
		return reply;
	}
	
	private Reply mergeNodes(Node node1, Node node2, int degree) {
		
		Reply reply = new Reply();
		LinkedList<LinkedList<Entity>> path = new LinkedList<>();
		reply.setLevel(degree);
		
		Node temp = node1;
		while(temp.getParentInfo() != null) {
			Entity movie = new Entity(temp.getCommonMovieName(), "Movie");
			Entity parent = new Entity(temp.getParentInfo().getPersonalInfo().getName(), temp.getParentInfo().getPersonalRole());
			Entity current = new Entity(temp.getPersonalInfo().getName(), temp.getPersonalRole());
			
			LinkedList<Entity> tempList = new LinkedList<>();
			tempList.add(movie);
			tempList.add(parent);
			tempList.add(current);
			
			path.add(tempList);
			temp = temp.getParentInfo();
		}
		
		temp = node2;
		while(temp.getParentInfo() != null) {
			Entity movie = new Entity(temp.getCommonMovieName(), "Movie");
			Entity parent = new Entity(temp.getParentInfo().getPersonalInfo().getName(), temp.getParentInfo().getPersonalRole());
			Entity current = new Entity(temp.getPersonalInfo().getName(), temp.getPersonalRole());
			
			LinkedList<Entity> tempList = new LinkedList<>();
			tempList.add(movie);
			tempList.add(parent);
			tempList.add(current);
			
			path.add(tempList);
			temp = temp.getParentInfo();
		}
		
		reply.setPath(path);
		return reply;
	}
	
	public Reply getMinDegree(String source, String destination) {
		
		Reply replyNode = new Reply();
		replyNode.setLevel(0);
		replyNode.setPath(new LinkedList<>());
		int degree;
		
		ActorVO sourceNode = RESTClientHelper.getForActor(source);
		ActorVO destinationNode = RESTClientHelper.getForActor(destination);
		
		if(sourceNode == null || destinationNode == null) {
			return replyNode;
		}
		
		queue1.add(new Node(sourceNode));
		
		queue2.add(new Node(destinationNode));
		
		degree = 1;
		
		while(!queue1.isEmpty() && !queue2.isEmpty()) {
			queue1 = getConnections(queue1, visitedNode1, visitedFilms1);
			replyNode = isQueuesIntersecting(queue1, queue2, degree);
			if(replyNode != null) {
				return replyNode;
			}
			degree += 1;
			
			queue2 = getConnections(queue2, visitedNode2, visitedFilms2);
			replyNode = isQueuesIntersecting(queue1, queue2, degree);
			if(replyNode != null) {
				return replyNode;
			}
			degree += 1;
		}
		
		replyNode = new Reply();
		replyNode.setLevel(0);
		replyNode.setPath(new LinkedList<>());
		return replyNode;
	}

}
