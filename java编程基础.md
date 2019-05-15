# java编程基础笔记

> **内存分配 （6个保存数据的地方）**
>
> * 寄存器（最快，位于处理器内部， 数量有限，由编译器分配）
> * 堆栈（驻留与常规RAM(随机访问存储器)区域 ，堆栈指针上下移动创建和释放内存， 对象句柄）
> * 堆 （常规用途的内存池，java对象，灵活性（不必知道存储空间和时间），分配存储空间会花掉更多时间）
> * 静态存储（static，位于固定位置）
> * 常数存储 （通常处于程序内部）
> * 非RAM存储 (独立于程序之外)
>
> **java决定了每种主要类型的大小**
>
> | 主类型  | 大小                                    | 默认值         | 封装器类型 |
> | ------- | --------------------------------------- | -------------- | ---------- |
> | boolean | 1-bit                                   | false          | Boolean    |
> | char    | 16-bit                                  | '\u0000'(null) | Character  |
> | byte    | 8-bit     （-128 ~ 127）                | (byte)0        | Byte       |
> | short   | 16-bit   （-$2^{15}$  ~  +$ 2^{15}$-1） | (short)0       | Short      |
> | int     | 32-bit   （-$2^{31}$  ~  +$2^{31}$-1）  | 0              | Integer    |
> | long    | 64-bit   （-$2^{63}$  ~  +$2^{63} $-1） | 0L             | Long       |
> | float   | 32-bit                                  | 0.0f           | Float      |
> | double  | 64-bit                                  | 0.0d           | Double     |
> | void    | -                                       |                | Void       |
>
>

> **·java简史·** 
>
> [JDK]: #> "Java SE Development Kit"
>
> JDK 包含了 Java编译器、Java运行时环境（JRE），以及常用的Java类库
>
>
>
> 1996年 --- JDK1.0  ：    运行环境（JRE）和 开发环境（JDK）
>
> 1997年 --- JDK1.1  ：    添加JIT编译器 ，减少重复编译
>
> 1998年 --- JDK1.2  ：    发布 JSP/Servlet、EJB，拆分 J2EE、J2SE、J2ME，拆分核心api、可选api、特殊api
>
> * J2ME ：主要用于控制移动设备和信息家电等有限存储的设备
> * J2SE ：java技术的核心和基础
> * J2EE ：企业应用开发
>
> 2002年 --- JDK1.4 ：最为成熟的版本，由很多大公司参与，期间涌现大量基于java的框架，Struts、Spring等
>
> 2004年 --- JDK1.5 ：Sun 将 JDK1.5 改名为 JavaSE 5.0，J2EE 改为 Java EE，J2ME 改为 Java ME。添加泛型、for语句、形参、注释、自动拆箱和装箱等功能。通过注释简化EJB。推出MVC框架规范。
>
> 2006年 -- JDK1.6 （JavaSE 6） ：-- 
>
> 2007年 ：Google 推出基于Linux的开源手机操作平台：Android。该平台使用Java开发应用程序
>
> 2009年  ：Oracle 收购 Sun，并获得了两项软件资产：Java 和 Solaris。
>
> 2011年 -- JDK 1.7 （Java SE 7）：Oracle 发布 Java SE 7。引进了二进制整数、switch语句、菱形语法、多异常捕捉、自动关闭资源的try语句等。
>
> 2014年 -- JDK 1.8（Java SE 8） ：Lambda 表达式。
>
>
>
> **简单对比C#，Java，Ruby，Python**
>
> *C#*：2000年 `Microsoft` 发布，依赖于.NET平台，强类型语言，提供Windows任务的大量基类，局限于Windows平台
>
> *Java*：1995年 `Sun` 发布，跨平台，强类型语言，强大内置类库，安全性，健壮性，提供web应用开发支持，强大而复杂
>
> *Ruby*：1995年 `日本人松本行弘`发布，简洁易用，跨平台，弱类型动态语言，其Ruby On Rails提供了Web层的MVC框架，适合快速开发web站，性能低
>
> *Python*：1989年 `Guide` 开发，基于ABC教学语言，跨平台，解释型脚本语言，丰富&强大的类库，速度慢，格式不自由
>
> --
>
> **Java程序运行机制**
>
> 先编译，后解释
>
> 先编译成*.class文件，然后使用Java解释器（JVM）来解释执行
>
> JVM（Java虚拟机）。不同平台有不同平台的JVM，但它们都提供了相同的编程接口，通过虚拟机解释执行后，生成特点系统的机器码执行。
>
> 所有平台上的JVM向上提供给Java字节码统一的接口，向下适应于不同平台的接口则互不相同。
>
> --
>
> [JRE]: # "Java Runtime Environment"
>
> JRE包含JVM。JVM是运行Java程序的核心虚拟机，运行Java程序不仅需要核心虚拟机，还需要其他的类加载器、字节码校验器以及大量的基础类库。JRE包含了JVM及其他环境支持
>
> Oracle 为 `Java SE` 和 ` Java EE` 分别提供了 `JDK` 和 ` Java EE SDK` 两个开发包
>
> --
>
> **Javac 编译**
>
> ```bash
> javac -d . HW.java  // javac -d .  指定编译生成的字节码文件的存放路径 (.)点代表当前路径
> java java类名        // 运行java程序
> ```
>
> --
>
> **Java 程序的基本规则**
>
> 1. 类（class）是 Java 程序的最小程序单位
> 2. main 方法是 Java 程序的入口
> 3. Java程序源文件的文件名必须与public类的类名相同
>
> --
>
> **Java 垃圾回收机制（GC）** 
>
> Java 的内存分配和回收都是由 JRE 在后台自动进行
>
> Java 的	`堆内存` 是一个运行时数据区，用以保存类的实例
>
> Java `虚拟机的堆内存` 中存储着正在运行的应用程序所建立的所有对象
>
> 垃圾回收是一种动态存储管理技术，他自动释放不再被程序引用的对象，按照特定的垃圾回收算法来实现内存资源的自动回收功能
>
> 垃圾回收的范围：
>
> * 无用的对象。
> * 释放内存记录碎片
>
> --

