package com.boke.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boke.bean.Respond;
import com.boke.bean.UserInfo;
import com.boke.enumeration.TypeEnum;
import com.boke.service.IRespondService;

/**
 * 评论回复控制器
 * @author Xsj
 *
 */
@RestController
@ResponseBody
@RequestMapping("/discussion")
public class DiscussionController {
	
	@Autowired
	private IRespondService respond;
	
	
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public int addRespond(String aboutid , String whichbelong , String content , String bokeid , String respondedman ,String type , HttpServletRequest request) {
		System.out.println(bokeid + "     "  + respondedman + "      " + type);
		System.out.println("标志位>>>>>>>>>>>>>>>>>>");
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		Respond resp = new Respond();
		resp.setRespondman(user.getUsername() );
		resp.setRespondedman(respondedman);
		resp.setType(type);
		resp.setBokeid(bokeid);
		if(aboutid != null) {
			resp.setAboutid(aboutid);
		}else {
			resp.setAboutid("0");
		}
		if(whichbelong != null) {
			resp.setWhichbelong(whichbelong);
		}else {
			resp.setWhichbelong("0");
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		resp.setRespondtime(df.format(new Date()));
		resp.setRespondcontent(content);
		return respond.addOne(resp);
	}
	
	
	
	
	@RequestMapping(value="/all")
	public Map<Respond,List<Respond>> discussion(int bokeid) {
		System.out.println("查询所有");
		//根据博客id查询出所有的信息
		List<Respond> respondList = respond.selectAll(bokeid);
		//一个map代表一条评论
		//所有评论集合
		Map<Respond,List<Respond>> discussionMap = new HashMap<Respond, List<Respond>>();
		
		//遍历回复表中的所有信息
		for (int i = 0; i < respondList.size(); i++) {
			if(respondList.get(i).getType().equals(TypeEnum.evaluation.name())) {
				//为评论
				//如果类型为评论的话，判断评论集合列表里有没有存储這条评论，如果有存储,则跳过，如果每有存储，则进行存储
				if( discussionMap.isEmpty() || !discussionMap.containsKey(respondList.get(i))) {
					//如果discussionlist的key不包含這个评论的话，则说明未进行存储
					List<Respond> list =  new ArrayList<Respond>();
					list.add(respondList.get(i));
					discussionMap.put(respondList.get(i),list);
				}else {
					//否则说明已经存储了，不予理会
					continue;
				}
			}else {
				//为回复
				for (Respond res : discussionMap.keySet()) {
					//遍历所有已经存储的评论，如果当前Respond的whichBelog为map的key的id则添加至当前的key的value中
					if(respondList.get(i).getWhichbelong().equals(res.getRespondid())) {
						//表示当前回复属于该条评论
						List<Respond> currentList = discussionMap.get(res);
						if(currentList.size() == 0) {
							currentList.add(respondList.get(i));
						}else {
							if(!respondList.get(i).getAboutid().equals("0")) {
								for (int j = 0; j < currentList.size(); j++) {
									if(currentList.get(j).getRespondid().equals(respondList.get(i).getAboutid())) {
										currentList.add(j + 1, respondList.get(i));
									}
								}
							}
						}
					}
				}
			}
		}
		return discussionMap;
	}
}
