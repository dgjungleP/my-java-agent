package com.jungle;

import com.alibaba.fastjson.JSON;

public class CallLogAspect {
    public static void before(String className, String methodName, String description, Object[] params) {
        System.out.println("Method start at:" + System.currentTimeMillis());
        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);
        System.out.println("description = " + description);
        System.out.println("params = " + JSON.toJSONString(params));
    }

    public static void error(String className, String methodName, String description, Throwable throwable) {
        System.out.println("Method error at:" + System.currentTimeMillis());
        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);
        System.out.println("description = " + description);
        System.out.println("error message = " + throwable.getMessage());
    }

    public static void after(String className, String methodName, String description, Object returnValue) {
        System.out.println("Method end at:" + System.currentTimeMillis());
        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);
        System.out.println("description = " + description);
        System.out.println("return value = " + JSON.toJSONString(returnValue));
    }
}
