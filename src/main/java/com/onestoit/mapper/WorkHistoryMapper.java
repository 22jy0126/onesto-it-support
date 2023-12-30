package com.onestoit.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.onestoit.model.WorkHistory;

@Mapper
public interface WorkHistoryMapper {
	int batchSave(ArrayList<WorkHistory> workHistorys);
}
