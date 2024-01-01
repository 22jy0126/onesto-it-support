package com.onestoit.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.Customer;
import com.onestoit.model.User;

@Mapper
public interface CustomerMapper {
	/**
	 * 新規顧客の情報を保存
	 * @param c
	 * @return
	 */
	int save(Customer c);
	
	/**
	 * 新規顧客のユーザ名名既にあるかどうかを調べる
	 * @param username
	 * @return
	 */
	int alreadyExists(String username);
	
	/**
	 * 顧客ログイン
	 * @return
	 */
	Customer login(User u);
}
