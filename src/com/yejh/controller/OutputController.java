package com.yejh.controller;/**
 * @author yejh
 * @create 2019-11_22 20:53
 */

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

import java.util.Map;

/**
 * @description: TODO
 * SpringMVC传递数据给页面
 *     1、方法传入Map、Model或者ModelMap（最终都是BindingAwareModelMap的在工作）
 *        这些数据都会放在请求域中
 *        Map(interface(jdk)) Model(interface(spring)) ModelMap(class)
 *
 *     2、方法的返回值可以变成ModelAndView对象，为页面携带数据
 *
 *     3、一种临时给session添加数据的方式
 *        @SessionAttributes（只能标在类上）：给BindingAwareModelMap保存数据时，同时给session中放一份
 *          value：new String[]，指定要给session存储数据的key，只要保存的是这些key的数据，就给session中保存一份
 *          types：只要保存的是这种类型的数据，就给session中保存一份
 *          推荐给session保存数据使用原生api
 **/
@Controller
@SessionAttributes(value = "msg")
public class OutputController {
    @RequestMapping("/output/map")
    public String outputMapTest(Map map){
        map.put("msg", "map");
        return "success";
    }
    @RequestMapping("/output/model")
    public String outputModelTest(Model model){
        model.addAttribute("msg", "model");
        return "success";
    }
    @RequestMapping("/output/modelMap")
    public String outputTest(ModelMap modelMap){
        modelMap.addAttribute("msg", "modelMap");
        return "success";
    }
    @RequestMapping("/output/modelAndView")
    public ModelAndView modelAndViewTest(ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("msg", "modelAndView");
        return modelAndView;
    }
}
