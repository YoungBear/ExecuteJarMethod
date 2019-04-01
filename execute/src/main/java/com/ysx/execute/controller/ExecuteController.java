package com.ysx.execute.controller;

import com.ysx.execute.entity.RequestExecuteEntity;
import com.ysx.execute.service.IExecuteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-04-01 20:28
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
@RestController
@RequestMapping(value = "/execute", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api("执行jar包中的方法")
public class ExecuteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteController.class);

    @Autowired
    private IExecuteService executeService;

    @RequestMapping(value = "spring-boot-jar", method = RequestMethod.POST)
    @ApiOperation("执行使用spring-boot 插件打包的jar中的方法")
    public String springBootJar(@RequestBody RequestExecuteEntity requestExecuteEntity) {
        try {
            return executeService.executeSpringBootJar(requestExecuteEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ApiOperation("测试接口")
    public String hello() {
        return "Hello";
    }
}
