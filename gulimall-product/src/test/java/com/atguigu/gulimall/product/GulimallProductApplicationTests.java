package com.atguigu.gulimall.product;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    public void testUpload(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI5tCmfDrSogd5uRfPw6Ku";
        String accessKeySecret = "zkT8AapSSJoPvBPFAGtnWEJhyWIkZD";
        String bucketName = "ccgulimall";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = "小米";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。
        String content = "\u202AD:\\迅雷下载\\资料源码\\docs\\pics\\0d40c24b264aa511.jpg";
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));

        // 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("上传成功");
    }


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
