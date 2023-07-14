package com.tutorial.rule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheService {

	@Autowired
	CacheManager cacheManager;

	public void evictAllCaches() {
	    cacheManager.getCacheNames().stream()
	      .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
	}

	@Scheduled(cron = "0 0 0 * * *", zone = "CET")
	public void evictAllcachesAtIntervals() {
		log.info("All in-memory caches are cleared.");
		evictAllCaches();
	}
}
