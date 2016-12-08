package com.buss.common.service.impl;

import java.util.List;

import org.jweb.core.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.common.entity.DictType;
import com.buss.common.service.SysServiceI;
import com.buss.common.entity.DictTypegroup;

@Service("sysService")
@Transactional
public class SysServiceImpl extends CommonServiceImpl implements SysServiceI{

	public List<DictType> findDict(String dictGroupCode){
		System.out.println(dictGroupCode+"+++++++++++++++++++++++++++++++++");
		DictTypegroup dictTypegroup = this.findUniqueByProperty(DictTypegroup.class, "typegroupcode", dictGroupCode);
		List<DictType> dictTypeList =  dictTypegroup.getDictTypes();
		return dictTypeList;
	}

}
