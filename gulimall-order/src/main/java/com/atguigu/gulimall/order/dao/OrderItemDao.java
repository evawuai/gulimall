package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author cc
 * @email 405367282@qq.com
 * @date 2021-06-20 23:20:59
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
