package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author cc
 * @email 405367282@qq.com
 * @date 2021-06-15 23:53:42
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
