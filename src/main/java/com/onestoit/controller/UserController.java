package com.onestoit.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onestoit.model.Customer;
import com.onestoit.model.Employee;
import com.onestoit.model.EmployeeBase;
import com.onestoit.model.User;
import com.onestoit.service.CustomerService;
import com.onestoit.service.EmployeeBaseService;
import com.onestoit.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	EmployeeBaseService employeeBaseService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register/emp/save")
	Result save(@RequestBody Employee e) {
		return employeeService.save(e);
	}
	
	@GetMapping("/register/emp/alreadyExists/{employeeId}")
	Result alreadyExists(@PathVariable String employeeId) {
		return employeeBaseService.alreadyExists(employeeId);
	}
	
	@PostMapping("/register/cst/save")
	Result save(@RequestBody Customer c) {
		return customerService.save(c);
	}
	
	@PostMapping("/register/cst/exists")
	Result alreadyExists(@RequestBody Customer c) {
		return customerService.alreadyExists(c.getUsername());
	}
	
	@PostMapping("/login")
	Result login(@RequestBody User u, HttpSession session) {
		Integer userType = u.getType();
		Result res = null;
		String uname = u.getUsername();
		String pwdraw = u.getPassword();
		if (userType == 3) {  // 管理者の処理
			if (uname == "manager" && pwdraw == "888888") {
				session.setAttribute("userinfo", u);
				res = new Result(Code.LOGIN_OK, u);
			} else {
				res = new Result(Code.LOGIN_ERROR, null, "ユーザー名それともパスワードが間違いました！");
			}
		} else {
			// パスワードの暗号化
			String pwd = DigestUtils.sha256Hex(pwdraw);
			u.setPassword(pwd);
			
			if (userType == 1) {  // 顧客の処理
				res = customerService.login(u);
			} else if (userType == 2) {   // 社員の処理
				res = employeeBaseService.login(u);
			}
			
			if (res.getData() == null) {   // ログイン失敗
				res = new Result(Code.LOGIN_ERROR, null, "ユーザー名それともパスワードが間違いました！");
			} else {                       // ログイン成功
				System.out.println(res.getData());
				session.setAttribute("userinfo", res.getData());
			}
		}
		return res;
	}
	
	@GetMapping("/login/info")
	Result getLoginUser(HttpSession session) {
		User loginUser = (User)session.getAttribute("userinfo");
		Result res = null;
		if (loginUser == null) { // まだログインしていない
			res = new Result(Code.ISNOT_LOGIN, null);
		} else {
			Integer userType = loginUser.getType();
			if (userType == 1) {   // 顧客の処理
				Customer c = (Customer)session.getAttribute("userinfo");
				res = new Result(Code.IS_LOGIN, c);
			} else if (userType == 2) {
				EmployeeBase eb = (EmployeeBase)session.getAttribute("userinfo");
				res = new Result(Code.IS_LOGIN, eb);
			} else {
				res = new Result(Code.IS_LOGIN, loginUser);
			}
		}
		return res;
	}
}
