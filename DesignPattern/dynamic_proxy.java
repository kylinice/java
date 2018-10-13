package DesignPattern;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class dynamic_proxy implements InvocationHandler {
    private Object coder;
    public dynamic_proxy(Object coder){
        this.coder = coder;
    }
    //回调方法 拦截到目标对象的时候执行
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println(System.currentTimeMillis());
        System.out.println(method.getName());
        //调用拦截到的方法
        Object result = method.invoke(coder, args);
        System.out.println(System.currentTimeMillis());
        return result;
    }
}
class dynamic_client{
    public static void main(String[] args) {
        //被代理的真实对象
        JavaCoder coder = new JavaCoder("jiangqihai");
        //创建中介类实例
        InvocationHandler handler = new dynamic_proxy(coder);
        //获取类加载器
        ClassLoader classloader = coder.getClass().getClassLoader();
        //动态产生一个代理类
        ICoder proxy = (ICoder) Proxy.newProxyInstance(classloader,
                coder.getClass().getInterfaces(), handler);
        //通过代理类执行implDemands方法
        proxy.implDemands("Modify user Management");
        proxy.test("33");
    }
}
