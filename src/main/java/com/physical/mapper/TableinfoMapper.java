package com.physical.mapper;

import java.util.List;

import com.physical.model.Tableinfo;
import com.physical.util.MyMapper;

public interface TableinfoMapper extends MyMapper<Tableinfo>{

	List<Tableinfo> selectAllByRole(Tableinfo table);
}