import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 张三 李四的代理类
 * Created by lz on 2017/3/28.
 */
public class DynamicProxy implements InvocationHandler {

    //需要代理的目标类 比如 张三，李四是目标类
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * @param target 需要代理的目标类 比如 张三，李四是目标类
     * @return 代理类实例，比如用来代理张三的实例
     */
    public Object bind(Object target) {
        this.target = target;

        /*通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
                * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
                * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
                * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上*/
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     *当代理对象调用真实对象的方法时，会调用代理对象的invoke方法
     * @param proxy 被代理的对象，这里应该传入张三李四
     * @param method 要调用的方法
     * @param args 方法调用时所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        System.out.println(formatter.format(new Date()) +" " + "开始学习");

        method.invoke(target,args);

        System.out.println(formatter.format(new Date()) +" " + "结束学习");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return null;
    }
}
