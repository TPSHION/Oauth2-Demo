package com.tpshion.oauth2.demo.mapper;

import com.tpshion.oauth2.demo.domain.entity.TbPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author chen
 * @since 2020-01-08
 */
public interface TbPermissionMapper extends BaseMapper<TbPermission> {

    /**
     * 根据用户id获取权限列表
     * @param userId
     * @return
     */
    List<TbPermission> getPermissions(Long userId);
}
