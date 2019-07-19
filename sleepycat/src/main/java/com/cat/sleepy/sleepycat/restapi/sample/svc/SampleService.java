package com.cat.sleepy.sleepycat.restapi.sample.svc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.sleepy.sleepycat.restapi.sample.dao.SampleDao;
import com.cat.sleepy.sleepycat.restapi.sample.dto.SampleDto;

@Service
public class SampleService {

	@Autowired
	SampleDao sampleDao;
	
	public List<SampleDto> searchUsers() {
		List<SampleDto> list = sampleDao.searchUsers();
		System.out.println("1111");
		return list;
	}
	
	public List<Map<String, Object>> searchUsers1() {
		List<Map<String, Object>> list = sampleDao.searchUsers1();
		System.out.println("1111");
		return list;
	}
}
