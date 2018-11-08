package com.nudo.gg.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nudo.gg.sample.mapper.SampleMapper;
import com.nudo.gg.sample.model.Sample;
import com.nudo.gg.sample.model.SampleCondition;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;
	
	@Override
	public Sample get(int id) {
		return sampleMapper.get(id);
	}

	@Override
	public List<Sample> search(SampleCondition condtion) {
		return sampleMapper.search(condtion);
	}

	@Override
	public Sample insert(Sample sample) {
		sampleMapper.insert(sample);
		return sampleMapper.get(sample.getID());
	}

	@Override
	public int update(Sample sample) {
		return sampleMapper.update(sample);
	}

	@Override
	public int delete(int id) {
		return sampleMapper.delete(id);
	}

}
