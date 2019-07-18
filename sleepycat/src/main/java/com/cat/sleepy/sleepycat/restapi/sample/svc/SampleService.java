package com.cat.sleepy.sleepycat.restapi.sample.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.sleepy.sleepycat.restapi.sample.dao.SampleDao;

@Service
public class SampleService {

	@Autowired
	SampleDao sampleDao;
	
	public List<Map<String, Object>> searchUsers() {
		return sampleDao.searchUsers();
	}
}
