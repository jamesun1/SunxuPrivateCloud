package com.physical.mapper;

import com.physical.model.Permission;
import com.physical.util.MyMapper;

public interface PermissionMapper extends MyMapper<Permission>{

	void deleteAll();
}