> **面向对象**
>
> 继承、封装、多态
>
> 面向对象的方式由 `OOA （面向对象分析）`  `OOD（面向对象设计）`  `OOP（面向对象编程）`三个部分有机组成
>
> * 类是对象的抽象，对象则是类的实例
> * 类的封装将各种信息细节隐藏起来，通过公用方法暴露该类对外提供的功能
> * 对象是面向对象中最基本的概念
> * 消息是一个实例与另一个实例之间相互通讯的机制
>
> * Java不支持多继承
>
> --
>
> **UML**
>
> OOA 对目标系统进行分析，简历分析模型，并将之文档化，OOD用面向对象的思想对OOA的结果细化，得出设计模型。UML则是用于描述、记录OOA和OOD结果的符号表示法
>
> --
>
> **面向对象的特征**
>
> 对象具有唯一性，每个对象都有一个标识符来引用它
>
> 具有相同或相似性质的一组对象的抽象就是类，类的实例是对象
>
> Java语言使用 `class` 关键字定义类，定义类时，可用成员变量描述该类对象的数据，可用方法来描述该类对象的行为特征
>
> Java语言使用 `extends `关键字来表示继承关系
>
> --

> **注释**
>
> Java语言的注释包括：单行注释、多行注释、文档注释
>
> [文档注释]: # "编写Java源代码时添加合适的文档注释，并通过JDK提供的javadoc工具可将其提取成一份系统的API文档"
>
> ```java
> // 单行注释
> 
> /*
> 多行注释
> */
> 
> 文档注释
> /**
> * Description:
> * 描述xxxxxxxx xxx
> * @param: 方法的参数说明
> * @return: 方法的返回值说明信息
> * @author: 作者
> * @version: 版本
> **/
> ```
>
> --
>
> **标识符和关键字**
>
> 分隔符：分号（;）、花括号（{}）、方括号（[]）、圆括号（()）、空格、圆点（.）
>
> 标识符：用于给程序中变量、类、方法命名的符号。可由字母、数字、下划线、$组成，且数字不能打头
>
> 关键字：Java中有特殊用途的单词，当定义标识符时，不能是Java关键字
>
> --
>
> **数据类型和运算符**
>
> Java是强类型语言。so：
>
> 1. 所有的变量必须先声明、后使用
> 2. 指定类型的变量只能接受类型与之匹配的值。
>
> 声明变量：
>
> ```java
> type varName[ = 初始值];   // 变量可指定初始化值，也可不指定
> ```
>
> Java 语言支持的类型分为两类：
>
> 1. 基本类型：boolean、数值（整型类型（整型包括：byte、short、int、long、char）和浮点类型（浮点包括：float、double））
> 2. 引用类型：类、接口、数组类型、null类型
>
> 注：null 可以被转换为`任何引用类型`，不能转换成基本类型
>
> 注：字符串不是基本数据类型，字符串是一个类，即引用数据类型
>
> --
>
> **基本类型的转换：**
>
> 1. 自动转换
> 2. 强制类型转换
>
> Java所有的`数值型变量`可以相互转换。表数范围小的可以向表数范围大的进行自动类型转换
>
> 自动类型转换图=》
>
> ```mermaid
> graph LR
> A[byte] --> B(short) 
> B --> C{int}
> char --> C
> C --> D[long] 
> D --> E[float]
> E --> F[double]
> 
> ```
>
>
>
> --
>
> 字符串不能直接转换为基本类型，可以通过基本类型的包装类实现
>
> ```java
> String a = "45";
> // 使用 Integer 的方法将一个字符串转换成 int 类型
> int iValue = Integer.parseInt(a);
> ```
>
> Java的8种基本类型对应的包装类：
>
> *boolean ===> Boolean*
>
> *byte ===> Byte*
>
> *short ===> Short*
>
> *int ===> Integer*
>
> *long ===> Long*
>
> *char ===> Character*
>
> --
>
> **直接量**
>
> 在程序中通过源代码直接给出的值，下面对应的8种类型的直接量：
>
> *int*：整型数值，可分为二进制、十进制、八进制、十六进制4种。例：123
>
> *long*：在整数数值后添加 l 或 L 。例：3L
>
> *float*：在一个浮点数后添加 f 或 F 。例：2.34F、3.14E5f
>
> *double*：小数形式或科学计数法形式的浮点数。例：5.34、3.14E5
>
> *boolean*：只有 true 或 false
>
> *char*：用单引号括起来的字符、转义字符和 Unicode 值表示的字符。例：'a'、'\n' 、'\u0061'
>
> *String*： 用双引号括起来的字符序列。例："小米"
>
> *null*：只有一个值，即 null。(可以赋给任何引用类型的变量，表示这个引用类型变量中保存的地址为空)
>
> * 直接量赋值：` int a = 5; `
>
> * String 类型的直接量不能赋给其他类型的变量
> * Boolean 类型的直接量只能赋给boolean类型的变量
> * 当程序第一次使用某个字符串直接量时，Java 会使用常量池来缓存改字符串直接量，程序后面部分要用的话。Java会直接使用`常量池`中的字符串直接量。
>
> [^常量池]: 在编译期被确定，并被保存在已编译的.class文件中的一些数据。它包括关于类、方法、接口中的常量，也包括字符串直接量。
>
> --
>
> **运算符**
>
> 1. 算术运算符：加、减、乘、除、求余、自加（++）、自减（--）
>
> 2. 赋值运算符：=
>
> 3. 比较运算符：> 、>=、<、<=、==、!=
>
> 4. 逻辑运算符：
>
>    1. &&：与。前后两个操作数都是 true 才返回 true ,否则返回 false
>    2. &：按位与。见如下
>    3. ||：或。前后两个操作数有一个是 true，就可以返回 true，否则返回 false
>    4. |：按位或。见如下
>    5. !：非，只需一个操作数，如果操作数位 true，则返回 false，否则返回 false
>    6. ^：异或。见如下
>
> 5. 位运算符：
>
>    1. &：按位与。当两位同时为1时返回1
>    2. |：按位或。只要有一位为1即可返回1
>    3. ~：按位非。单目运算符，将操作数的每个位（包括符号位）全部取反
>    4. ^：按位异或。当两位相同时返回0，不同时返回1
>    5. <<：左移运算符。操作数的二进制码整体左移指定位数，右边空出来的位以0填充
>    6. \>>：右移运算符。第一个操作数的二进制码右移指定位数，左边空出来的位以原来的符号位填充
>    7. \>\>>：无符号右移运算符。第一个操作数的二进制码右移指定位数后，左边空出来的位以0填充
>
> 6. 三目运算符：
>
>    ```java
>    // 格式：(expression) ? if-true-statement : if-false-statement
>    String str = 5 > 3 ? "5大于3" : "5不大于3";
>    ```
>
> 单目运算符、赋值运算符、三目运算符从右像左运算
>
> 运算符优先级如下表：优先级从上到下，递减
>
> | 运算符说明         | Java运算符                                |
> | ------------------ | ----------------------------------------- |
> | 分隔符             | 、[]  ()  {}  ,  ;                        |
> | 单目运算符         | ++   --  ~  !                             |
> | 强制类型转换运算符 | (type)                                    |
> | 乘法/除法/求余     | *  /  %                                   |
> | 加法/减法          | +  -                                      |
> | 移位运算符         | <<  >>  >>>                               |
> | 关系运算符         | <  <=  >==  >  instanceof                 |
> | 等价运算符         | ==  !=                                    |
> | 按位与             | &                                         |
> | 按位异或           | ^                                         |
> | 按位或             | \|                                        |
> | 条件与             | &&                                        |
> | 条件或             | \|\|                                      |
> | 三目运算符         | ? :                                       |
> | 赋值               | =  +=  -=  *=  /=  ^=  %=  <<=  >>=  >>>= |
>
> --

