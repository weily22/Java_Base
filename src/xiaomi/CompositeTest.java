package xiaomi;

class Animal{
  private void beat() {
    System.out.println("心脏跳动。。。");
  }
  public void breath() {
    beat();
    System.out.println("呼吸。。。");
  }
}

class Bird{
  // 将原来的父类组合到原来的子类，作为子类的一个组合成分
  private Animal a;
  public Bird(Animal a) {
    this.a = a;
  }
  // 重新定义一个自己的 breath() 方法
  public void breath() {
    // 直接复用Animal提供的breath()方法来实现Bird的breath()方法
    a.breath();
  }
  public void fly() {
    System.out.println("我在天空自在的飞翔。。。");
  }
}

class Wolf {
  // 将原来的父类组合到原来的子类，作为子类的一个组合部分
  private Animal a;
  public Wolf(Animal a) {
    this.a = a;
  }
  // 重新定义一个自己的 breath() 方法
  public void breath() {
    a.breath();
  }
  public void run() {
    System.out.println("我在陆地上快速奔跑。。。");
  }
}

public class CompositeTest {
  public static void main (String[] args) {
    // 显示创建被组合的对象
    Animal a1 = new Animal();
    Bird b = new Bird(a1);
    b.breath();
    b.fly();
    Animal a2 = new Animal();
    Wolf w = new Wolf(a2);
    w.breath();
    w.run();
  }
}