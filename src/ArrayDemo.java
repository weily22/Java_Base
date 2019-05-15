import java.util.Arrays;

public class ArrayDemo {
  public static void main(String[] args) {
    // 数组的foreach循环
    // int[] arr = {11, 22, 33, 44, 55};
    // for (int item : arr) {
    //   System.out.println("数组元素为：" + item);
    // }
    // arrayInRam();
    arraysTest();
  }
  public static void arrayInRam() {
    // 定义并初始化数组，使用静态初始化
    int[] a = {5, 7, 20};
    // 定义并初始化数组，使用动态初始化
    int[] b = new int[4];
    b = a;
    boolean bool;
    a = null;
    bool = (a == b);
    System.out.println("a===b:" + bool);
    System.out.println("此时a:" + a);
    System.out.println("此时b:" + b);
  }
  public static void arraysTest() {
    int[] a = {3, 4, 5, 6};
    int[] a2 = {3, 4, 5, 6};
    boolean bool = (a == a2);
    System.out.println("a数组和a2数组是否相等：" + Arrays.equals(a, a2));
    System.out.println("a数组和a2数组是否相等==：" + bool);
    // 通过复制a数组，生成一个新的b数组
    int[] b = Arrays.copyOf(a, 4);
    System.out.println("a数组和b数组是否相等：" + Arrays.equals(a, b));
  }
 
}