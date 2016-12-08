package com.buss.common.service;

import java.util.List;

import com.buss.resume.resume.entity.ResumeEntity;
import org.jweb.core.service.CommonService;

import com.buss.common.entity.DictType;

public interface SysServiceI extends CommonService{
	public List<DictType> findDict(String dictGroupCode);
}
