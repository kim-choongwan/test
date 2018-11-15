package com.nudo.gg.sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nudo.gg.cmm.exception.BizException;
import com.nudo.gg.sample.mapper.TreeSampleMapper;
import com.nudo.gg.sample.model.TreeSample;
import com.nudo.gg.sample.model.TreeSampleCondition;
import com.nudo.gg.util.TreeUtil;

@Service
public class TreeSampleServiceImpl implements TreeSampleService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TreeSampleMapper treeSampleMapper;
	
	@Override
	public TreeSample get(TreeSample treeSample) {
		return treeSampleMapper.get(treeSample);
	}

	@Override
	public List<TreeSample> search(TreeSampleCondition treeSampleCondtion) {
		return treeSampleMapper.search(treeSampleCondtion);
	}

	@Override
	public TreeSample insert(TreeSample treeSample) {
		this.insertOnly(treeSample);
		this.adjustMeta();
		return treeSampleMapper.get(treeSample); 
	}
	
	private void insertOnly(TreeSample treeSample) {
		if(treeSample.getLvl() == null ) {
			treeSample.setLvl(0);
		}
		if(treeSample.getLeafYn() == null ) {
			treeSample.setLeafYn("");
		}
		treeSample.setRegId("SYSTEM");
		treeSampleMapper.insert(treeSample);
	}

	@Override
	public int update(TreeSample treeSample) {
		int ret = updateOnly(treeSample);
		this.adjustMeta();
		return ret;
	}

	public int updateOnly(TreeSample treeSample) {
		treeSample.setUpdId("SYSTEM");
		if(treeSample.getLvl() == null ) {
			treeSample.setLvl(0);
		}
		if(treeSample.getLeafYn() == null ) {
			treeSample.setLeafYn("");
		}
		return treeSampleMapper.update(treeSample); //수정
	}
	
	@Override
	public int delete(TreeSample treeSample) {
		int ret = deleteOnly(treeSample);
		this.adjustMeta();
		return ret; 
	}

	public int deleteOnly(TreeSample treeSample) {
		return treeSampleMapper.delete(treeSample); //삭제
	}

	
	/**
	 * 해당노드의 말단여부, 레벨을 정리한다.
	 * @param seq
	 */
	private void updateMeta(Long seq) {
		treeSampleMapper.updateMeta(seq); //해당노드의 말단여부정리
	}
	
	/**
	 * 데이터의 구조 변경으로 인해 틀어진 lvl, 말단여부를 보정하여 update한다.
	 */
	private void adjustMeta() {
		treeSampleMapper.adjustMeta();
	}
	
	
	@Override
	public void setList(List<TreeSample> treeSamples) {
		
		Map<Integer, Long> seqs = new HashMap<Integer, Long>(); //상위시퀀스를 찾기 위한 map, (LEVEL vs SEQ)
		TreeSample current;
		TreeSample before = null;
		Integer rootLvl = null; //루트의 레벨
		for (int i = 0; i < treeSamples.size(); i++) {
			
			//순회시작
			current = treeSamples.get(i);
			if(i==0) { //첫로우. 그러므로 root (혹은 roots의 하나)
				rootLvl = current.getLvl();
				seqs.put(rootLvl-1,current.getUpperSeq());//루트의 상위노드 설정
			}else {
				//행이 바뀌면서 레벨은 두단계이하로 떨어질 수는 없다.
				if(before.getLvl()+1>current.getLvl()) {
					throw new BizException("COM.ERR.003");
				}
			}
			
			long upperSeq = seqs.get(current.getLvl()-1);
			
			//CRUD
			if(current.isToInsert()) {
				current.setUpperSeq(upperSeq);
				this.insertOnly(current);
			}else if (current.isToUpdate()) {
				if(current.getUpperSeq() !=  upperSeq && current.getUpperSeq() != 0L ) {// 다른 레벨에서 0Lvl로 떨어지는 경우 때문에 0L은 혀용..
					throw new BizException("COM.ERR.004"); //부정확한 UPPER_SEQ 가 들어 왔을 경우. 에러 발생. 
				}
				this.updateOnly(current);
			}else if (current.isToDelete()) {
				this.deleteOnly(current);
			};
			
			//다음행 준비
			seqs.put(current.getLvl() , current.getSeq());
			before = current;
		}
		
		this.adjustMeta();
		
	}

	@Override
	public List<TreeSample> searchNodes(Long seq) {
		
		List<TreeSample> list = treeSampleMapper.searchNodes(seq);
		return TreeUtil.sort(list, "seq", "upperSeq", "ord"); //재정렬

	}

}
