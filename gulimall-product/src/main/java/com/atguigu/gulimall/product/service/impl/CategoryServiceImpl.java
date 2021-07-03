package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.dao.CategoryBrandRelationDao;
import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


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

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //todo
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
        List<Long> path=new ArrayList<>();
        path.add(categoryEntity.getCatId());
        while (categoryEntity.getParentCid()!=0){
            path.add(categoryEntity.getParentCid());
            baseMapper.selectById(categoryEntity.getParentCid());
        }
        Collections.reverse(path);
        return path.toArray(new Long[path.size()]);
    }
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        CategoryBrandRelationDao.updateCategory(category.getCatId(),category.getName());
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