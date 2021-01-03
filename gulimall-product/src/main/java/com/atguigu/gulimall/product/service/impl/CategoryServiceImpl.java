package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entityList = baseMapper.selectList(null);
        return entityList.stream()
                .filter(categoryEntity -> categoryEntity.getCatLevel() == 1)
                .peek(menu -> menu.setChildren(getChildrens(menu, entityList)))
                .sorted(Comparator.comparingInt(item -> (item.getSort() == null ? 0 : item.getSort())))
                .collect(Collectors.toList());
    }

    /**
     * 查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(item -> item.getParentCid().equals(root.getCatId()))
                .peek(menu-> menu.setChildren(getChildrens(menu,all)))
                .sorted(Comparator.comparingInt(item -> (item.getSort()==null?0: item.getSort())))
                .collect(Collectors.toList());
    }

}