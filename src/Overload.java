public class Overload {
  public void test() {
    System.out.println("无参数");
  }
  public void test(String msg) {
    System.out.println("重载的方法：" + msg);
  }

  public static void main (String[] args) {
    Overload ol = new Overload();
    ol.test();
    ol.test("小米小米");
    int a;
    a = 5;
    System.out.println("a是：" + a);
  }
}