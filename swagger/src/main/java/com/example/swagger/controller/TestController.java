package com.example.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Wang Dengshou
 * @Description:
 * @Date: Created in 20:05 2018/8/3
 */
@RestController("/test")
public class TestController {

    @ApiOperation(value = "hello",notes = "输出hello world")
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @ApiOperation(value = "list",notes = "查询相关内容")
    @GetMapping("list")
    public String add(){
        return "list";
    }

    @ApiOperation(value = "update",notes = "更新相关内容")
    @ApiImplicitParam(name = "params",value = "更新的内容",required = true,dataType = "String")
    @PostMapping("update")
    public String update(String params){
        return "update";
    }

    @ApiOperation(value = "delete", notes = "删除相关内容")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String")
    @PostMapping("delete{id}")
    public String delete(@PathVariable String id){
        System.out.println(id);
        return "delete";
    }

}
