package com.tpshion.oauth2.demo.service.impl;

import com.tpshion.oauth2.demo.domain.entity.TbPermission;
import com.tpshion.oauth2.demo.domain.entity.TbUser;
import com.tpshion.oauth2.demo.mapper.TbPermissionMapper;
import com.tpshion.oauth2.demo.mapper.TbUserMapper;
import com.tpshion.oauth2.demo.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-01-08
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public TbUser getUserByName(String username) {
        return tbUserMapper.getUserByName(username);
    }

    /**
     * 根据用户id获取权限列表
     * @param userId
     * @return
     */
    @Override
    public List<TbPermission> getPermissions(Long userId) {
        return tbPermissionMapper.getPermissions(userId);
    }
}
