package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author cc
 * @email 405367282@qq.com
 * @date 2021-06-20 23:20:59
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
