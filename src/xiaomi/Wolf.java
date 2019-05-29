package xiaomi;

class Creature {
  public Creature() {
    System.out.println("Creature 无参数的构造器");
  }
}

class Animal extends Creature {
  public Animal(String name) {
    System.out.println("Animal带一个参数的name是" + name);
  }
  public Animal(String name, int age) {
    // 使用this调用同一个构造器
    this(name);
    System.out.println("Animal带两个参数的age是" + age);
  }
}

public class Wolf extends Animal {
  public Wolf () {
    // 显示调用父类有两个参数的构造器
    super("灰太狼", 3);
    System.out.println("Wolf无参数的构造器");
  }
  public static void main(String[] args) {
    new Wolf();
  }
}