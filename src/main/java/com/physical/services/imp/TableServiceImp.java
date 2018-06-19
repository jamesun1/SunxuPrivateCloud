package com.physical.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.physical.mapper.TableinfoMapper;
import com.physical.model.Tableinfo;
import com.physical.services.TableService;
import com.physical.util.ApiResult;
import com.physical.util.LogicalException;

@Service
public class TableServiceImp implements TableService{
	
	@Autowired
	private TableinfoMapper tableinfoMapper;

	@Override
	public ApiResult selectAll(Tableinfo table) throws LogicalException {
		List<Tableinfo> tablelist = tableinfoMapper.selectAllByRole(table);
		return null;
	}

}
