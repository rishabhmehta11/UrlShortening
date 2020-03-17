package com.neueda.urlshortening.demo.service;

import java.util.Optional;

import com.neueda.urlshortening.demo.beans.ShorteningUrl;
/**
 * Crating a shortening service interface to call methods for creating, getting,
 * and deleting URL 
 * @author rishabh mehta
 *
 */
public interface ShorteningUrlService {

	public String createShorteningUrl(String originalUrl);
	public Optional<ShorteningUrl> getShortedUrl(String shortUrl);
	public String deleteUrl(String shortUrl);
}
