public class Main {

    public static void main(String[] args) {

        //得到张三的代理类
        Student zhangSanProxy = (Student) new DynamicProxy().bind(new ZhangSan());
        //得到李四的代理类
        Student liSiProxy = (Student) new DynamicProxy().bind(new LiSi());
        zhangSanProxy.study();
        liSiProxy.study();

    }
}
