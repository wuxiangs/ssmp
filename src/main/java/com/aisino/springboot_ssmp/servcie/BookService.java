package com.aisino.springboot_ssmp.servcie;

import com.aisino.springboot_ssmp.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BookService extends IService<Book> {

    /**
     * 分页查询
     *
     * @param currentPage 当前页面
     * @param pageSize
     * @return {@link IPage}<{@link Book}>
     */
    IPage<Book> getPage(Integer currentPage,Integer pageSize,Book book);
}
