package com.nudo.gg.util;

import java.util.ArrayList;
import java.util.List;

import com.nudo.gg.cmm.exception.BizException;

public class TreeUtil {
	
	/**
	 * 해당 List를 tree형태로 정렬한다. 오라클의 ORDER SIBLINGS BY 와 같은 역활을 한다. 
	 * @param list
	 * @param key
	 * @param upperKey
	 * @param ordKey
	 * @return
	 */
	public static <T> List<T> sort(List<T> list,String key, String upperKey, String ordKey) {
		
		TreeFactory<T> factory = new TreeFactory<T>(key, upperKey, ordKey);
		
		List<Tree<T>> treeList = new ArrayList<Tree<T>>();
		for (T o : list) {
			treeList.add(factory.create(o));
		}//모두 TreeNode화 하여 treeList에 적재
		
		for (Tree<T> child : treeList) {
			TreeUtil.append(treeList, child);
		}//하위노드를 상위노드로 모두 append

		List<T> ret = new ArrayList<T>();
		for (Tree<T> child : treeList) {
			if(child.isRoot()) {
				ret.addAll(child.getList());
			}
		}
		
		return ret;
	}
	
	
	private static <T> boolean append(List<Tree<T>> treeList,Tree<T> child) {
		
		for (Tree<T> parent : treeList) {
			if(parent.getKey().equals(child.getUpperKey())) {
				return parent.add(child);
			};
		}
		
		return false;
	}
}
