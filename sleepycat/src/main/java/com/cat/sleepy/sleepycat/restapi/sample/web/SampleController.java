package com.cat.sleepy.sleepycat.restapi.sample.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.sleepy.sleepycat.restapi.sample.svc.SampleService;

@Controller
public class SampleController {

	@Autowired
	SampleService sampleService;
	
	@RequestMapping(value="/sleepycat/search", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> searchSample() {
		return sampleService.searchUsers();
	}
}
