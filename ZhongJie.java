package proxy;
/*
静态代理
* */
public class ZhongJie implements House{
    private XiaoWang xiaoWang;
    public ZhongJie(XiaoWang xiaoWang) {
        this.xiaoWang=xiaoWang;

    }
    @Override
    public void information() {
        System.out.println("收到小王卖房子信息");
        xiaoWang.information();
        System.out.println("监控小王卖房子结束");
    }
    public static void main(String[] args) {
        House zhongJie = new ZhongJie(new XiaoWang());
        zhongJie.information();
    }
}
