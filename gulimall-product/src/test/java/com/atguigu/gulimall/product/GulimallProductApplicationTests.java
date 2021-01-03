package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        BrandEntity entity = new BrandEntity();
//        entity.setName("cc");
//        brandService.save(entity);
//        System.out.println("success");

//        entity.setBrandId(1L);
//        entity.setDescript("学习学习");
//        entity.setName("奥特曼");
//        brandService.updateById(entity);
//        BrandEntity entity1 = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
//        System.out.println(entity1);

        brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id",1)).forEach(System.out::println);

    }

}
