package com.nudo.gg.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nudo.gg.sample.model.TreeSample;
import com.nudo.gg.sample.model.TreeSampleCondition;

@Mapper
public interface TreeSampleMapper {

	TreeSample get(TreeSample treeSample);

	List<TreeSample> search(TreeSampleCondition treeSampleCondition);

	void insert(TreeSample treeSample);

	int update(TreeSample treeSample);

	int delete(TreeSample treeSample);
	
	TreeSample getUpperSeq(Long upperSeq);

	void updateMeta(Long upperSeq);
	
	List<TreeSample> search(Long seq);
	
	void adjustMeta();

	List<TreeSample> searchNodes(Long seq);
	
}
