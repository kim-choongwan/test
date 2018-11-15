package com.nudo.gg.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tree<T> {

	T me; //본인 노드
	Tree<T> father;
	List<Tree<T>> childs = new ArrayList<Tree<T>>(); //자식노드
	
	Object key ;
	Object upperKey;
	Object orderKey;
	
	public Tree(T me, Object key, Object upperKey,Object orderKey) {
		super();
		this.me = me;
		this.key = key;
		this.upperKey = upperKey;
		this.orderKey = orderKey; 
	}
	
	public boolean add(Tree<T> child) {
		if(this.key.equals( child.getUpperKey() )) {
			childs.add(child);
			child.iAmYourFater(this);
			return true;
		}
		return false;
	}

	public Object getKey() {
		return key;
	}

	public Object getUpperKey() {
		return upperKey;
	}
	
	public List<T> getList(){
		List<T> ret = new ArrayList<T>();
		ret.add(me);
		
		childs.sort(new Comparator<Tree<T>>() {
			@Override
			public int compare(Tree<T> o1, Tree<T> o2) {
				if(  o1.orderKey instanceof Integer ) {
					return ((Integer)o1.orderKey) - ((Integer)o2.orderKey);
				}else if( o1.orderKey instanceof Long ) {
					return ((Long)o1.orderKey) >= ((Long)o2.orderKey)? 1:-1;
				}else {
					//TODO 다른타입이 있을 경우 추가하지오.
					throw new RuntimeException("해당 타입을 추가하시오.");
					//return 0;
				}
			}
		});
		
		for (Tree<T> tree : childs) {
			ret.addAll(tree.getList());
		}
		return ret;
	}
	
	void iAmYourFater(Tree<T> father){
		this.father = father;
	};
	
	public boolean isRoot() {
		if (father == null)
			return true;
		return false;
	}
}
