package com.aisino.springboot_ssmp.controller;

import com.aisino.springboot_ssmp.domain.Book;
import com.aisino.springboot_ssmp.servcie.BookService;
import com.aisino.springboot_ssmp.util.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "book管理接口")
@RequestMapping("/books")
public class BookController {


    @Resource
    private BookService bookService;

    /**
     * 获取所有
     *
     * @return {@link List}<{@link Book}>
     */
    @GetMapping()
    @ApiOperation(value = "获取所有")
    public Result<List<Book>> getAll(){
        return Result.success(bookService.list());
    }

    /**
     * 保存
     *
     * @param book 书
     * @return boolean
     */
    @PostMapping()
    @ApiOperation(value = "保存")
    public Result<Boolean> save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("123"))
            throw new Exception();
        return Result.success(bookService.save(book));
    }

    /**
     * 更新
     *
     * @param book 书
     * @return boolean
     */
    @PutMapping()
    @ApiOperation(value = "更新")
    public Result<Boolean> update(@RequestBody Book book){
        return Result.success(bookService.update(book,new QueryWrapper<Book>().eq("id",book.getId())));
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id){
        return Result.success(bookService.removeById(id));
    }

    /**
     * 通过id获取
     *
     * @param id id
     * @return {@link Book}
     */
    @ApiOperation(value = "通过ID获取数据")
    @GetMapping("/{id}")
    public Result<Book> getById(@PathVariable Integer id){
        return Result.success(bookService.getById(id));
    }

    /**
     * 分页查询
     *
     * @param currentPage 当前页面
     * @param pageSize    页面大小
     * @return {@link IPage}<{@link Book}>
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<IPage<Book>> getPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值,重新执行查询操作,使用当前页码值作为当前页码值
        if(currentPage>page.getPages()){
            page=bookService.getPage((int) page.getPages(),pageSize,book);
        }
        return Result.success(page);
    }
}
