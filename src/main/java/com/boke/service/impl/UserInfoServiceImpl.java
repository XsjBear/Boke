package com.boke.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.UserInfo;
import com.boke.mapper.IUserInfoMapper;
import com.boke.service.IUserInfoService;
import com.boke.util.StringUtil;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IUserInfoMapper mapper;

	@Override
	public UserInfo login(UserInfo uf) {
		if (StringUtil.isNull(uf.getUsername(), uf.getUserpass())) {
			return null;
		}
		return mapper.login(uf);
	}

	@Override
	public int add(UserInfo uf) {
		if (StringUtil.isNull(uf.getUsername(), uf.getUserpass(), uf.getRealname(), uf.getContackway(),
				uf.getBirthday(), uf.getSex(), uf.getAddress(), uf.getWork(), uf.getEmail())) {
			return -1;
		}
		return mapper.add(uf);
	}

	@Override
	public UserInfo findAll(Integer userid) {
		if (StringUtil.isNull(userid)) {
			return null;
		}
		return mapper.findAll(userid);
	}

	@Override
	public int update(UserInfo uf) {

		return mapper.update(uf);
	}

}
