package xiaomi;

class Base {
  public Base() {
    test();
  }
  public void test() {
    System.out.println("将被子类重写方法");
  }
}

public class Sub extends Base {
  private String name;
  public void test() {
    System.out.println("子类重写父类的方法，其name字符串长度" + name.length());
  }
  public static void main(String[] args) {
    // 下面代码会引发空指针
    Sub s = new Sub();
  }
}