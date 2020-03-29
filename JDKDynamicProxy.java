package proxy;

import javax.jws.WebService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* JDK动态代理
* */
public class JDKDynamicProxy implements InvocationHandler {
    private Object target;
    public JDKDynamicProxy( Object target){
       this.target=target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("卖方监听开始");
        Object invoke = method.invoke(target, args);
        System.out.println("卖方监听结束");
        return invoke;
    }

    public static void main(String[] args) {
        XiaoWang xiaoWang = new XiaoWang();
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(xiaoWang);
        //JDK动态代理，通过反射机制创建代理类
        House house = (House) Proxy.newProxyInstance(xiaoWang.getClass().getClassLoader(), xiaoWang.getClass().getInterfaces(), jdkDynamicProxy);
        house.information();
    }
}
