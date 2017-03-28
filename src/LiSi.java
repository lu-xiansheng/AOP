/**
 *学生李四，被代理的类
 * Created by lz on 2017/3/28.
 */
public class LiSi implements Student{

    @Override
    public void study() {
        try {
            System.out.println("我是李四，我在学习");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
