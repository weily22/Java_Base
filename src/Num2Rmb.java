import java.util.Arrays;

public class Num2Rmb {
  private String[] ChineseArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
  private String[] unitArr = {"十", "百", "千"};
  /**
   * 把一个浮点数分解成整数部分和小数部分字符串
   * @param num 需要被分解的浮点数
   * @retrun 分解出来的整数部分和小数部分
   */
  private String[] divide(double num) {
    // 将一个浮点数强制类型转换为long型，即得到它的整数部分
    long intNum = (long) num;
    // 浮点数减去整数部分，得到小数部分，小数部分乘以100后再取整得到两位小数
    long decimal = Math.round((num - intNum) * 100);
    return new String[]{intNum + "", decimal + ""};
  }
  /**
   * 把一个四位的数字字符串变成汉字字符串
   * @param numStr 需要被转换的数字字符串
   * @return 转换后的汉字字符串
   */
  private String toChinese (String numStr) {
    String result = "";
    int numLen = numStr.length();
    // 遍历数字字符串
    for (int i = 0; i < numLen; i++) {
      // System.out.println("i:" + numStr.charAt(i));
      // 把char型数字转成int型数字，他们的ASCII码值恰好相差48
      int num = numStr.charAt(i) - 48;
      String unit = "";
      if (i != numLen-1 && num != 0) {
        unit = unitArr[numLen-2-i];
      }
      result += ChineseArr[num] + unit;
    }
    return result;
  }

  public static void main (String[] args) {
    Num2Rmb nr = new Num2Rmb();
    System.out.println("[整数部分, 小数部分]：" + Arrays.toString(nr.divide(8765.23)));
    String[] numSplit = nr.divide(8765.23);
    System.out.println("转化结果为：" + nr.toChinese(numSplit[0]) + "点" + nr.toChinese(numSplit[1]));
  }
}