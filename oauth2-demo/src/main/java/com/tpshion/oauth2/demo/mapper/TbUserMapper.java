package com.tpshion.oauth2.demo.mapper;

import com.tpshion.oauth2.demo.domain.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-01-08
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    TbUser getUserByName(String username);
}
