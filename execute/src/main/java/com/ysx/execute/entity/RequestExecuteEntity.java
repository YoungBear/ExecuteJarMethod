package com.ysx.execute.entity;

import java.util.List;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-04-01 20:34
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description 执行请求实体类
 */
public class RequestExecuteEntity {
    /**
     * jar 文件路径
     */
    private String jarPath;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 参数类名列表
     */
    private List<String> paramClassNameList;
    /**
     * 实参 json 串列表
     */
    private List<String> paramJsonList;

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<String> getParamClassNameList() {
        return paramClassNameList;
    }

    public void setParamClassNameList(List<String> paramClassNameList) {
        this.paramClassNameList = paramClassNameList;
    }

    public List<String> getParamJsonList() {
        return paramJsonList;
    }

    public void setParamJsonList(List<String> paramJsonList) {
        this.paramJsonList = paramJsonList;
    }
}
