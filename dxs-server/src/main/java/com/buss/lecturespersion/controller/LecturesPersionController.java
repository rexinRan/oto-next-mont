package com.buss.lecturespersion.controller;


import com.buss.common.service.SysServiceI;
import com.buss.lectures.entity.LecturesEntity;
import com.buss.lectures.trans.from.LecturesFrom;
import com.buss.lectures.trans.vo.LecturesVo;
import com.buss.lecturespersion.entity.LecturesPersionEntity;
import com.buss.lecturespersion.trans.from.LecturesPersionFrom;
import com.buss.lecturespersion.trans.vo.LecturesPersionVo;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/LecturesPersionController")
public class LecturesPersionController{

	@Autowired
	private SysServiceI sysServiceI;

	/**
	 * 名师巡讲>特约专场列表(0 = 企业家/1 = 名家)>>列表页/详情页
	 * @param lecturesPersionFrom  名师巡讲...
	 * @param request
     * @return
     */
	@RequestMapping(value = "special")
	@ResponseBody
	public ReplyDataMode special(LecturesPersionFrom lecturesPersionFrom,Integer curPage,Integer pageSize,HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();

		lecturesPersionFrom.setIsDelete("0");
		// 详情页
		if (lecturesPersionFrom.getId() != null && !lecturesPersionFrom.getId().isEmpty()) {
			Map<String,Object> map = new HashMap<String,Object>();

			LecturesPersionEntity lecturesPersionEntity = this.sysServiceI.get(LecturesPersionEntity.class, lecturesPersionFrom.getId());
			LecturesPersionVo lecturesPersionVo = new LecturesPersionVo();

			// 个人展示
			String[] picture = null;
			if (lecturesPersionEntity != null) {
				lecturesPersionVo.copyEntity(lecturesPersionEntity);

				// 如果图片链接不null,将以#切割
				if (lecturesPersionEntity.getProsonAccomplishment() != null && !lecturesPersionEntity.getProsonAccomplishment().isEmpty()){
					picture = lecturesPersionEntity.getProsonAccomplishment().split("#");

				}
			}
			map.put("lecturesPersionVo",lecturesPersionVo);
			map.put("picture",picture);
			replyDataMode.setData(map);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		} else {

			// 详情页
			CriteriaQuery criteriaQuery = lecturesPersionFrom.getCriteriaQuery();
			criteriaQuery.addOrder("createTime", "desc");
			criteriaQuery.addOrder("updateTime", "desc");

			PageMode mode = null;
			if (curPage != null && pageSize != null) {
				mode = this.sysServiceI.list4page(criteriaQuery, curPage, pageSize);
			} else {
				replyDataMode.setStatusCode("页码传输错误!");
				replyDataMode.setSuccess(false);

			}

			List<LecturesPersionEntity> lecturesPersionEntityList = mode.getResult();
			List<LecturesPersionVo> lecturesPersionVos = new ArrayList<LecturesPersionVo>();

			if (lecturesPersionEntityList != null && lecturesPersionEntityList.size() > 0) {
				for (LecturesPersionEntity lpe : lecturesPersionEntityList) {
					LecturesPersionVo lecturesPersionVo = new LecturesPersionVo();
					lecturesPersionVo.copyEntity(lpe);
					lecturesPersionVos.add(lecturesPersionVo);
				}

				mode.setResult(lecturesPersionVos);
				replyDataMode.setData(mode);
				replyDataMode.setStatusCode("200");
				replyDataMode.setSuccess(true);
			}
		}
		return replyDataMode;
	}


	/**
	 * 全国巡讲>站点中所有的学校
	 * @param lecturesFrom	名师巡讲->详情页
	 * @param request
	 * @return
     */
	@RequestMapping(value = "allSchool")
	@ResponseBody
	public ReplyDataMode allAchool(LecturesFrom lecturesFrom,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		lecturesFrom.setIsDelete("0");


		/**查询所有有效站点*/

		// 分页模型设置
		PageMode mode = new PageMode();
		int total = 0;			// 总条数
		int pageNo = 0;			// 第几页
		int pageSize = 0;		// 每页显示的条数
		int pageCount = 0;		// 总页数

		StringBuffer sb_limit = new StringBuffer();
		if (!StringUtil.isEmpty(lecturesFrom.getPageNo()) && !StringUtil.isEmpty(lecturesFrom.getPageSize())) {
			pageNo = Integer.parseInt(lecturesFrom.getPageNo());
			pageSize = Integer.parseInt(lecturesFrom.getPageSize());
			sb_limit.append(" LIMIT " + (pageNo - 1) * pageSize + "," + pageSize);


			String addresSql = "SELECT DISTINCT(ls.lecture_address_short) FROM dxs_lectures ls WHERE ls.is_delete = 0 AND ls.lecture_address_short <> ''" + sb_limit.toString();
			String countSql = "SELECT DISTINCT(ls.lecture_address_short) FROM dxs_lectures ls WHERE ls.is_delete = 0";
			// 分页查询
			List cityList = this.sysServiceI.findListbySql(addresSql);
			// 总条数
			List<Map> list_count = this.sysServiceI.findListbySql(countSql);

			// 站点和站点中的所有学校
			List<Map> list = new ArrayList<Map>();

			if (cityList != null && cityList.size() > 0) {

				// 分页  总条数
				mode.setTotal(list_count.size());
//					Pattern pattern = Pattern.compile("^\\d+$|-\\d+$"); // 就是判断是否为整数
//					Pattern pattern = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");//判断是否为小数

				pageCount = (mode.getTotal() - 1) / pageSize + 1;
				mode.setPageCount(pageCount);
				mode.setPageNo(pageNo);
				mode.setPageSize(pageSize);

				// 根据站点查询学校
				for (int i = 0;i < cityList.size();i++){
					lecturesFrom.setLectureAddressShort((String) cityList.get(i));

					CriteriaQuery criteriaQuery = lecturesFrom.getCriteriaQuery();
					criteriaQuery.addOrder("lectureTime","desc");

					List<LecturesEntity> lecturesEntityList = this.sysServiceI.list(criteriaQuery);
					List<String> lecturesVos = new ArrayList<String>();

					if (lecturesEntityList != null && lecturesEntityList.size() > 0){

						int a = 1;
						StringBuffer school = new StringBuffer();
						for (LecturesEntity le:lecturesEntityList){

							if (lecturesEntityList.size() == a){
								school.append(le.getSchoolName());
							}else {
								school.append(le.getSchoolName() + "  ");
							}
							a++;
						}
						lecturesVos.add(school.toString());
					}


					Map map = new HashMap();
					map.put("userName",cityList.get(i));
					map.put("lecturesVos",lecturesVos);
					list.add(map);

				}
			} else {
				mode.setTotal(0);
			}

			mode.setResult(list);
			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else {
			replyDataMode.setStatusCode("分页传输错误!");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}
}
