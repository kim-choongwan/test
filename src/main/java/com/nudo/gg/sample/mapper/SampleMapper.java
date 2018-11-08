package com.nudo.gg.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nudo.gg.sample.model.Sample;
import com.nudo.gg.sample.model.SampleCondition;

@Mapper
public interface SampleMapper {

	Sample get(int id);

	List<Sample> search(SampleCondition condtion);

	void insert(Sample sample);

	int update(Sample sample);

	int delete(int id);
	
}
