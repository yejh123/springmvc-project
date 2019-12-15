package com.yejh.controller;/**
 * @author yejh
 * @create 2019-11_21 20:30
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Controller 标识哪个组件是控制器
 * 运行流程
 * 1.客户端点击链接发送请求
 * 2.tomcat服务器接收请求
 * 3.SpringMVC前端控制器接收请求
 * 4.将请求地址与RequestMapping标注的地址匹配
 * 5.前端控制器找到目标处理器类和目标方法，执行目标方法
 * 6.目标方法的返回值就是执行完这个方法后页面的跳转路径
 * 7.用视图解析器进行拼串，得到完整的页面地址
 * 8.前端控制器转发到新页面
 * @RequestMapping 指定处理哪个请求
 * 1、value
 * /可以省略，都是从项目根目录开始
 * <p>
 * 2、method：限定请求方式，默认什么请求都接收
 * method=RequestMethod.POST：只接受POST请求
 * 否则 405 - Request method 'GET' not supported
 * <p>
 * 3、params规定请求参数
 * 1）param1：表示请求必须包含名为param1的参数
 * eg. params={"username"}
 * 发送请求必须带有一个name为username的参数，否则报404
 * <p>
 * 2）!param1：表示请求必须不包含名为param1的参数
 * <p>
 * 3）param1=value1：带的值必须是value1
 * <p>
 * 4）param1!=value1：param1要么不指定，要么值不是value1
 * <p>
 * 3、header：规定请求头，
 * 1.User-Agent：浏览器信息
 * 可以规定chrome可以访问，火狐不能访问
 * <p>
 * 4、路径模糊匹配
 * URL地址可以写模糊的通配符
 * ?：能替代任意一个字符（除了/)，0个和多个都不行
 * *：能替代任意多个字符，或匹配一层路径
 * **：能匹配多层路径
 * <p>
 * 模糊和精确匹配情况下，精确优先
 * <p>
 * 5、Rest
 * 以非常简洁的URL地址来发请求，以请求方式区别资源操作
 * /book/1：GET----查询一号图书
 * PUT----更新一号图书
 * DELETE----删除一号图书
 * <p>
 * /book    POST----添加图书
 * <p>
 * <p>
 * SpringMVC获取请求参数、请求头和缓存
 * 1、默认方式获取请求参数
 * 直接给参数形参上写一个和请求参数名相同的变量，如果没传入参数，则为null
 * 2、@RequestParam：获取请求参数，参数默认必须存在，否则报错
 * value：指定要获取的参数的key
 * required：表示参数是否必须存在
 * defaultValue：默认值
 * <p>
 * 区分@RequestParam和@PathVariable
 * 3、@RequestHeader：获取请求头中某个key的值
 * value：key的名称（比如User-Agent），默认如果请求头中没有这个值就会报错
 * required：表示这个请求头信息是否必须存在
 * defaultValue：默认值
 * <p>
 * 4、@CookieValue：获取某个cookie的值
 * value：key的名称，默认如果请求头中没有这个值就会报错
 * required：表示这个cookie是否必须存在
 * defaultValue：默认值
 **/

/* DispatcherServlet运行流程
 * 1、所有请求过来DispatcherServlet收到请求
 * 2、调用doDispatch()方法处理请求
 * 1）getHandler()：根据当前请求地址找到能处理这个请求的处理器
 * 2）getHandlerAdapter()：根据当前处理器类寻找能执行这个处理器的适配器
 * 3）使用找到的适配器（AnnotationMethodHandlerAdapter）执行目标方法
 * 4）目标方法执行后会返回一个ModelAndView对象
 * 5）根据ModelAndView的信息转发到具体的页面，并可以在请求域中取出ModelAndView中的模型信息
 * 3、
 *
 * SpringMVC九大组件
 * MultipartResolver：文件上传解析器
 * LocaleResolver：区域信息解析器
 * ThemeResolver：主题解析器，强大的主题效果更换
 * List<HandlerMapping>：Handler映射信息
 * List<HandlerAdapter>：Handler适配器
 * List<HandlerExceptionResolver>：异常解析器
 * RequestToViewNameTranslator：
 * FlashMapManager：SpringMVC中运行重定向携带数据的功能
 * List<ViewResolver>：视图解析器
 *
 * 共同点：九大组件全都是接口
 * 接口就是规范，提供了强大的扩展性
 *
 */
@Controller
public class MyFirstController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String myFirstRequest() {
        System.out.println("正在处理中");
        return "success";
    }

    @RequestMapping(value = "/user/{id}")
    public String pathVariableTest(@PathVariable("id") String id) {
        System.out.println("id" + id);
        return "success";
    }

    @RequestMapping(value = "params")
    public String RequestParamsTest(
            @RequestParam(value = "name", required = false, defaultValue = "sbchang") String name,
            @RequestHeader(value = "User-Agent", required = false, defaultValue = "无") String userAgent,
            @CookieValue("JSESSIONID") String cookie) {
        System.out.println("name=" + name);
        System.out.println("userAgent=" + userAgent);
        System.out.println("cookie=" + cookie);
        return "success";
    }
}
