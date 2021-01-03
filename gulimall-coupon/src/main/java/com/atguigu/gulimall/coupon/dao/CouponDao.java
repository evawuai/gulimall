package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author cc
 * @email 405367282@qq.com
 * @date 2021-06-20 23:18:23
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
