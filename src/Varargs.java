public class Varargs {
  // 定义了形参个数可变的方法
  public static void test(String...books) {
    for (String tmp : books) {
      System.out.println(tmp);
    }
  }
  public static void main(String[] args) {
    test("小米", "小兜子");
  }
}