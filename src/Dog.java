public class Dog {
  public int foo;
  public Dog() {
    // 在构造器里定义一个foo变量
    int foo = 9;
    // 使用this代表构造器正在初始化的对象
    // 下面的代码将会把该构造器正在初始化的对象的foo成员变量设成6
    this.foo = 6;
  }
  // 定义一个jump()方法
  public void jump() {
    System.out.println("正在执行jump方法");
  }
  // 定义一个run()方法，run()方法需要借助jump()方法
  public void run() {
    jump();
    System.out.println("正在执行run方法");
  }
  public static void main (String[] args) {
    Dog dog = new Dog();
    dog.run();
    System.out.println("foo的值为：" + dog.foo);
  }
}