package com.onestoit.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onestoit.mapper.WorkHistoryMapper;
import com.onestoit.model.WorkHistory;
import com.onestoit.service.WorkHistoryService;

@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {
	@Autowired
	WorkHistoryMapper mapper;
	
	@Override
	public int batchSave(ArrayList<WorkHistory> workHistorys) {
		return mapper.batchSave(workHistorys);
	}
}
