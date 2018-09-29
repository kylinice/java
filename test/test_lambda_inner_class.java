package test;
abstract class Bird{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public abstract int fly();
}
interface Inner {
    String getName();
}
/*
由于匿名内部类不能是抽象类，所以它必须要实现它的抽象父类或者接口里面所有的抽象方法。
对于这段匿名内部类代码其实是可以拆分为如下形式：
public class WildGoose extends Bird{
    public int fly() {
        return 10000;
    }

    public String getName() {
        return "大雁";
    }
}

WildGoose wildGoose = new WildGoose();
test.test(wildGoose);
 */
public class test_lambda_inner_class {
    public void test(Bird bird){
        System.out.println(bird.getName() + " can fly " + bird.fly() + "m");
    }
    /*
    留意外部类的方法的形参，当所在的方法的形参需要被内部类里面使用时，该形参必须为final。
    这里可以看到形参name已经定义为final了，而形参city 没有被使用则不用定义为final。
     */
    public Inner getInner(final String name, String city) {
        return new Inner() {
            private String nameStr = name;

            public String getName() {
                return nameStr;
            }
        };
    }

    public static void main(String[] args) {
        test_lambda_inner_class test = new test_lambda_inner_class();
        test.test(new Bird() {
            @Override
            public int fly() {
                return 10000;
            }
            @Override
            public String getName() {
                return "wild goose";//大雁
            }
        });

        Inner inner = test.getInner("Inner", "gz");
        System.out.println(inner.getName());
    }
}
