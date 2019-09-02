package com.animo.boot.aop.custom.service.impl;

import com.animo.boot.aop.custom.invoke.Invocation;
import com.animo.boot.aop.custom.service.Interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 刘金泳
 * @Date 2019/8/22
 */
public class Myinterceptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("before>>>>>>>>");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after>>>>>>>");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before >>>>>>");
        Object object = invocation.proceed();
        System.out.println("around after >>>>>>>");
        return object;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning>>>>>>>>");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing>>>>>>>>>");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
