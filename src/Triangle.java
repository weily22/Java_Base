/**
 * 抽象类
 * 抽象类里的初始化块和构造器是在创建其子类的实例时被调用
 */
public abstract class Shape {
  {
    System.out.println("执行 Shape 的初始化块...");
  }
  private String color;
  // 定义一个计算周长的抽象方法
  public abstract double calPerimeter();
  // 定义一个返回形状的抽象方法
  public abstract String getType();
  // 定义构造器，用于被子类调用
  public Shape(){}
  public Shape (String color) {
    System.out.println("执行Shape的构造器...");
    this.color = color;
  }
}

public class Triangle extends Shape {
  // 定义三角形的三边
  private double a;
  private double b;
  private double c;
  public Triangle(String color, double a, double b, double c) {
    super(color);
    this.setSides(a, b, c);
  }
  public void setSides(double a, double b, double c) {
    if (a >= b + c || b >= a + c || c >= a + b) {
      System.out.println("三角形两边之和必须大于第三边");
      return;
    }
    this.a = a;
    this.b = b;
    this.c = c;
  }
  // 重写 Shape 类的计算周长的抽象方法
  public double calPerimeter() {
    return a + b + c;
  }
  // 重写 Shape 类的返回形状的抽象方法
  public String getType() {
    return "三角形";
  }
  public static void main (String[] args) {
    Shape s = new Triangle("黑色", 3, 4, 5);
    System.out.println(s.getType());
    System.out.println(s.calPerimeter());

  }
}