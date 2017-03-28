/**
 * 学生张三 被代理的类
 * Created by lz on 2017/3/28.
 */
public class ZhangSan implements Student{
    @Override
    public void study() {
        try {
            System.out.println("我是张三，我在学习");
            Thread.sleep(2000); //用来模拟学习的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
