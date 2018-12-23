package com.mooen.testStage4.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.mooen.testStage4.domain.Consult;
import com.mooen.testStage4.domain.MonthCount;
import com.mooen.testStage4.domain.NoTargetUser;
import com.mooen.testStage4.domain.OtherInnerPageType;
import com.mooen.testStage4.domain.OtherPageType;
import com.mooen.testStage4.domain.PageAlexa;
import com.mooen.testStage4.domain.PageType;
import com.mooen.testStage4.domain.UserClickStats;
import com.mooen.testStage4.domain.WordCloud;

public class JsonUtil {
	/**
	 * 将PageTypes转换为指定的json格式
	 * @param PageTypes
	 * @return
	 */
	public static String PageType2Json(List<PageType> PageTypes) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<String> legend_data = new ArrayList<String>();
		List<Object> series_data = new ArrayList<Object>();
 		for (PageType pageType : PageTypes) {
 			Map<String,Object> count_nums = new HashMap<String, Object>();
 			count_nums.put("value", pageType.getCount_num());
 			count_nums.put("name",String.valueOf(pageType.getPage_type()));
 			legend_data.add(String.valueOf(pageType.getPage_type()));
 			series_data.add(count_nums);
		}
 		result.put("legend_data", legend_data);
 		result.put("series_data", series_data);
		return JSON.toJSONString(result);
	}
	
	public static String WordCloud2Json(List<WordCloud> wordClouds) {
		return JSON.toJSONString(wordClouds);
	}

	public static String PageAlexa2Json(List<PageAlexa> pageAlexas) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<BigInteger> series_data = new ArrayList<BigInteger>();
		List<Integer> yAxis_data = new ArrayList<Integer>();
		for (PageAlexa pageAlexa : pageAlexas) {
			yAxis_data.add(pageAlexa.getId());
			series_data.add(pageAlexa.getCounter());
		}
		result.put("series_data",series_data);
		result.put("yAxis_data",yAxis_data);
		return JSON.toJSONString(result);
	}

	public static String Consult2Json(List<Consult> consults) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map> series_data = new ArrayList<Map>();
		for (Consult consult : consults) {
			Map<String,Object> data= new HashMap<String, Object>();
			data.put("name", consult.getCount_num());
			data.put("value",consult.getPage_type());
			series_data.add(data);
		}
		result.put("series_data", series_data);
		return JSON.toJSONString(result);
	}

	public static String NoTargetUser2Json(List<NoTargetUser> noTargetUsers) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<BigInteger> total_data = new ArrayList<BigInteger>();
		List<Object> xAxis_data = new ArrayList<Object>();
		List<BigInteger> assist_data = new ArrayList<BigInteger>();
		xAxis_data.add("总访问量");
		BigInteger total = new BigInteger("0") ;
		for (NoTargetUser noTargetUser : noTargetUsers) {
			total = total.add(noTargetUser.getCount_num());
			xAxis_data.add(String.valueOf(noTargetUser.getPage_type()));
			total_data.add(noTargetUser.getCount_num());
		}
		
		total_data.add(0, total);
		
		for(int i = 0;i < total_data.size();i++) {
			BigInteger cur = total_data.get(i);
			if(i == 0) {
				BigInteger subtract = cur.subtract(total);
				assist_data.add(subtract);
			} else if(i == 1) {
				BigInteger subtract = total_data.get(i-1).subtract(cur);
				assist_data.add(subtract);
			}else {
				BigInteger subtract = assist_data.get(i-1).subtract(cur);
				assist_data.add(subtract);
			}	
		}
		
		result.put("total_data", total_data);
		result.put("xAxis_data", xAxis_data);
		result.put("assist_data", assist_data);
		
		
		return JSON.toJSONString(result);
	}

	public static String OtherInnerPageType2Json(List<OtherInnerPageType> otherInnerPageTypes) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<String> legend_data = new ArrayList<String>();
		List<Map> series_data = new ArrayList<Map>();
		for (OtherInnerPageType otherInnerPageType : otherInnerPageTypes) {
			String title = otherInnerPageType.getPage_title().substring(0, 2)+"...";
			legend_data.add(title);
			Map<String,Object> temp = new HashMap<String, Object>();
			temp.put("value",otherInnerPageType.getCount_num());
			temp.put("name", title);
			series_data.add(temp);
		}
		result.put("legend_data", legend_data);
		result.put("series_data", series_data);
		return JSON.toJSONString(result);
	}

	public static String otherPage2Json(List<OtherPageType> otherPageTypes) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<String> legendData = new ArrayList<String>();
		List<String> selected = new ArrayList<String>();
		List<Map> seriesData = new ArrayList<Map>();
		
		for (OtherPageType otherPageType : otherPageTypes) {
			legendData.add(otherPageType.getPage_type());
			Map<String,Object> temp = new HashMap<String, Object>();
			temp.put("value", otherPageType.getPage_type());
			temp.put("name", otherPageType.getCount_num());
			seriesData.add(temp);
		}
		//随机选5个作为mock
		Random random = new Random();
		List<Integer> randomList = new ArrayList<Integer>();
		for(int i = 0 ; i < 5 ; i++) {
			int x = random.nextInt(legendData.size());
			if(!randomList.contains(x)) {
				randomList.add(x);
				selected.add(legendData.get(x));
			}else {
				i--;
			}
		}
		result.put("legendData", legendData);
		result.put("selected", selected);
		result.put("seriesData",seriesData);
		return JSON.toJSONString(result);
		
	}

	public static String userClickStats2Json(List<UserClickStats> userClickStatss) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<Object> series_effectScatter = new ArrayList<Object>();
		List<Object> series_scatter = new ArrayList<Object>();
		for (UserClickStats userClickStats : userClickStatss) {
			List<Object> temp = new ArrayList<Object>();
			temp.add(userClickStats.getCount());
			temp.add(userClickStats.getPage_type());
			if(userClickStats.getPage_type().equals("1")) {
				series_effectScatter.add(temp);
			}else {
				series_scatter.add(temp);
			}
		}
		result.put("series_effectScatter", series_effectScatter);
		result.put("series_scatter", series_scatter);
		return JSON.toJSONString(result);
	}

	public static String monthCount2Json(List<MonthCount> monthCounts) {
		Map<String,Object> result = new HashMap<String, Object>();
		List<String> page_type = new ArrayList<String>();
		Map<String,List<BigInteger>> series = new HashMap<String, List<BigInteger>>();
		for (MonthCount monthCount : monthCounts) {
			if(!page_type.contains(monthCount.getPage_type())) {
				page_type.add(monthCount.getPage_type());
			}
			String yearmonth = monthCount.getYearmonth();
			if(!series.containsKey(yearmonth)) {
				List<BigInteger> putTemp = new ArrayList<BigInteger>();
				series.put(yearmonth, putTemp);
			}
			List<BigInteger> temp = series.get(yearmonth);
			temp.add(monthCount.getCount_num());
			series.put(yearmonth,temp);
		}
		result.put("page_type", page_type);
		result.put("series", series);
		return JSON.toJSONString(result);
	}
	
}
