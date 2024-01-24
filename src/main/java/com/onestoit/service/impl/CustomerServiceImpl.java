package com.onestoit.service.impl;

import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.CustomerMapper;
import com.onestoit.model.Customer;
import com.onestoit.model.CustomerCaseCount;
import com.onestoit.model.PaginationCustReq;
import com.onestoit.model.PaginationRes;
import com.onestoit.model.User;
import com.onestoit.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerMapper mapper;
	
	@Override
	public Result save(Customer c) {
		//　パスワード暗号化
		String pwdraw = c.getPassword();
		String pwd = DigestUtils.sha256Hex(pwdraw);
		c.setPassword(pwd);
		
		int res;
		try {
			res = mapper.save(c);
		} catch(Exception e) {
			LOGGER.error("新規顧客情報保存のデータベースのエラーです", e);
			return new Result(Code.SAVE_ERROR, null, "データベースのエラーです");
		}
		return new Result(Code.SAVE_OK, res);
	}

	@Override
	public Result alreadyExists(String username) {
		int res = mapper.alreadyExists(username);
		return new Result(Code.GET_OK, res);
	}

	@Override
	public Result login(User u) {
		Customer res = mapper.login(u);
		return new Result(Code.LOGIN_OK, res);
	}

	@Override
	public Result findCustomer(CustomerCaseCount c) {
		if (c.getCaseCount() == null) {
			c.setCaseCount(0);
		}
		ArrayList<CustomerCaseCount> data = mapper.findCustomer(c);
		return new Result(Code.GET_OK, data);
	}

	@Override
	public Result findCustomerByPage(PaginationCustReq c) {
		PaginationRes<CustomerCaseCount> data = new PaginationRes<>();
		ArrayList<CustomerCaseCount> list = mapper.findCustomerByPage(c);
		data.setList(list);
		CustomerCaseCount ccc = (CustomerCaseCount)c;
		Integer totalCount = mapper.customerCount(ccc);
		data.setTotalCount(totalCount);
		return new Result(Code.GET_OK, data);
	}
}
