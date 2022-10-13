package com.aisino.springboot_ssmp.servcie.impl;

import com.aisino.springboot_ssmp.domain.Book;
import com.aisino.springboot_ssmp.mapper.BookMapper;
import com.aisino.springboot_ssmp.servcie.BookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Resource
    private BookMapper bookMapper;

    /**
     * 分页查询
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Book}>
     */
    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize,Book book) {
        IPage<Book> page=new Page<>(currentPage,pageSize);
        return bookMapper.selectPage(page,new LambdaQueryWrapper<Book>().
                like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName()).
                like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType()).
                like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription())
        );
    }
}
