public class StringCompareTest {
  public static void main(String[] args) {
    String s1 = "小米江";
    String s2 = "小米";
    String s3 = "江";
    String s4 = "小米" + "江";
    String s5 = "小" + "米" + "江";
    String s6 = s2 + s3;
    String s7 = new String("小米江");
    System.out.println(s1 == s4);
    System.out.println(s1 == s5);
    System.out.println(s1 == s6);
    System.out.println(s1 == s7);
  }
}