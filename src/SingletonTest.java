class Singleton {
  // 使用一个类变量来缓存曾经创建的实例
  private static Singleton instance;
  // 对构造器使用 private 修饰，隐藏该构造器
  private Singleton () {}
  // 提供一个静态方法，用于返回 Singleton 实例
  // 
  public static Singleton getInstance() {
    // 如果 instance 为 null，则表明还不曾创建 Singleton 对象
    // 如果 instance 不为 null，则表明已经创建了 Singleton 对象
    // 将不会重新创建新的实例
    if (instance == null) {
      // 创建一个 Singleton 对象，并将其缓存起来
      instance = new Singleton();
    }
    return instance;
  }
}

public class SingletonTest {
  public static void main (String[] args) {
    // 创建 Singleton 对象不能通过构造器
    // 只能通过 getInstance 方法来得到实例
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println(s1 == s2);
  }
}
