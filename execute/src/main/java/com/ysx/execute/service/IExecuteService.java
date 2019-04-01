package com.ysx.execute.service;

import com.ysx.execute.entity.RequestExecuteEntity;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-04-01 20:39
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public interface IExecuteService {

    /**
     * 执行 SpringBoot 打包的 jar 中的方法
     *
     * @param requestExecuteEntity
     * @return 返回其返回值的 json 串
     */
    String executeSpringBootJar(RequestExecuteEntity requestExecuteEntity) throws Exception;
}
