package com.nudo.gg.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nudo.gg.cmm.exception.BizException;
import com.nudo.gg.sample.mapper.SampleMapper;
import com.nudo.gg.sample.model.Sample;
import com.nudo.gg.sample.model.SampleCondition;
import com.nudo.gg.util.ObjectUtil;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper sampleMapper;
	
	@Override
	public Sample get(Long id) {
		return sampleMapper.get(id);
	}

	@Override
	public List<Sample> search(SampleCondition condtion) {
		return sampleMapper.search(condtion);
	}

	@Override
	public Sample insert(Sample sample) {
		if( ObjectUtil.isNotEmpty(sample.getId()) ) {
			throw new BizException("ERR.COM.001");
		}
		sampleMapper.insert(sample);
		return sampleMapper.get(sample.getId());
	}

	@Override
	public int update(Sample sample) {
		if( ObjectUtil.isEmpty(sample.getId()) ) {
			throw new BizException("ERR.COM.002");
		}
		return sampleMapper.update(sample);
	}

	@Override
	public int delete(Long id) {
		if( ObjectUtil.isEmpty(id) ) {
			throw new BizException("ERR.COM.002");
		}
		return sampleMapper.delete(id);
	}

	@Override
	public void setList(List<Sample> samples) {
		
		for (Sample sample : samples) {
			if ( sample.isToInsert() ) {
				this.insert(sample);
			}else if( sample.isToUpdate() ) {
				this.update(sample);
			}else if( sample.isToDelete() ) {
				this.delete(sample.getId());
			}
		}
		
	}

}