> **流程控制**
>
> 分支结构：Java 提供了 if 和 switch两种分支结构
>
> 循环结构：Java 提供了 while 、do while 和 for 三种循环语句
>
> ```java
> ================================ if 篇：========================
> // if-1 形式-
> if (logic expression) {
>     statement...
> }
> // if-2 形式二
> if (logic expression) {
>     statement...
> } else {
>     statement...
> }
> // if-3 形式三
> if (logic expression) {
>     statement...
> } else if (logic expression) {
>     statement...
> } else {
>     statement...
> }
> 
> ```
>
> ```java
> ================================ switch 篇：========================
> switch (expression) {
>    case condition1:
>    {
>        statement(s)
>        break;
>    }
>    case condition2:
>    {
>        statement(s)
>        break;      
>    }
>    ...
>    default:
>    {
>       statement(s)        
>    }
> }
> ```
>
> ```java
> ================================ while 篇：========================
> while (test_expression) {
>     statement;
> }
> 
> // 先对test_expression循环条件求值，如果条件为true,则运行循环体部分statement。
> ```
>
> ```java
> ================================ do while 篇：========================
> do {
>    statement;
> } while (test_expression);
> 
> // 先执行一遍循环体里的部分，在判断条件
> ```
>
> ```java
> ================================ for 篇：========================
> for ([init_statement];[test_expression];[iteration_statement]) {
>     statement
> }
> // 先执行初始化语句init_statement（只执行一次），再计算是否满足test_expression的值，如果true,则执行循环体statement，接着执行iteration_statement，此时再去比较test_expression的值，依次循环到到返回false为止。
> ```
>
> --
>
> Java提供了`continue` 和 `break` 来控制循环结构
>
> `break`：完全结束一个循环，跳出循环体
>
> `continue`：只是忽略本次循环剩下语句，接着开始下一次循环，并不会终止循环
>
> 例子如下：
>
> ```java
> public class ForDemo {
> 	public static void main(String[] args) {
>         for (int i = 0; i < 5; i++) {
>             if (i == 1) {
>                 // 忽略本次循环的剩下语句
>                 continue;
>             }
>             System.out,println(i + "lallalalalalla");
>         }
> 	}
> }
> // 输出结果:
> // 0 lallalalalalla
> // 2 lallalalalalla
> // 3 lallalalalalla
> // 4 lallalalalalla
> 
> 上述for循环修改为：
> for (int i = 0; i < 5; i++) {
>     if (i == 2) {
>         // 结束循环
>         break;
>     }
>     System.out,println(i + "lallalalalalla");
> }
> // 输出结果:
> // 0 lallalalalalla
> // 1 lallalalalalla
> ```
>
> --

