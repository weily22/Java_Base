interface Product {
  int getProduceTime();
}
// 让 Printer 类实现 Product 接口
public class Printer implements Product{
  private String[] printData = new String[MAX_CACHE_LINE];
  // 用以记录当前需打印的作业数
  private int dataNum = 0;
  public void out() {
    // 只要还有作业，就继续打印
    while (dataNum > 0) {
      System.out.println("打印机打印：" + printData[0]);
      // 把作业队列整体前移一位，并将剩下的作业数减1
      System.arraycopy(printData, 1, printData, 0, --dataNum);
    }
  }
  public void getData(String msg) {
    if (dataNum >= MAX_CACHE_LINE) {
      System.out.println("输出队列已满，添加失败");
    } else {
      // 把打印数据添加到队列里，已保存数据的数量加1
      printData[dataNum++] = msg;
    }
  }
  public int getProduceTime() {
    return 45;
  }
  public static void main(String[] args) {
    // 创建一个 Printer 对象，当成 Product 使用
    Product P = new Printer();
    System.out.println(p.getProduceTime());
  }
}