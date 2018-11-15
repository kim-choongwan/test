package com.nudo.gg.sample.service;

import java.util.List;

import com.nudo.gg.sample.model.TreeSample;
import com.nudo.gg.sample.model.TreeSampleCondition;


public interface TreeSampleService {

	/**
	 * 단건조회
	 * @param id
	 * @return
	 */
	TreeSample get(TreeSample treeSample);

	/**
	 * 목록조회
	 * @param condtion
	 * @return
	 */
	List<TreeSample> search(TreeSampleCondition treeSampleCondtion);

	/**
	 * 추가
	 * @param sample
	 * @return
	 */
	TreeSample insert(TreeSample treeSample);

	/**
	 * 수정
	 * @param sample
	 */
	int update(TreeSample treeSample);

	/**
	 * 삭제
	 * @param id
	 */
	int delete(TreeSample treeSample);

	/**
	 * 목록저장
	 * @param samples
	 * @return
	 */
	void setList(List<TreeSample> treeSamples);

	List<TreeSample> searchNodes(Long seq);

}
