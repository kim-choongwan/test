package com.nudo.gg.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nudo.gg.sample.model.Sample;
import com.nudo.gg.sample.model.SampleCondition;

public interface SampleService {

	/**
	 * 단건조회
	 * @param id
	 * @return
	 */
	Sample get(int id);

	/**
	 * 목록조회
	 * @param condtion
	 * @return
	 */
	List<Sample> search(SampleCondition condtion);

	/**
	 * 추가
	 * @param sample
	 * @return
	 */
	Sample insert(Sample sample);

	/**
	 * 수정
	 * @param sample
	 */
	int update(Sample sample);

	/**
	 * 삭제
	 * @param id
	 */
	int delete(int id);

}
