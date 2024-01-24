package com.onestoit.service;

import org.springframework.transaction.annotation.Transactional;

import com.onestoit.controller.Result;
import com.onestoit.model.Customer;
import com.onestoit.model.CustomerCaseCount;
import com.onestoit.model.PaginationCustReq;
import com.onestoit.model.User;

@Transactional
public interface CustomerService {
	/**
	 * 新規顧客登録
	 * @param c
	 * @return
	 */
	Result save(Customer c);
	
	/**
	 * 新規顧客のユーザ名名既にあるかどうかを調べる
	 * @param username
	 * @return
	 */
	Result alreadyExists(String username);
	
	/**
	 * 顧客ログイン
	 * @param c
	 * @return
	 */
	Result login(User u);
	
	/**
	 * 顧客検索
	 * @param c
	 * @return
	 */
	Result findCustomer(CustomerCaseCount c);
	
	/**
	 * 顧客のページングクエリー
	 * @param c
	 * @return
	 */
	Result findCustomerByPage(PaginationCustReq c);
	
}
