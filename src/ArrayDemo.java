import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class ArrayDemo {
  public static void main(String[] args) {
    // 数组的foreach循环
    // int[] arr = {11, 22, 33, 44, 55};
    // for (int item : arr) {
    //   System.out.println("数组元素为：" + item);
    // }
    // arrayInRam();
    // arraysTest();
    arraysTest2();
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
    int[] c = {1, 2, 4};
    // boolean bool = (a == a2);
    System.out.println("a数组和a2数组是否相等：" + Arrays.equals(a, a2));
    System.out.println("a数组和a2数组是否相等==：" + (a == a2));
    // 通过复制a数组，生成一个新的b数组
    int[] b = Arrays.copyOf(a, 6);
    System.out.println("a数组和b数组是否相等：" + Arrays.equals(a, b));
    System.out.println("b数组的元素为：" + Arrays.toString(b));
    // 将b数组的第三个元素到第5个元素即区间[3,5)赋值为1
    Arrays.fill(b, 2, 4, 1);
    System.out.println("b数组此时的元素为：" + Arrays.toString(b));
    // 对b数组进行排序
    Arrays.sort(b);
    System.out.println("排序后的b数组的元素为：" + Arrays.toString(b));
    // 将b数组中第3个元素开始，取出2个元素赋值给c数组的索引从1开始的元素值
    System.arraycopy(b, 2, c, 1, 2);
    System.out.println("得到的c数组元素为：" + Arrays.toString(c));
  }
  public static void arraysTest2() {
    int[] arr1 = {1, 2, 3, 0, -5, -9, 8, 9};
    int[] arr2 = {2, 4, 5, 6, 7, 9, -2, 0};
    // 对数组进行并发排序
    Arrays.parallelSort(arr1);
    System.out.println(Arrays.toString(arr1));
    Arrays.parallelSetAll(arr2, new IntUnaryOperator(){
      // operand 代表正在计算的元素索引
      @Override
      public int applyAsInt(int operand) {
        return operand * 5;
      }
    });
    System.out.println("arr2：" + Arrays.toString(arr2));
  }
 
}