package com.ysx.execute.utils;

import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.archive.Archive;
import org.springframework.boot.loader.jar.JarFile;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2019-04-01 07:45
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 */
public class MyLauncher extends JarLauncher {
    public MyLauncher(Archive archive) {
        super(archive);
    }

    /**
     * 获取 ClassLoader
     *
     * @return
     * @throws Exception
     */
    public ClassLoader getClassLoader() throws Exception {
        JarFile.registerUrlProtocolHandler();
        ClassLoader classLoader = createClassLoader(getClassPathArchives());

        return classLoader;
    }
}
