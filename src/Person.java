public class Person {
  // 定义两个成员变量
  public String name;
  public int age;
  // 定义say方法
  public void say (String content) {
    System.out.println(content);
  }
  public static void main (String[] args) {
    Person p = new Person();
    // 访问p的name实例变量，直接为该变量赋值
    p.name = "西欧阿米";
    p.say("学到老，活到老");
    System.out.println("p的name为：" + p.name);
  }
}