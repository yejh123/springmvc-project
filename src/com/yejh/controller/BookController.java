package com.yejh.controller;/**
 * @author yejh
 * @create 2019-11_22 18:54
 */

import com.yejh.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @description: TODO
 * <p>
 * <p>
 * Book对象是如何封装的？
 * 1）SpringMVC创建一个book对象，每个属性都有默认值，bookName就是null
 * 解决全字段更新问题
 * 1、让SpringMVC别创建book对象，直接从数据库拿到对应id的对象数据
 * 2、使用刚才从数据库取出的book对象，给它的里面设置值
 * 3、只设置从前端带来的值对应的属性
 * 4、保存数据
 * @ModelAttribute :
 * 1、参数：
 * 2、方法位置：这个方法就会提前于目标方法先运行
 * 提前从数据库中查询图书信息
 * 将这个图书信息保存起来
 */
@Controller
public class BookController {
    @ModelAttribute
    public void ModelAttributeTest(Map<String, Object> map){
        Book book = new Book();
        //查询数据库信息
        book.setAuthor("sbchang");

        map.put("book", book);
        System.out.println("ModelAttributeTest");
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.PUT)
    public String updateBook(@ModelAttribute("book")Book book) {
        System.out.println("ModelAttribute---updateBook: " + book);
        return "success";
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public String getBook(@PathVariable("bookId") Integer bookId) {
        System.out.println("查询" + bookId + "号图书");
        return "success";
    }

//    @RequestMapping(value = "/book", method = RequestMethod.POST)
//    public String addBook() {
//        System.out.println("添加图书");
//        return "success";
//
//    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bookId") Integer bookId) {
        System.out.println("删除" + bookId + "号图书");
        return "success";

    }


    /**
     * 乱码
     * GET请求乱码：改server.xml
     * POST请求乱码：在第一次获取参数之前设置
     * request.setCharacterEncoding("utf-8
     */
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bookId") Integer bookId) {
        System.out.println("更新" + bookId + "号图书");
        return "success";
    }

    /**
     * 如果我们的请求参数是一个POJO
     * SpringMVC会自动的为这个POJO自动赋值
     * 级联属性也可以封装
     */
    @RequestMapping(value = "/book")
    public String addBook(Book book) {
        System.out.println("添加新图书" + book);
        return "success";
    }
}
