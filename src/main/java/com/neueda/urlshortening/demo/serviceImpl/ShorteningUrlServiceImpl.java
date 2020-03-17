package com.neueda.urlshortening.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.neueda.urlshortening.demo.beans.ShorteningUrl;
import com.neueda.urlshortening.demo.dao.ShorterningRepository;
import com.neueda.urlshortening.demo.service.ShorteningUrlService;
import com.neueda.urlshortening.demo.util.Utility;
/**
 * Creating a class to implement the interface and defining the methods
 * @author rishabh mehta
 *
 */
@Service
public class ShorteningUrlServiceImpl implements ShorteningUrlService{

	@Value("${base.url}")
	String BASE_URL;
	
	@Value("${url.prefix}")
	String URL_PREFIX;
	
	@Autowired
	private ShorterningRepository repo;
	
	@Override
	public String createShorteningUrl(String originalUrl) {
	
		//Check for if URL already exit in storage
		ShorteningUrl shortUrl = repo.findByOriginalUrl(originalUrl);
		if(shortUrl != null) {
			
			return "Url already exist with ID: " + 
				BASE_URL.concat(URL_PREFIX).concat(repo.findByOriginalUrl(originalUrl).getShortenedUrl());
		}
		else {
			//saving the original URL user submitted
			shortUrl = repo.save(new ShorteningUrl(originalUrl));
			//Encoding the Original URL to a shorten URL 
			shortUrl.setShortenedUrl(Utility.ENCODE(shortUrl.getUrlId()));
			//Saving the new short url and returning it
			shortUrl = repo.save(shortUrl);
			return BASE_URL.concat(URL_PREFIX).concat(shortUrl.getShortenedUrl());	
		
		}	
	}

	@Override
	public Optional<ShorteningUrl> getShortedUrl(String shortUrl) {

		//Using findbyId function to find a shortened url and 
		//decoding it for user to compare it with original one
		return repo.findById(Utility.DECODE(shortUrl));

	}

	@Override
	public String deleteUrl(String shortUrl) {
		// Creating a try catch block to delete a URL if it exit or will throw an exception
		try {
			//finding url using findbyId method
			ShorteningUrl url = repo.findByShortenedUrl(shortUrl);
			//Deleting URL if exit using deletebyId method of jpa repository
			repo.deleteById(url.getUrlId());
			//Returning Success message to user if deleted	
			return "SUCCESS, deleted URL: " + url.getOriginalUrl();
					
		}catch(Exception e) {
			e.printStackTrace();
			//Sending Failed message to user if URL not found or not deleted
			return "FAILED, Invalid Request (URL does not exist)";
		}
	}

	


}
