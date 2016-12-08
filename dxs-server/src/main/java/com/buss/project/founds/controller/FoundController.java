package com.buss.project.founds.controller;
import com.buss.common.service.SysServiceI;
import com.buss.project.foundcases.entity.FoundCaseEntity;
import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.founds.trans.form.FoundSearchForm;
import com.buss.project.founds.trans.vo.FoundVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/found")
public class FoundController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode foundPageList(FoundSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<FoundEntity> found = mode.getResult();

		List<FoundVO> foundVOs = new ArrayList<FoundVO>();

		for (FoundEntity foundEntity:found) {
			FoundVO foundVO = new FoundVO();
			foundVO.copyEntity(foundEntity);
			FoundCaseEntity foundCaseEntity = new FoundCaseEntity();
			foundCaseEntity.setIsDelete(0);
			foundCaseEntity.setDfId(foundVO.getId());
			List foundCaseList = this.sysService.findByExample(FoundCaseEntity.class.getName(),foundCaseEntity);
			if(foundCaseList!=null&&foundCaseList.size()!=0){
				String excaptionName = "";
				for (Object o:foundCaseList) {
					FoundCaseEntity foundCase = (FoundCaseEntity)o;
					String name = foundCase.getDfName();
					excaptionName = excaptionName + " " + name;

				}
				foundVO.setFoundException(excaptionName);
			}
			foundVOs.add(foundVO);

		}

		mode.setResult(foundVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/foundById.do")
	@ResponseBody
	public ReplyDataMode foundById (FoundSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<FoundEntity> founds = this.sysService.list(criteriaQuery);
		List<FoundVO> foundVOs = new ArrayList<FoundVO>();

		for (FoundEntity foundEntity : founds) {
			FoundVO foundVO = new FoundVO();
			foundVO.copyEntity(foundEntity);
			FoundCaseEntity foundCaseEntity = new FoundCaseEntity();
			foundCaseEntity.setIsDelete(0);
			foundCaseEntity.setDfId(foundVO.getId());
			List foundCaseList = this.sysService.findByExample(FoundCaseEntity.class.getName(),foundCaseEntity);
			if(foundCaseList!=null&&foundCaseList.size()!=0){

				List list = new ArrayList();
				String excaptionName = "";
				for (Object o:foundCaseList) {
					Map images = new HashMap();
					FoundCaseEntity foundCase = (FoundCaseEntity)o;
					String imgUrl = foundCase.getDfImgUrl();
					images.put("image",imgUrl);
					String name = foundCase.getDfName();
					images.put("name",name);
					excaptionName = excaptionName + " " + name;
					list.add(images);

				}
				foundVO.setFoundException(excaptionName);
				foundVO.setExceptionList(list);
			}

			//项目所在地址
			if(foundVO.getFoundAddress()!=null&&!"".equals(foundVO.getFoundAddress())){

				String address = foundVO.getFoundAddress().replace("#","");
				foundVO.setFoundAddress(address);
			}
			foundVOs.add(foundVO);

		}
		replyDataMode.setData(foundVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}