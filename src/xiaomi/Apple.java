package xiaomi;

public class Apple extends Fruit{
  // 重写父类的info
  public void info() {
    System.out.println("哈哈，我是苹果，我的重量是50g!");
    // 调用父类被覆盖的实例方法
    super.info();
  }
  public static void main(String[] args) {
    // 创建 apple 对象
    Apple a = new Apple();
    // Apple对象可以访问Fruit的weight成员变量
    a.weight = 100;
    a.info();
  }
}