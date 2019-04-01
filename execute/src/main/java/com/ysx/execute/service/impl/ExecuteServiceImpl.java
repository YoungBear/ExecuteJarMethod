package com.ysx.execute.service.impl;

import com.google.gson.Gson;
import com.ysx.execute.entity.RequestExecuteEntity;
import com.ysx.execute.service.IExecuteService;
import com.ysx.execute.utils.MyLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.loader.archive.JarFileArchive;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-04-01 20:42
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
@Service
public class ExecuteServiceImpl implements IExecuteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteServiceImpl.class);

    private static final Gson GSON = new Gson();


    @Override
    public String executeSpringBootJar(RequestExecuteEntity requestExecuteEntity) throws Exception {
        String jarPath = requestExecuteEntity.getJarPath();
        String className = requestExecuteEntity.getClassName();
        String methodName = requestExecuteEntity.getMethodName();
        List<String> paramClassNameList = requestExecuteEntity.getParamClassNameList();
        List<String> paramJsonList = requestExecuteEntity.getParamJsonList();


        JarFileArchive jarFileArchive = new JarFileArchive(new File(jarPath));
        MyLauncher myLauncher = new MyLauncher(jarFileArchive);
        ClassLoader classLoader = myLauncher.getClassLoader();

        Class<?> aClass = classLoader.loadClass(className);
        List<Class<?>> paramClassList = new ArrayList<>();
        for (String paramClassName : paramClassNameList) {
            paramClassList.add(classLoader.loadClass(paramClassName));
        }
        Class<?>[] paramClassArray = paramClassList.toArray(new Class<?>[0]);


        List<Object> paramObjectList = new ArrayList<>();
        for (int i = 0; i < paramJsonList.size(); i++) {
            paramObjectList.add(GSON.fromJson(paramJsonList.get(i), paramClassList.get(i)));
        }

        Object[] paramObjectArray = paramObjectList.toArray(new Object[0]);

        Method method = aClass.getDeclaredMethod(methodName, paramClassArray);

        Object obj = aClass.newInstance();
        Object result = method.invoke(obj, paramObjectArray);
        LOGGER.info("result: {}", GSON.toJson(result));

        if (classLoader instanceof URLClassLoader) {
            ((URLClassLoader) classLoader).close();
        }

        return GSON.toJson(result);
    }
}
