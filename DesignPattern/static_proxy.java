package DesignPattern;
//模拟用户找产品经理增加需求
/*
1.抽象角色
定义一个码农接口，它有着一个实现用户需求的方法。
 */
interface ICoder{
    void implDemands(String demandName);
    void test(String str);
}
/*
2.真实角色
我们假设小张是Java程序员，定义一个JAVA码农类，他通过Java语言实现需求
 */
class JavaCoder implements ICoder{
    private String name;
    public JavaCoder(String name){
        this.name = name;
    }
    @Override
    public void implDemands(String demandName){
        System.out.println(name + " implements demand:" + demandName + " in Java!");
    }
    @Override
    public void test(String str){
        System.out.println("test");
    }
}
/*
3.代理角色
将产品经理设置为代理类，同时实现ICoder接口
 */
public class static_proxy implements ICoder{
    private ICoder coder;
    public static_proxy(ICoder coder){
        this.coder = coder;
    }
    @Override
    public void implDemands(String demandName){
        //产品经理当然不只是转达用户需求，他还有很多事情可以做。
        // 比如，该项目决定不接受新增功能的需求了，对修CoderProxy类做一些修改：
        if(demandName.startsWith("Add")){
            System.out.println("No longer receive 'Add' demand!");
            return;
        }//这样，当客户再有增加功能的需求时，产品经理就直接回绝了，程序员无需再对这部分需求做过滤。
        coder.implDemands(demandName);//原来只有这一行
    }
    @Override
    public void test(String str){
        System.out.println("test");
    }
}
//客户类
class Customer1{
    public static void main(String[] args) {
        //定义一个java码农
        ICoder coder = new JavaCoder("jiangqihai");
        //定义一个产品经理
        ICoder proxy = new static_proxy(coder);
        //让产品经理实现一个需求
        proxy.implDemands("Add");
    }
}
//产品经理充当了程序员的代理，客户把需求告诉产品经理，并不需要和程序员接触。