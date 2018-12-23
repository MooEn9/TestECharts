package com.mooen.testStage4.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mooen.testStage4.domain.Consult;
import com.mooen.testStage4.domain.MonthCount;
import com.mooen.testStage4.domain.MonthCountService;
import com.mooen.testStage4.domain.NoTargetUser;
import com.mooen.testStage4.domain.OtherInnerPageType;
import com.mooen.testStage4.domain.OtherPageType;
import com.mooen.testStage4.domain.PageAlexa;
import com.mooen.testStage4.domain.PageType;
import com.mooen.testStage4.domain.UserClickStats;
import com.mooen.testStage4.domain.WordCloud;
import com.mooen.testStage4.service.WordCloudService;
import com.mooen.testStage4.util.JsonUtil;
import com.mooen.testStage4.service.ConsultService;
import com.mooen.testStage4.service.NoTargetUserService;
import com.mooen.testStage4.service.OtherInnerPageTypeService;
import com.mooen.testStage4.service.OtherPageTypeService;
import com.mooen.testStage4.service.PageAlexaService;
import com.mooen.testStage4.service.PageCountService;
import com.mooen.testStage4.service.PageTypeService;
import com.mooen.testStage4.service.UserClickStatsService;

@Controller
public class SampleController {
	
	@Autowired
	WordCloudService wordCloudService;
	
	@Autowired
	PageTypeService pageTypeService;
	
	@Autowired
	PageAlexaService pageAlexaService;
	
	@Autowired
	ConsultService consultService;
	
	@Autowired
	NoTargetUserService noTargetUserService;
	
	@Autowired
	OtherInnerPageTypeService otherInnerPageTypeService;
	
	@Autowired
	OtherPageTypeService otherPageTypeService;
	
	@Autowired
	UserClickStatsService userClickStatsService;
	
	@Autowired
	MonthCountService monthCountService;
	
	@Autowired
	PageCountService pageCountService;
	
	@RequestMapping(value="/")	
	public String cateye(Model model) {
		Map<String,String> pageCount = pageCountService.getPageCount();
		model.addAttribute("pageCount",pageCount);
		return "cateye";
	}
	@RequestMapping(value="/getWordCloud")
	@ResponseBody
	public String getWordCloud() {
		 List<WordCloud> wordClouds = wordCloudService.getWordCloudDao(20);
		return JsonUtil.WordCloud2Json(wordClouds);
	}
	
	@RequestMapping(value="/getPageType")
	@ResponseBody
	public String getPageType() {
		List<PageType> pageTypes = pageTypeService.getPageType();
		return JsonUtil.PageType2Json(pageTypes);
	}
	
	@RequestMapping(value="/getPageAlexa")
	@ResponseBody
	public String getPageAlexa() {
		List<PageAlexa> pageAlexas = pageAlexaService.getPageAlexa();
		return JsonUtil.PageAlexa2Json(pageAlexas);
	}
	
	@RequestMapping(value="/getConsult")
	@ResponseBody
	public String getConsult() {
		List<Consult> consults = consultService.getConsult();
		return JsonUtil.Consult2Json(consults);
	}
	
	@RequestMapping(value="/getNoTargetUser")
	@ResponseBody
	public String getNoTargetUser() {
		List<NoTargetUser> noTargetUsers = noTargetUserService.getNoTargetUser();
		return JsonUtil.NoTargetUser2Json(noTargetUsers);
	}
	
	@RequestMapping(value="/getOtherInnerPageType")
	@ResponseBody
	public String getOtherInnerPageType() {
		List<OtherInnerPageType> otherInnerPageTypes = otherInnerPageTypeService.getOtherInnerPageType();
		return JsonUtil.OtherInnerPageType2Json(otherInnerPageTypes);
	}
	
	@RequestMapping(value="/getOtherPageType")
	@ResponseBody
	public String getOtherPageType() {
		List<OtherPageType> OtherPageTypes = otherPageTypeService.getOtherPageType();
		return JsonUtil.otherPage2Json(OtherPageTypes);
	}
	
	@RequestMapping(value="/getUserClickStats")
	@ResponseBody
	public String getUserClickStats() {
		List<UserClickStats> userClickStatss = userClickStatsService.getUserClickStats();
		return JsonUtil.userClickStats2Json(userClickStatss);
	}
	
	@RequestMapping(value="/getMonthCount")
	@ResponseBody
	public String getMonthCount() {
		List<MonthCount> monthCounts = monthCountService.getMonthCount();
		return JsonUtil.monthCount2Json(monthCounts);
	}
}
