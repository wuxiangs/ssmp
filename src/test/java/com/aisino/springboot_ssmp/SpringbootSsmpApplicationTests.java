package com.aisino.springboot_ssmp;

import com.aisino.springboot_ssmp.domain.Book;
import com.aisino.springboot_ssmp.mapper.BookMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootSsmpApplicationTests {

    @Resource
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        Book book=new Book();
        book.setType("计算机理论");
        book.setName("java理论");
        book.setDescription("从多个纬度介绍Java知识");
        bookMapper.insert(book);
    }

    @Test
    public void testGetPage(){
        IPage<Book> page=new Page<Book>(1,5);
        IPage<Book> page1 = bookMapper.selectPage(page, null);
    }


    @Test
    public void testGetBy(){
        QueryWrapper<Book> queryWrapper=new QueryWrapper<Book>();
        queryWrapper.eq("id",1);
        bookMapper.selectList(queryWrapper);
    }

    @Test
    public void testGetBy2(){
        String name="java";
        LambdaQueryWrapper<Book> lambdaQueryWrapper=new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(name!=null,Book::getName,name);
        bookMapper.selectList(lambdaQueryWrapper);
    }

}
