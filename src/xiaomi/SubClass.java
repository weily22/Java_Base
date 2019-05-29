package xiaomi;

class BaseClass {
  public int book = 6;
  public void base() {
    System.out.println("父类的普通方法");
  }
  public void test() {
    System.out.println("父类的被覆盖的方法");
  }
}

class SubClass extends BaseClass {
  public String book = "西欧阿米";
  public void test() {
    System.out.println("子类覆盖父类的方法");
  }
  public void sub () {
    System.out.println("子类的普通方法");
  }
  public static void main (String[] args) {
    BaseClass bc = new BaseClass();
    System.out.println("BaseClass实例对象调用book: " +  bc.book);
    bc.base();
    bc.test();
    SubClass sc = new SubClass();
    System.out.println("SubClass实例对象调用book: " +  sc.book);
    sc.base();
    sc.test();
    BaseClass polymophicBc = new SubClass();
    System.out.println("编译时类型BaseClass，运行时类型是SubClass，实例对象调用book: " +  polymophicBc.book);
    polymophicBc.base();
    polymophicBc.test();
  
  }
}