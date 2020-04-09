package com.tpshion.oauth2.demo.service;

import com.tpshion.oauth2.demo.domain.entity.TbPermission;
import com.tpshion.oauth2.demo.domain.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author chen
 * @since 2020-01-08
 */
public interface ITbUserService extends IService<TbUser> {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    TbUser getUserByName(String username);

    /**
     * 根据用户id获取权限列表
     * @param userId
     * @return
     */
    List<TbPermission> getPermissions(Long userId);
}
