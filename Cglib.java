package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*使用cglib动态代理模式
* */
public class Cglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是房产中介，开始用cglib监听你了");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("我是房产中介，用cglib监听结束了");
        return invokeSuper;
    }

    public static void main(String[] args) {
        Cglib cglib = new Cglib();
        //动态代理，使用asm框架生成代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(XiaoWang.class);
        enhancer.setCallback(cglib);
        House o = (House) enhancer.create();
        o.information();
    }
}
