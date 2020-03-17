package com.neueda.urlshortening.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neueda.urlshortening.demo.beans.ShorteningUrl;
/**
 * Creating JPA Repository for temporary storage of URL generated 
 * @author rishabh mehta
 *
 */
@Repository
public interface ShorterningRepository extends JpaRepository<ShorteningUrl, Long>{

	ShorteningUrl findByOriginalUrl(String originalUrl);
	ShorteningUrl findByShortenedUrl(String shortUrl);
	
}
