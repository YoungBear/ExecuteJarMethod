package com.ysx.springbootjar;

import com.ysx.springbootjar.param.InputParam;
import com.ysx.springbootjar.param.OutParam;
import org.joda.time.DateTime;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-04-01 07:29
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class Hello {

    /**
     * 测试方法
     * @param inputParam
     * @return
     */
    public OutParam method1(InputParam inputParam) {
        OutParam outParam = new OutParam();
        DateTime now = new DateTime();
        outParam.setOut1(inputParam.getIn1() + ", time: " + now.toString());
        outParam.setOut2(inputParam.getIn2());
        return outParam;
    }
}