> **数组**
>
> 1. Java 的数组要求所有的数组元素具有相同的数据类型。（`js` 的数组元素可以有不同数据类型）
> 2. 一旦数组初始化完成，数组在内存中所占空间被固定，数组的长度不可改变。（`js`中数组长度可变）
>
> Java定义数组的方式：
>
> ```java
> type[] arrayName;   // 推荐，语言好，可读性好
> type arrayName[];
> ```
>
> **数组定义**：数组定义变量时，仅仅代表定义了一个引用变量（即定义了一个指针），这个引用变量还未指向任何有效的内存，因此定义数组时不能指定数组的长度。
>
> **初始化**（为数组元素分配内存空间）：而且定义数组只是定义了一个引用变量，并未指向任何有效的空间，所以还没有内存空间来存储数组元素，因此这个数组也不能使用，只是对数组进行初始化后才可以使用。
>
> * 静态初始化：程序员显示指定每个数组元素的初始值，由系统决定数组长度
>
>   ```java
>   arrayName = new type[]{element1, element2, element3, element4 ...}
>   
>   // 例：
>   // int [] intArr;
>   // intArr = new int[]{2,3,4,5}
>   ```
>
> * 动态初始化：程序员只指定数组长度，由系统为数组元素分配初始值
>
>   ```java
>   arrayName = new type[length];
>   
>   // 例：
>   // int[] prices = new int[5];
>   // Object[] books = new String[4];
>   ```
>
> 当动态初始化时，程序员只需指定数组的长度，系统自动为这些数组元素分配初始值，初始值规则如下：
>
> | 数组元素类型               | 初始值   |
> | -------------------------- | -------- |
> | byte、short、int、long     | 0        |
> | float、double              | 0.0      |
> | char                       | '\u0000' |
> | boolean                    | false    |
> | 引用类型（类、接口和数组） | null     |
>
> **数组用法**
>
> 数组索引从0开始
>
> ```java
> objArr[1]   // 取出数组的第二个元素
> objArr[0] = "xiaomi";  // 为数组中的第一个元素赋值
> ```
>
> 如若访问数组元素时指定的索引值小于0或大于数组的长度，则运行时会出现异常：`java.lang.ArrayIndexOutOfBoundsException:N`（数组索引越界异常）
>
> *length*（数组的属性）：可以访问数组的长度。
>
> *foreach*（Java提供的一种简单循环）：遍历数组和集合的每个元素
>
> ```java
> for(type variableName : array | collection) {
> 	// variableName自动迭代访问每个元素
> }
> 
> // 例：
> // int[] arr = {11, 22, 33, 44, 55};
> // for (int item : arr) {
> //    System.out.println("数组元素为：" + item);
> // }
> ==> 
> // 数组元素为：11
> // 数组元素为：22
> // 数组元素为：33
> // 数组元素为：44
> // 数组元素为：55
> 
> ```
>
> --
>
> **数组在内存中的运行机制**
>
> 数组是一种引用数据类型，`引用变量`只是一个引用。数组元素和数组变量在内存里是分开存放的。
>
> * 如果希望访问数组对象本身，则只能通过这个数组的引用变量来访问它
> * 实际的数组被存储在堆（heap）内存中；如果引用该数组对象的数组引用表娘是一个局部变量，那么它被存储在栈（stack）内存中。
>
> 数组在内存中的存储示意图如下：
>
> ```graph
> 
> ```
>
> [堆内存和栈内存]: #	"每个方法都会建立自己的内存栈，在这个 方法内定义的变量 将放入栈内存里，随着方法结束而销毁。在程序中创建一个对象时，这个对象将被保存在运行时数据区中，以便反复利用，这个运行时数据区就是堆内存。堆内存中的对象不会随方法的结束而销毁。只有当一个对象没有任何引用变量引用它时，系统的垃圾回收器才会在合适的时候回收它。"
>
> ```java
> // 例：静态初始化过程：
> int[] a = {1,2,3};
> // 赋值表达式从右向左运算。
> // 首先 {1,2,3}, 在堆内存中开辟空间长度为三，并生成这个空间的地址，同时三个下标隐式初始化为0
> // 接着 = a int[],在栈内存中压入类型为int[]的变量a,将其赋值为上一步返回的内存地址 (即a指向了该内存地址)
> // 接着分别显示初始化三个下标的值1，2，3
> 
> // 例：动态初始化过程：
> int[] iArr = new int[5];
> // 首先，系统为该数组分配一个长度为5的内存空间，并生成一个空间地址，同时5个下标默认初始值0
> // 接着执行 = iArr int[],在栈内存中压入类型为int[]的变量iArr，并将其指向该内存地址
> ```
>
> 引用类型数组的初始化：
>
> ```
> 
> ```
>
> **Java 8增强的工具类：`Arrays`**
>
> Arrays 类在 java.util 包下，在程序中使用Arrays类，需导入：
>
> ```java
> import java.util.Arrays;
> ```
>
> Java提供的Arrays类里包含的一些 static 修饰的方法可以直接操作数组，这些方法如下（static修饰的方法可以直接通过类名调用）：
>
> 数组对应的例子见代码：[arrayTest](https://github.com/weily22/Java_Base/blob/master/src/ArrayDemo.java)
>
> 1. int binarySearch(type[] a, type key)：
>    * 使用二分法查询key元素值在a数组中出现的索引；如果a数组不包含key元素值，则返回负数。
>    * 调用该方法要求数组中元素已经按升序排列
> 2. boolean equals(type[] a, type[] a2)：
>    * 如果a数组和a2数组的长度相等，且a数组和a2数组的数组元素也一一相同，改方法将返回true。
> 3. type[] copyOf(type[] original, int length)：
>    * 这个方法会把original数组复制成一个新数组，其中length是新数组的长度，其中length是新数组的长度。如果 length 小于 origin 数组的长度，则新数组就是原数组的前面length个元素；如果length大于original数组的长度，则新数组的前面元素就是原数组的所有元素，后面补充0（数值类型）、false（布尔类型）或者null（引用类型）
> 4. type[] copyOfRange(type[] original, int from , int to)：
>    * 与上一个方法类似，但这个方法只复制original数组的from索引到to索引的元素
> 5. String toString(type[] a)：
>    * 该方法将一个数组转换成一个字符串。该方法按顺序把多个数组元素连缀在一起，多个数组元素使用英文逗号（,）和空格隔开
> 6. void fill(type[] a, type val)：
>    * 该方法将数组的所有元素都赋值为val
> 7. void fill(type[] a, int fromIndex, int toIndex, type val)：
>    * 该方法将a数组的 fromIndex 到 toIndex索引的数组元素赋值为 val
> 8. void sort (type[] a)：
>    * 该方法将a数组的数组元素进行排序。
> 9. void sort (type[] a, int fromIndex, toIndex)：
>    * 与前一个方法相似，区别是该方法仅仅对fromIndex 到 toIndex 索引的元素进行排序
>
> 除此之外，
>
> 在 System 类里也包含了一个 static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)方法，该方法可以将src数组里的元素值赋给dest数组的元素，其中srcPos指定从src数组的第几个元素开始赋值，length参数指定将src数组的多少个元素值赋给dest数组的元素。
>
> ```java
> 例：
> // 将b数组中第3个元素开始，取出2个元素赋值给c数组的索引从1开始的元素值
>  int[] b = {0, 0, 1, 1, 3, 4};
>  int[] c = {1};
>  System.arraycopy(b, 2, c, 1, 2);
>  System.out.println("得到的c数组元素为：" + Arrays.toString(c));
> 
> => 
> // 得到的c数组元素为：[1, 1, 1]
> ```
>
> Java 8 为 Arrays类增加的工具方法。
>
> 对应的例子见：[arrayTest2](https://github.com/weily22/Java_Base/blob/master/src/ArrayDemo.java)
>
> 1. void parallelSort(type[] a)：
>    * 该功能与sort()方法类似，只是该方法增强了并行能力，可以利用多CPU并行来提高性能
> 2. void setAll(type[] array, IntToXxxFunction generator)：
>    * 该方法使用指定的生成器（generator）为所有的数组元素设置值，该生成器控制数组元素的值得生成算法
> 3. void parallelSetAll(type[] array, IntToXxxFunction generator )：
>    * 功能与上一个方法相同，只是改方法增加了并行能力，可以利用多CPU并行来提高性能
>
> 数组应用案例：
>
> `数字字符串转成汉字字符串，简易版`：见代码：[Num2Rmb](https://github.com/weily22/Java_Base/blob/master/src/Num2Rmb.java)
>
> --

> **面向对象**
>
>
>
> --