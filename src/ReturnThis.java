public class ReturnThis {
  public int age;
  public ReturnThis grow() {
    age++;
    return this;
  }
  public static void main (String[] args) {
    ReturnThis rt = new ReturnThis();
    rt.grow().grow();
    System.out.println("rt的成员变量age为：" + rt.age);
  }
}