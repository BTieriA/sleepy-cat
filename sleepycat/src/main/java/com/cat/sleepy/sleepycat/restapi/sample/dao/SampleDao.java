package com.cat.sleepy.sleepycat.restapi.sample.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleDao {

	public List<Map<String, Object>> searchUsers();
}
