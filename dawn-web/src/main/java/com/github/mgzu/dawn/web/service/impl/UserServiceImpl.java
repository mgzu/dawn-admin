package com.github.mgzu.dawn.web.service.impl;

import com.github.mgzu.dawn.web.entity.User;
import com.github.mgzu.dawn.web.mapper.UserMapper;
import com.github.mgzu.dawn.web.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author https://github.com/mgzu
 * @since 2018-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
