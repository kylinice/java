package test;

import java.util.Comparator;
public class test_relation {
}
//依赖：是类与类之间的连接,表示一个类依赖于另外一个类的定义;依赖关系仅仅描述了类与类之间的一种使用与被使用的关系
//比如说我要过河，没有桥怎么办，我就去借来一条小船渡过去。我与小船的关系仅仅是使用（借用）的关系。
class Boat{
    public void row(){
        System.out.println("开船");
    }
}
class Person_boat{
    public void crossRiver(Boat boat){
        boat.row();
    }
    public void fishing(){
        Boat boat = new Boat();
        boat.row();
    }

    public static void main(String[] args) {
        Boat boat = new Boat();
        Person_boat person = new Person_boat();
        person.crossRiver(boat);
        person.fishing();
    }
}
//关联：类与类之间的连结,关联关系使一个类知道另外一个类的属性和方法;通常含有“知道”,“了解”的含义。关联可以是双向的，也可以是单向的
//例子：我和我的电脑的例子，是一种关联的关系，是一种“拥有”的关系。

//依赖和关联的区别在于依赖是使用，关联是拥有。
class Computer{
    public void develop(){
        System.out.println("开发软件");
    }
}
class Person_computer{
    private Computer computer;
    public Person_computer(Computer computer){
        this.computer = computer;
    }
    public void work(){
        computer.develop();
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Person_computer person = new Person_computer(computer);
        person.work();
    }
}
//聚合：含义:是关联关系的一种,是一种强关联关系（has-a）;聚合关系是整体和个体/部分之间的关系;
// 关联关系的两个类处于同一个层次上,而聚合关系的两个类处于不同的层次上,一个是整体,一个是个体/部分;在聚合关系中,
//代表个体/部分的对象有可能会被多个代表整体的对象所共享;
class Classes{
    private Student student ;
    public Classes(Student student){
        this.student = student ;
    }
}

class Student{

}

//组合：它也是关联关系的一种（contains-a）,但它是比聚合关系更强的关系.组合关系要求聚合关系中代表整体的对象要负责代表个体/部分的对象的整个生命周期;
// 组合关系不能共享;在组合关系中,如果代表整体的对象被销毁或破坏,那么代表个体/部分的对象也一定会被销毁或破坏,
// 而聚在合关系中,代表个体/部分的对象则有可能被多个代表整体的对象所共享,而不一定会随着某个代表整体的对象被销毁或破坏而被销毁或破坏;
//举例:1.一个人由头、四肢、等各种器官组成，因为人与这些器官具有相同的生命周期，人死了，这些器官也挂了;
//     2.房子和房间的关系，当房子没有了，房间同样不可能单独存在。
class Room{
    public Room createRoom(){
        System.out.println("创建房间");
        return new Room();
    }
}
class House{
    private Room room;
    public House(){
        room = new Room();
    }
    public void createRoom(){
        room.createRoom();
    }

    public static void main(String[] args) {
        House house = new House();
        house.createRoom();
    }
}
//区别：1.聚合和组合的区别：聚合是个体离开了整体，依然可以存在；组合是个体和整体不可以分开，个体不能离开整体单独存在.
//      2.(依赖，关联) 和(聚合，组合)的区别：
//      依赖，关联 : 类之间的关系是在同一层次上.
//      聚合，组合: 类之间的关系表现为整体和部分.
/*
总结：
对于继承、实现这两种关系没多少疑问，它们体现的是一种类和类、或者类与接口间的纵向关系。
其他的四种关系体现的是类和类、或者类与接口间的引用、横向关系，是比较难区分的，有很多事物间的关系要想准确定位是很难的。
前面也提到，这四种关系都是语义级别的，所以从代码层面并不能完全区分各种关系，
但总的来说，后几种关系所表现的强弱程度依次为：组合>聚合>关联>依赖。
 */


