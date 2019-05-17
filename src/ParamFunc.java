import java.util.Arrays;

public class ParamFunc {
  public void paramTest(int[] arr) {
    int[] newArr = {6, 7};
    arr = newArr;
    System.out.println("类内数组值是：" + arr);
  }
  public static void main (String[] args) {
    int[] arr = {1,2,3,4,5,6};
    System.out.println("初始数组值是：" + arr);
    ParamFunc pf = new ParamFunc();
    pf.paramTest(arr);
    System.out.println("原数组值是：" + arr);
  }
}