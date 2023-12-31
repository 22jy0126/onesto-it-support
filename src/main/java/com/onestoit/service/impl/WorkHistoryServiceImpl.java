package com.onestoit.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.controller.Code;
import com.onestoit.controller.Result;
import com.onestoit.mapper.WorkHistoryMapper;
import com.onestoit.model.WorkHistory;
import com.onestoit.service.WorkHistoryService;

@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {
	@Autowired
	WorkHistoryMapper mapper;
	
	@Override
	public Result batchSave(ArrayList<WorkHistory> workHistorys) {
		int res;
		try {
			res = mapper.batchSave(workHistorys);
		} catch (Exception e) {
			return new Result(Code.SAVE_ERROR, null, "データベースのエラーです");
		}
		return new Result(Code.SAVE_OK, res);
	}
}
