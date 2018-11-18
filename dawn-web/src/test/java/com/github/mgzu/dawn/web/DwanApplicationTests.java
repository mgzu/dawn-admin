package com.github.mgzu.dawn.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.mgzu.dawn.web.entity.User;
import com.github.mgzu.dawn.web.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DwanApplicationTests {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IUserService userService;

	@Test
	public void UserTestCase() {
		QueryWrapper qw = new QueryWrapper<User>();
		User u = new User();
		u.setName("mgzu");
		u = userService.getOne(qw.setEntity(u));
		log.info(u.toString());
		log.info(u.getId().toString());
	}
}
