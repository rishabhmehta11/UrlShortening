package com.neueda.urlshortening.demo.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
/****
 * Url shortening entity class
 * @author rishabh mehta
 *
 */
@Entity(name="URL_SHORTENING")
@Table(uniqueConstraints=@UniqueConstraint(columnNames="SHORT_URL", name="short_url_unique_constraint"))
@SequenceGenerator(name="id_gen", sequenceName="id_gen", initialValue=123456789)
public class ShorteningUrl {

	//Creating an entity class with columns for url Id, original Url, encoded short url
	//and with time created
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO ,generator= "id_gen")
	@Column(name="URL_ID")
	private Long urlId;
	
	@Column(name="ORG_URL")
	private String originalUrl;
	
	@Column(name="SHORT_URL")
	private String shortenedUrl;
	
	@CreationTimestamp
	@Column(name="CREATÏON_TIMESTAMP", updatable=false)
	private LocalDateTime creationTimestamp;

	public ShorteningUrl() {}
	
	public ShorteningUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	public ShorteningUrl(String originalUrl, String shortenedUrl) {
		this.originalUrl = originalUrl;
		this.shortenedUrl = shortenedUrl;
	}
	
	public Long getUrlId() {
		return urlId;
	}

	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortenedUrl() {
		return shortenedUrl;
	}

	public void setShortenedUrl(String shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}

	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	
}
