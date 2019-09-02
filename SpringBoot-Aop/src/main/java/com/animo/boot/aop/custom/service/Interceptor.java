package com.animo.boot.aop.custom.service;


import com.animo.boot.aop.custom.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * 拦截器
 * @author 刘金泳
 * @Date 2019/8/22
 */
public interface Interceptor {

    /**
     * 事前方法
     * @return
     */
    boolean before();

    /**
     * 事后方法
     */
    void after();

    /**
     *取代原有事件方法
     * @param invocation 一回调参数，可以通过它的 proceed方法， 回调原有事件 * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation)
            throws InvocationTargetException,IllegalAccessException;

    /**
     * 是否返回方法，事件没有发生异常执行。
     */
    void afterReturning();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    void afterThrowing ();

    /**
     * 是否使用around取代原方法
     * @return
     */
    boolean useAround();
}
