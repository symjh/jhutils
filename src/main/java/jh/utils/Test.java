package jh.utils;


import jh.utils.proxy.Child;
import jh.utils.proxy.Parent;
import jh.utils.proxy.Proxy;
import jh.utils.proxy.ProxyMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test  {


    public static void main(String[] args) {
        Test cglib = new Test();//实例化CglibProxy对象

        Proxy proxy =  new Proxy();
        ProxyMethodInterceptor proxyMethodInterceptor = new ProxyMethodInterceptor();
        proxyMethodInterceptor.setTarget(proxy);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(proxy.getClass());
        enhancer.setCallback(proxyMethodInterceptor);
        Proxy proxy1 =  (Proxy) enhancer.create();//获取代理对象
        proxy1.doSomething();


    }



}
