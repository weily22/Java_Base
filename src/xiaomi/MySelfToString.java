package xiaomi;

class MySelfToString {
  private String color;
  public MySelfToString (String color) {
    this.color = color;
  }
  // 重写toString
  public String toString() {
    return "一个苹果的颜色是" + color;
  }
}

public class Test {
  public static void main (String[] args) {
    MySelfToString a = new MySelfToString("红色");
    System.out.println(a);
  }
}