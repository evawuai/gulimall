package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author cc
 * @email 405367282@qq.com
 * @date 2021-06-20 23:23:37
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
