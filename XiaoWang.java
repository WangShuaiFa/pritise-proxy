package proxy;
/*
* 卖方出售信息
* */
public class XiaoWang implements House{
    @Override
    public void information() {
        System.out.println("我是小王，我要卖房子了");
    }
}
