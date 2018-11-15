package com.nudo.gg.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.nudo.gg.cmm.exception.BizException;

public class TreeFactory<T> {

	private String key;
	private String upperKey;
	private String orderKey;

	private String getterKey;
	private String getterUpperKey;
	private String getterOrderKey;

	public TreeFactory(String key, String upperKey, String orderKey) {

		this.key = key;
		this.upperKey = upperKey;
		this.orderKey = orderKey;

		this.getterKey = "get" + this.key.substring(0, 1).toUpperCase() + this.key.substring(1, this.key.length());
		this.getterUpperKey = "get" + this.upperKey.substring(0, 1).toUpperCase()
				+ this.upperKey.substring(1, this.upperKey.length());
		this.getterOrderKey = "get" + this.orderKey.substring(0, 1).toUpperCase()
				+ this.orderKey.substring(1, this.orderKey.length());

	}

	public Tree<T> create(T t) {

		try {
			
			Method method1 = t.getClass().getMethod(getterKey);
			Object key = method1.invoke(t);
			Method method2 = t.getClass().getMethod(getterUpperKey);
			Object upperKey = method2.invoke(t);
			Method method3 = t.getClass().getMethod(getterOrderKey);
			Object orderKey = method3.invoke(t);
			return new Tree<T>(t, key, upperKey,orderKey);
			
		} catch (Exception e) {
			throw new BizException("ERR.COM.005",e);
		}
		
	};

}
