package com.onestoit.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.CustomerMapper;
import com.onestoit.model.Customer;
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

}
