package com.neueda.urlshortening.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.urlshortening.demo.service.ShorteningUrlService;
/**
 * Main controller class where in calling RestAPI's Post, Get, Delete methods
 * @author rishabh mehta
 *
 */
@RestController
@RequestMapping("/api")
public class MainController {

	//calling Interface 
	@Autowired
	private ShorteningUrlService shortUrlService;
	
	//Trail method to check API is working or not
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hi() {
		return "hello method called";
	}
	
	//Trail method to check API is working or not
	@RequestMapping(value="/hello-post", method=RequestMethod.POST)
	public String hi_post() {
		return "hello post method called";
	}
	
	//Shortening the Url by calling post method
	@RequestMapping(value="/getShortenUrl", method=RequestMethod.POST)
	public ResponseEntity<String> shorteningUrl(@RequestBody String originalUrl){
		
		return ResponseEntity.ok(shortUrlService.createShorteningUrl(originalUrl));
	}
	
	//Getting te url shortened by calling get method
	@RequestMapping(value="/{shortUrl}", method=RequestMethod.GET)
	public String redirectToOriginal(@PathVariable("shortUrl") String shortUrl) {
		 
		return shortUrlService.getShortedUrl(shortUrl).get().getOriginalUrl();				
		 
	}
	
	//Deleting the url if not needed by calling delete method
	@RequestMapping(value="/{shortUrl}", method=RequestMethod.DELETE)
	 public String deleteTutorial(@PathVariable("shortUrl") String shortUrl) {
		
		return shortUrlService.deleteUrl(shortUrl);
	    
	  }
	
}
