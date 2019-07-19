package com.cat.sleepy.sleepycat.restapi.sample.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cat.sleepy.sleepycat.restapi.sample.dto.SampleDto;

@Mapper
public interface SampleDao {

	public List<SampleDto> searchUsers();
	public List<Map<String, Object>> searchUsers1();
}
