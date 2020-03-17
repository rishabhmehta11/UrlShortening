package com.neueda.urlshortening.demo.util;

/**
 * Creating a Utility class where calling Encode and decode method for URL Shortening 
 * Using Hashing for encoding and decoding the URL, with base as 62
 * @author rishabh mehta
 *
 */
public class Utility {

	//Calling out all possible letters for shorten url and totaling the length
	public static final String POSSIBLE_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final long HASH_BASE = POSSIBLE_ALPHABET.length();
	
	public static final String ENCODE(Long urlId) {
		StringBuilder shorteningUrl = new StringBuilder();
		while(urlId > 0) {
			shorteningUrl.insert(0, POSSIBLE_ALPHABET.charAt( (int)(urlId % HASH_BASE) ));
			urlId /= HASH_BASE;
			
		}
		return shorteningUrl.toString();
		
	}
	public static final Long DECODE(String shortUrl) {
		long urlId = 0;
		for(int i= 0; i < shortUrl.length(); i++) {
			urlId = urlId * HASH_BASE + POSSIBLE_ALPHABET.indexOf(shortUrl.charAt(i)); 
		}
		
		return urlId;
		
	}
}
