#  java编程基础笔记

> <h2 id="xiaomi">目录</h2>
>
> - [java简史](#JS)
> - [面向对象](#MXDX)
>   - [基本类型](#JBLX)
>   - [流程控制](LCKZ)
>   - [数组](ARRAY)
>   - [Java里的方法](Function)
>   - [类的继承](EXTEND)



> 内存分配 （6个保存数据的地方）**
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

> <h4 id="JS">.java简史.</h4>
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

> <h4 id="MXDX">面向对象</h4>
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
> <h5 id="JBLX">基本类型的转换：</h5>
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

> <h5 id="LCKZ">流程控制</h5>
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

> <h5 id="ARRAY">数组</h5>
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
> Java是面向对象的程序设计语言
>
> Java语言定义了类、成员变量、方法等基本的功能
>
> 可以使用类来定义变量，所有使用类定义的变量都是引用变量
>
> Java支持面向对象的三大特征：封装、继承和多态
>
> Java提供了private、protected 和 public 三个访问控制修饰符来实现良好的封装，提供了extends关键字来让子类继承父类
>
> 面向对象的程序设计过程中有两个重要概念：类（class） 和 对象（object）
>
> `类是某一批对象的抽象，可以把类理解成某种概念；对象才是一个具体存在的实体`
>
> Java语言里定义类的语法如下：
>
> ```java
> [修饰符] class 类名 {
>     零个到多个构造器定义...
>     零到多个成员变量...
>     零个到多个方法...
> }
> 
> // 修饰符可以是public 、final 、abstract
> // 定义一个类，可以包含三种最常见的成员：构造器、成员变量和方法
> // 类里各成员之间可以相互调用，但是static修饰的成员不能访问没有static修饰的成员。
> // 成员变量：用于定义该类或该类的实例所包含的状态数据
> // 方法：用于定义该类或该类的实例的行为特征或者功能实现
> // 构造器：用于构造该类的实例
> ```
>
> 定义成员变量的语法格式：
>
> ```java
> [修饰符] 类型 成员变量名 [=默认值];
> ```
>
> * 修饰符：可省略，也可以是 public、protected、private、static、final，其中 public、protected、private 三个最多只能出现其中之一，可以与 static、final 组合起来修饰成员变量
> * 类型：可以是Java语言允许的任何数据类型，包括基本类型和现在介绍的引用类型
> * 成员变量名：合法标识符。在Java世界里属性指的是一组setter方法和getter方法，so`不要将成员变量说成是属性`
> * 默认值：定义成员变量可以指定一个可选的默认值
>
> 定义方法的语法格式：
>
> ```java
> [修饰符] 方法返回值类型 方法名(形参列表) {
>     // 由零条到多条可执行性语句组成的方法体
> }
> ```
>
> * 修饰符：可省略，也可以是public、protected、private、static、final、abstract。其中 public、protected、private 三个最多只能出现其中之一，可以与 static 组合起来修饰方法
> * 方法返回值类型：可以是Java语言允许的任何数据类型，如果声明了返回值，则方法体内必须有一个有效的return语句，且返回的类型值与声明的类型值匹配。如果一个方法没有返回值，则用void来声明
> * 方法名：合法标识符。建议方法名以英文动词开头
> * 形参列表：该方法接受的参数，多个参数用英文逗号（,）隔开
>
> #####`static`：
>
> static 是一个特殊的关键字，它可用于修饰方法、成员变量等成员。
>
> static 修饰的成员表明它属于这个类本身，而不属于该类的单个实例，因为通常把static修饰的成员变量和方法也称为类变量、类方法。不使用static修饰的普通方法、成员变量则属于该类的单个实例，而不属于类，通常称为实例变量和实例方法。
>
> 由于 static 的英文直译就是静态的意思，有时也把static修饰的成员变量和方法称为静态变量和静态方法，不使用static修饰的称为非静态变量和非静态方法。
>
> 静态成员不能直接访问非静态成员
>
> 定义构造器的语法格式：
>
> ```java
> [修饰符] 构造器名(形参列表) {
>    // 由零条到多条可执行性语句组成的构造器执行体
> }
> ```
>
> * 修饰符：可省略，也可以是public、protected、private其中之一
> * 构造器名：必须与类名相同。
> * 形参列表：和定义方法形参列表的格式完全相同
>
> 定义一个Person类:
>
> ```java
> public class Person {
>   // 定义两个成员变量
>   public String name;
>   public int age;
>   // 定义say方法
>   public void say (String content) {
>     System.out.println(content);
>   }
> }
> 
> // 没有定义构造器，系统将为它提供一个默认的构造器
> ```
>
> 类大致有如下作用：
>
> 1. 定义变量
> 2. 创建对象
> 3. 调用类的类方法或访问类的类变量
>
> 创建对象：通过 new 关键字来调用某个类的构造器即可创建这个类的实例
>
> ```java
> Person p = new Person();
> // 使用 Person 类定义一个Person类的变量,
> // 通过 new 关键字调用 Person 类的构造器，返回一个 Person 实例
> // 上述过程即 定义p变量的同时把 Person实例 赋值给 p变量
> ```
>
> Java对象大致有如下作用：
>
> 1. 访问对象的实例变量
> 2. 调用对象的方法
>
> 如果访问权限允许，类里定义的方法和变量都可以通过类或实例来调用。类或实例访问方法或成员变量：
>
> `实例.实例变量（方法）`
>
> static修饰的方法和成员变量，既可通过类来调用，也可通过实例来调用
>
> 没有static修饰的方法和成员变量，只可通过实例来调用
>
> ```java
> // 访问p的name实例变量，直接为该变量赋值
> p.name = "西欧阿米";
> // 调用该方法比较为形参指定一个值
> p.say("学到老，活到老");
> System.out.println("p的name为：" + p.name);
> 
> =>
> // 学到老，活到老
> // p的name为：西欧阿米
> ```
>
> 完整代码见：[Person](https://github.com/weily22/Java_Base/blob/master/src/Person.java)
>
> ============******================ 对象、引用和指针 ============******==========
>
> ```java
> Person p = new Person();
> ```
>
> 1. 在这行代码中实际产生了两个东西：一个是 P 变量，一个是Person对象
>
> 2. 在上面Person类定义来看，Person对象应包含两个实例变量（name, age），而变量是需要内存来存储的
>
> 3. 和数组类型类似，类也是一种引用数据类型，定义Person类型的变量实际上是一个引用，它被存放在栈内存里，指向实际的Person对象，而真正的Person对象则存放在堆内存中
>
> 4. 堆内存里的对象可以有多个引用，即多个引用变量指向同一个对象
>
>    * ```java
>      // 将p变量的值赋值给p2变量
>      Person p2 = p;
>      ```
>
> **对象的this引用**
>
> Java提供了一个this关键字，this关键字总是指向调用该方法的对象。根据 this 出现位置的不同，this作为对象的默认引用有两种情形
>
> 1. 构造器中引用该构造器正在初始化的对象
> 2. 在方法中引用调用该方法的对象
>
> 如下例子：
>
> ```java
> public class Dog {
>   // 定义一个jump()方法
>   public void jump() {
>     System.out.println("正在执行jump方法");
>   }
>   // 定义一个run()方法，run()方法需要借助jump()方法
>   public void run() {
>     Dog d = new Dog();
>     d.jump();
>     System.out.println("正在执行run方法");
>   }
>   public static void main (String[] args) {
>     Dog dog = new Dog();
>     dog.run();
>   }
> }
> ```
>
> :question:1. 在 run() 方法中调用 jump() 方法时是否一定需要一个 Dog 对象？
>
> :question:2. 是否一定要重新创建一个 Dog 对象?
>
> 1. 第一个问题肯定。因为没有使用 static 修饰的成员变量和方法必须使用对象来调用
> 2. 第二个问题否定。因为当程序调用 run() 方法时，一定会提供一个 Dog 对象，这样就可以直接使用这个已经存在的 Dog 对象，而无须重新创建新的 Dog 对象
>
> 因此在 run() 方法中获得调用该方法的对象，通过 this 关键字就可以满足这个要求。
>
> this 可以代表任何对象，当 this 出现在某个方法体中时，它所代表的对象是不确定的，但它的类型是确定的，它所代表的对象只能是当前类；只有当这个方法被调用时，它所代表的对象才被确定下来：
>
> 谁在调用这个方法，this就代表谁。
>
> so，将上面的代码修改如下更合适
>
> ```java
> public void run () {
>    this.jump();
>    System.out.println("正在执行run方法");
> }
> ```
>
> Java 允许对象的一个成员直接调用另一个成员，可以省略 this 前缀。也就是说上面的代码可以直接这么写：
>
> ```java
> public void run () {
>    jump();
>    System.out.println("正在执行run方法");
> }
> ```
>
> static 修饰的方法中不能使用this引用。由于 static 修饰的方法不能使用 this 引用，所以static 修饰的方法不能访问不使用static修饰的普通成员，因此Java语法规定：
>
> *静态成员不能直接访问非静态成员*
>
> 当this作为对象的默认引用时，程序可以像访问普通引用变量一样来访问这个this引用。
>
> ```java
> public class ReturnThis {
>   public int age;
>   public ReturnThis grow() {
>     age++;
>     return this;
>   }
>   public static void main (String[] args) {
>     ReturnThis rt = new ReturnThis();
>     rt.grow().grow();
>     System.out.println("rt的成员变量age为：" + rt.age);
>   }
> }
> 
> => 
> // rt的成员变量age为：2
> ```
>
> <h5 id="Function">Java里的方法</h5>
>
> 方法是类的对象的行为特征。实际上，从方法的功能来看，可以看出方法和函数之间的相似性
>
> 但是，
>
> 1. 方法与传统的函数有着显著的不同：在结构化编程语言里，函数是一等公民，整个软件由一个个的函数组成；在面向对象编程语言里，类才是一等公民，整个系统由一个个的类组成。
> 2. 在 Java 语言里，方法不能独立存在，方法必须属于类或对象。
> 3. Java语言是静态的。一个类定义完成后，只要不再重新编译这个类文件，该类和该类的对象所拥有的方法是固定的，永远都不会改变。
> 4. 方法不能像函数那样独立执行，执行方法时必须使用类或对象来作为调用者
> 5. 类里面不同方法之间可以相互调用是因为：
>    * 同一个类的一个方法调用另外一个方法时，如果被调方法是普通方法，则默认使用this来作为调用者；如果被调方法是静态方法，则默认使用类作为调用者。
> 6. 使用 static 修饰的方法属于这个类本身，使用 static 修饰的方法既可以使用类作为调用者来调用，也可以使用对象作为调用者来调用
>    * 注意：因为使用static修饰的方法还是属于这个类的，因此使用该类的任何对象来调用这个方法时将会得到相同的执行结果。
> 7. 没有使用 static 修饰的方法则属于该类的对象。不属于这个类本身。因此没有 static 修饰的方法只能使用对象作为调用者来调用。
>
> Java 方法的参数传递：值传递，如果方法中声明了形参，则必须传入参数值
>
> 方法参数传递例子：
>
> ```java
> import java.util.Arrays;
> 
> public class ParamFunc {
>   public void paramTest(int[] arr) {
>     int[] newArr = {6, 7};
>     arr = newArr;
>     System.out.println("类内数组值是：" + arr);
>   }
>   public static void main (String[] args) {
>     int[] arr = {1,2,3,4,5,6};
>     System.out.println("初始数组值是：" + arr);
>     ParamFunc pf = new ParamFunc();
>     pf.paramTest(arr);
>     System.out.println("原数组值是：" + arr);
>   }
> }
> 
> =>
> // 初始数组值是：[I@6a6824be
> // 类内数组值是：[I@5c8da962
> // 原数组值是：[I@6a6824be
> ```
>
> **形参个数可变的方法：**
>
> 从 JDK1.5 之后，Java允许定义形参个数可变的参数，从而允许为方法指定数量不确定的形参。
>
> 用法：在形参的类型后增加三点(…)，则表明该形参可以接受多个参数值，多个参数组被当成数组传入。
>
> ```java
> public class Varargs {
>   // 定义了形参个数可变的方法
>   public static void test(String...books) {
>     for (String tmp : books) {
>       System.out.println(tmp);
>     }
>   }
>   public static void main(String[] args) {
>     test("小米", "小兜子");
>   }
> }
> 
> =>
> // 小米
> // 小兜子
> ```
>
> **递归方法：**
>
> 一个方法体内调用它自身，被称为方法递归。方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
>
> :question:$f(0) = 1, f(1)=4, f(n+2)=2*f(n+1)+f(n)$，其中 $n$ 是大于0的整数，求 $f(10)$的值
>
> ```java
> public class Recursive {
>   public static int fn(int n) {
>     if (n == 0) {
>       return 1;
>     } else if (n == 1) {
>       return 4;
>     } else {
>       return 2*fn(n-1) + fn(n-2);
>     }
>   }
> 
>   public static void main (String[] args) {
>     System.out.println(fn(10));
>   }
> }
> 
> =>
> // 10497
> ```
>
> **方法重载**
>
> Java里一个类里可以定义多个同名方法，只要形参列表不同就行。
>
> 方法重载：`同一个类中方法名相同，参数列表不同。`
>
> 确定一个方法的三要素：
>
> 1. 调用者，既可以是类，也可以是对象
> 2. 方法名，方法的标识
> 3. 形参列表
>
> ```java
> public class Overload {
>   public void test() {
>     System.out.println("无参数");
>   }
>   public void test(String msg) {
>     System.out.println("重载的方法：" + msg);
>   }
> 
>   public static void main (String[] args) {
>     Overload ol = new Overload();
>     ol.test();
>     ol.test("小米小米");
>   }
> }
> ```
>
> **成员变量和局部变量**
>
> 成员变量指的是在类里定义的变量
>
> 局部变量指的是在方法里定义的变量
>
> 成员变量
>
> * 类变量 （以 static 修饰）：从该类的准备阶段起开始存在，直到系统完全销毁这个类
> * 实例变量 (不以 static 修饰)：从该类的实例被创建起开始存在，直到系统完全销毁这个实例
>
> 局部变量
>
> * 形参（方法签名中定义的变量）：形参的作用域在整个方法内有效
> * 方法局部变量（在方法内定义）：它的作用域从定义该变量的地方生效，到该方法结束时失效
> * 代码局部变量（在代码块内定义）：它的作用域从定义该变量的地方生效，到该代码块结束时失效
>
> --.-- 局部变量除了形参之外，都必须显示初始化。
>
> --.-- 当通过类或对象调用某个方法时，系统会在该方法栈区内为所有的形参分配内存空间，并将实参的值赋给对应的形参，这就完成了形参的初始化
>
> --.-- 一个类里不能定义两个同名的成员变量
>
> --.--  方法局部变量与形参名也不能相同
>
> 当系统加载类或创建该类的实例时，系统自动为成员变量分配内存空间，并在分配内存空间后，自动为成员变量指定初始值。
>
> **隐藏和封装**
>
> 封装是面向对象的特征之一（另外两个是继承和多态）
>
> 封装：指的是将对象的状态信息隐藏在对象内部，不允许外部程序直接访问对象内部信息，而是通过该类所提供的方法来实现对内部信息的操作和访问。
>
> Java提供了三个访问控制符：`private` 、`protected` 和 `public` ，另外还有一个不加任何访问控制符的访问控制级别。
>
> Java 的访问控制级别由大到小如下：
>
> ```bash
> private  >  default  >  protected  >  public
> ```
>
> **private** (当前类访问权限)：如果类里的成员变量、方法或构造器等使用 private 访问控制符来修饰，则这个成员只能在当前类的内部被访问。
>
> **default** (包访问权限)：如果类里的成员变量、方法和构造器等或者一个外部类不使用任何访问控制符修饰，就称它是包访问限制的，default 访问控制的成员或外部类可以被相同包下的其他类访问。
>
> **protected** (子类访问权限)：如果一个成员（包括成员变量、方法和构造器等）使用 protected 访问控制符修饰，那么这个成员既可以被同一个包中的其他类访问，也可以不被包中的子类访问。
>
> **public** (公共访问权限)：如果一个成员（包括成员变量、方法和构造器等）或者一个外部类使用 public 访问控制符修饰，那么这个成员或外部类就可以被所有类访问，不管访问类和被访问类是否处于同一个包中，是否具有父子继承关系。
>
> 访问控制级别表：
>
> |            | private | default | protected | public |
> | ---------- | :-----: | :-----: | :-------: | :----: |
> | 同一个类中 |    √    |    √    |     √     |   √    |
> | 同一个包中 |         |    √    |     √     |   √    |
> | 子类中     |         |         |     √     |   √    |
> | 全局范围内 |         |         |           |   √    |
>
> 访问控制符使用的基本原则：
>
> 1. 类里的绝大部分成员变量都应该使用 private 修饰，只有一些 static 修饰的、类似全局变量的成员变量，才可能考虑使用 public 修饰。除此之外，有些方法只用于辅助实现该类的其他方法，这些方法被称为工具方法，工具方法也应该使用 private 修饰。
> 2. 如果某个类主要用做其他类的父亲，该类里包含的大部分方法可能仅希望被其子类重写，而不想被外界直接调用，则应该使用 protected 修饰这些方法。
> 3. 希望暴露出来给其他类自由调用的方法应该使用 public 修饰。因此，类的构造器通过使用 public 修饰，从而允许在其他地方创建该类的实例。
>
>
>
> **package、import 、import static**
>
> Java 引入了包（package）机制，提供了类的多层命名空间，用于解决类的命名冲突、类文件管理等问题。
>
> Java 允许将一组功能相关的类放在同一个 package 下，从而组成逻辑上的类库单元。如果希望把一个类放在指定的包结构下，应该在Java源程序的第一个非注释行放置如下格式的代码：
>
> ```java
> package packageName;
> ```
>
> 一旦在 Java 源文件中使用了这个 package 语句，就意味着该源文件里定义的所有类都属于这个包。位于包中的每个类的完整类名都应该是包名和类名的组合，如果其他人需要使用该包下的类，也应该使用包名加类名的组合。
>
> 为了避免不同公司之间类名的重复，Oracle建议使用公司Internet域名倒写来作为包名，例如公司的Internet域名是crazyit.org，则该公司的所有类都建议放在 org.crazyit包及其子包下。
>
> Java 的包机制需要两个方面保证：
>
> 1. 源文件里使用package语句指定包名
> 2. class 文件必须放在对应的路径下
>
> ================================================= import =========================
>
> Java 引入了 import 关键字，import 可以向某个Java文件中导入指定包层次下某个类或全部类，import 语句应该出现在 package 语句之后、类定义之前。
>
> 一个 Java 源文件 只能包含一个 package 语句，但可以包含多个 import 语句，多个 import 语句用于导入多个包层次下的类。
>
> 使用 import 导入单个类的用法：
>
> ```java
> import package.subpackage...ClassName;
> ```
>
> 使用 import 导入指定包下全部类的用法：
>
> ```java
> import package.subpackage...*;
> 
> // 例：
> // import xiaomi.*;
> // 表明导入xiaomi包下的所有类，但xiaomi包下sub子包内的类则不会被导入。如需导入sub子包内的类，则可以使用 import xiaomi.sub.*; 语句来导入xiaomi.sub包下的所有类
> ```
>
> Java 默认为所有源文件导入 java.lang 包下的所有类，因此前面在 java 程序中使用 String、System 类时都无须使用 import 语句来导入这些类。
>
> 在一些极端的情况下，import 语句也 帮不了我们，此时只能在源文件中使用类全名。
>
> 例如：
>
> ```java
> import java.util.*;
> import java.sql.*;
> ```
>
> 如果接下来在程序中需要使用Date类，则会引起如下编译错误：
>
> ```ba&#39;s
> HelloTest.java:25 对 Date 的引用不明确
> java.sql 中的类 java.sql.Date 和 java.util 中的类 java.util.Date 都匹配
> ```
>
> 在这种情况下，如果需要指定包下的Date 类，则只能使用该类的全名。
>
> ```java
> java.sql.Date d = new java.sql.Date();
> ```
>
> JDK 1.5 以后增加了一种静态导入的语法，它用于导入指定类的某个静态成员变量、方法或全部的静态成员变量、方法。
>
> 静态导入有两种语法：
>
> 1. 导入指定类的单个静态成员变量、方法的语法格式如下：
>
>    ```java
>    import static package.subpackage...ClassName.fieldName|methodName;
>    // 例：
>    // import static java.lang.System.out
>    // 导入 java.lang.System 类的out 静态成员变量
>    ...
>    // PI是java.lang.System类的静态成员变量，代表标准输出
>    out.println(PI);
>    ```
>
> 2. 导入指定类的全部静态成员变量、方法的语法格式如下：
>
>    ```java
>    import static package.subpackage...ClassName.*;
>    ```
>
> 使用 import 可以省略写包名；而使用 import static 则可以连类名都省略。
>
> **Java 的 常用包：**
>
> * *Java.lang* ：这个包下包含了 Java 语言的核心类，如 String、Math、System 和 Thread 类等，使用这个包下的类无须使用 import 语句导入，系统会自动导入这个包下的所有类。
> * *java.util*：这个包下包含了Java的大量工具类/接口和集合框架类/接口，例如 Arrays 和 List 、Set等。
> * *java.net*：这个包下包含了一些Java网络编程相关的类/接口
> * *java.io* ：这个包下包含了一些Java输入/输出编程相关的类
> * *java.text*：这个包下包含了一些Java格式化相关的类
> * *java.sql*：这个包下包含了Java进行JDBC数据库编程的相关类/接口
> * *java.awt*：这个包下包含了 Swing 图形用户界面编程的相关类/接口，这些类可用于构建平台无关的 GUI 程序。
>
> --
>
> **构造器**
>
> 构造器是一个特殊的方法，这个特殊方法用于创建实例时来执行初始化。
>
> 如果程序员没有为java类提供任何构造器，则系统会为这个类提供一个无参数的构造器，这个构造器的执行体为空，不做任何事情。无论如何，Java类至少包含一个构造器。
>
> 当创建一个对象时，系统为这个对象的实例变量进行默认初始化，这种默认的初始化把所有基本类型的实例变量设为0（对数值型实例变量）或 false（对布尔型实例变量），把所有引用类型的实例变量设为null。如果想要改变这种默认的初始化，想让系统创建对像时就为该对象的实例变量显示指定初始值，就可以通过构造器来实现。
>
> 如果一个类里提供了多个构造器，就形成了构造器的重载。
>
> 构造器中可以通过 this 来调用另一个重载构造器
>
> --
>
> <h5 id="EXTEND">类的继承</h5>
>
> Java 的继承通过 extends 关键字来实现，实现继承的类被称为子类，被继承的类被称为父类，有的也称为基类、超类。
>
> Java 的继承具有单继承的特点，即每个类只能有一个直接父类。
>
> 如果定义一个Java类时并未显示指定这个类的直接父类，则这个类默认扩展java.lang.Object类。因此，java.lang.Object类是所有类的父类。
>
> Java 里子类继承父类的语法格式如下：
>
> ```java
> 修饰符 class SubClass extends SuperClass {
>     // 类定义部分
> }
> ```
>
> 例：[完整代码](https://github.com/weily22/Java_Base/blob/master/src/xiaomi/Fruit.java)
>
> ```java
> // Fruit:父类
> public class Fruit {
>   public double weight;
>   public void info() {
>     System.out.println("我是一个水果！重" + weight + "g!");
>   }
> }
> // Apple：子类
> public class Apple extends Fruit{
>   public static void main(String[] args) {
>     // 创建 apple 对象
>     Apple a = new Apple();
>     // Apple对象可以访问Fruit的weight成员变量
>     a.weight = 100;
>     a.info();
>   }
> }
> 
> =>
> // 我是一个水果！重100.0g!
> ```
>
> **子类重写父类**
>
> ```java
> public class Apple extends Fruit{
>   // 重写父类的info
>   public void info() {
>     System.out.println("哈哈，我是苹果，我的重量是50g!");
>   }
>   public static void main(String[] args) {
>     // 创建 apple 对象
>     Apple a = new Apple();
>     // Apple对象可以访问Fruit的weight成员变量
>     a.weight = 100;
>     a.info();
>   }
> }
> =>
> // 哈哈，我是苹果，我的重量是50g!
> ```
>
> 方法的重写要遵循"两同两小一大"规则：
>
> "两同"：方法名相同、形参列表相同
>
> "两小"：子类方法返回值类型应比父类方法返回值类型更小或相等，子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等
>
> "一大"：子类方法的访问权限应比父类方法的访问权限更大或相等
>
>
>
> 当子类覆盖父类的方法后：
>
> 子类对象就不能访问父类被覆盖的方法了，但可以使用 super (被覆盖的实例方法) 或者 父类类名（被覆盖的类方法）作为调用者来调用父类中被覆盖的方法
>
> 如果父类方法具有private 访问权限，则该方法对其子类是隐藏的，因此其子类无法访问该方法，也就是无法重写该方法。
>
> 方法重载和方法重写：overload 和 override
>
> 重载主要放在同一个类的多个同名方法之间
>
> 重写的话发生在子类和父类的同名方法之间
>
> 当然，父类方法和子类方法也有可能发生重载
>
> --
>
> *super*： 
>
> * 子类方法中调用父类被覆盖的实例方法，则可以使用super限定来调用父类被覆盖的实例方法。
> * 子类方法中调用父类被覆盖的实例变量，同理，super.var ( var：变量名)
>
> [具体代码点这](https://github.com/weily22/Java_Base/blob/master/src/xiaomi/Apple.java)
>
> ```java
> public void info() {
>   System.out.println("子方法：哈哈，我是苹果，我的重量是50g!");
>     // 调用父类被覆盖的实例方法
>     super.info();
> }
> 
> =>
> // 子方法：哈哈，我是苹果，我的重量是50g!
> // 父方法：我是一个水果！重100.0g!
> ```
>
> 使用super调用和使用this调用构造器的区别在于：
>
> super 调用的是其父亲的构造器，而this调用的是同一个类中重载的构造器。
>
> 子类构造器总会调用父类构造器一次：
>
> 1. 子类构造器执行体的第一行使用 super 显示调用父类构造器，系统将根据super 调用里传入的实参列表调用父类对应的构造器
> 2. 子类构造器执行体的第一行代码使用 this 显示调用本类中重载的构造器，系统将根据 this 调用传入的实参列表调用本类中的另一个构造器
> 3. 子类构造器执行体中既没有 super 调用，也没有 this 调用，系统将会在执行子类构造器之前，隐式调用父类无参数的构造器。
>
> [案例](https://github.com/weily22/Java_Base/blob/master/src/xiaomi/Wolf.java)
>
> --
>
> 创建任何 Java 对象，最先执行的总是 java.lang.Object 类的构造器
>
> **多态**
>
> Java 引用变量有两个类型：
>
> 一个是编译时类型，一个是运行时类型
>
> 编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给变量的对象决定。
>
> 如果编译时类型和运行时类型不一致，就可能出现所谓的多态。
>
> ```java
> class BaseClass {
>   public int book = 6;
>   public void base() {
>     System.out.println("父类的普通方法");
>   }
>   public void test() {
>     System.out.println("父类的被覆盖的方法");
>   }
> }
> class SubClass extends BaseClass {
>   public String book = "西欧阿米";
>   public void test() {
>     System.out.println("子类覆盖父类的方法");
>   }
>   public void sub () {
>     System.out.println("子类的普通方法");
>   }
>   public static void main (String[] args) {
>     BaseClass bc = new BaseClass();
>     System.out.println("BaseClass实例对象调用book: " +  bc.book);
>     bc.base();
>     bc.test();
>     SubClass sc = new SubClass();
>     System.out.println("SubClass实例对象调用book: " +  sc.book);
>     sc.base();
>     sc.test();
>     BaseClass polymophicBc = new SubClass();
>     System.out.println("编译时类型BaseClass，运行时类型是SubClass，实例对象调用book: " +  polymophicBc.book);
>     polymophicBc.base();
>     polymophicBc.test();
>   
>   }
> }
> 
> 
> =>
> // BaseClass实例对象调用book: 6
> // 父类的普通方法
> // 父类的被覆盖的方法
> // SubClass实例对象调用book: 西欧阿米
> // 父类的普通方法
> // 子类覆盖父类的方法
> // 编译时类型BaseClass，运行时类型是SubClass，实例对象调用book: 6
> // 父类的普通方法
> // 子类覆盖父类的方法
> 
> ```
>
> Java 允许把一个子类对象直接赋给一个父类引用变量，无须任何类型转换。或者被称为向上转型
>
> 当把一个子类对象直接赋给父类引用变量时，如上面的 `BaseClass polymophicBc = new SubClass()`
>
> 这个polymophicBc引用变量的编译时类型是 BaseClass，而运行时类型是 SubClass , 当运行时调用该引用变量的方法时，其方法行为总是表现出子类方法的行为特征，而不是父类方法的行为特征，这就可能出现：
>
> 相同类型的变量，调用同一个方法时呈现出多种不同的行为特征，这就是多态
>
> 与方法不同的是，对象的实例变量则不具备多态性
>
> 编写代码时，引用变量只能调用声明该变量时所用类里包含的方法，例如：
>
> 通过 Object p = new Person();代码定义一个变量 p，则这个 p 只能调用 Object 类的方法，而不能调用 Person 类里定义的方法。
>
> 通过引用变量来访问其包含的实例变量时，系统总是试图访问它编译时类型所定义的成员变量，而不是它运行时类型所定义的成员变量
>
> **引用变量的强制类型转换**
>
> 因为引用变量只能调用它编译时类型的方法，而不能调用它运行时类型的方法。如果需要让这个变量调用它运行时类型的方法，则必须把强制类型转换成运行时类型，强制类型转换需要借助于类型转换运算符：
>
> 类型转换运算符是小括号，用法：(type) varible
>
> 即，将 varible 变量转换成一个 type 类型的变量
>
> 类型转换运算符可以将一个引用类型变量转换成其子类类型
>
> * 引用类型之间的转换只能在具有继承关系的两个类型之间进行
>
> 可以使用 instanceof 运算符判断是否可以转换, 前一个对象是否是后一个类的实例
>
> `引用类型变量 instanceof 类`
>
> **继承与组合**
>
> 继承是实现复用的重要手段，但继承会破坏封装。相比之下，组合也是实现类复用的重要方式，而采用组合方式来实现类复用则能提供更好的封装性。
>
> ```java
> class Base {
>   public Base() {
>     test();
>   }
>   public void test() {
>     System.out.println("将被子类重写方法");
>   }
> }
> 
> public class Sub extends Base {
>   private String name;
>   public void test() {
>     System.out.println("子类重写父类的方法，其name字符串长度" + name.length());
>   }
>   public static void main(String[] args) {
>     // 下面代码会引发空指针
>     Sub s = new Sub();
>   }
> }
> 
> =>
> // Exception in thread "main" java.lang.NullPointerException
> // at xiaomi.Sub.test(Sub.java:15)
> // Sub.java:15
> //	at xiaomi.Base.<init>(Sub.java:5)
> //	at xiaomi.Sub.<init>(Sub.java:12)
> //	at xiaomi.Sub.main(Sub.java:19)
> 
> // 如果父类构造器调用了被其子类重写的方法，则变成调用被子类重写后的方法。
> //当创建 Sub 对象时，先执行 Base 构造器，而 Base 构造器中调用了 test()方法，调的是子类重写的test方法，此时 Sub对象的name实例变量是 null ，因此将引发空指针异常
> ```
>
> 如果想把某些类设置成最终类，即不能被当成父类，则可以使用 final 修饰这个类
>
> **利用组合实现复用**
>
> 如果需要复用一个类，除了把这个类当成基类来继承之外，还可以把该类当成另一个类的组合成分，从而允许新类直接复用该类的 public 方法。
>
> 继承：子类可以直接获得父类的 public 方法，程序使用子类时，可以直接访问子类从父类那里继承到的方法
>
> 组合：组合把旧类对象作为新类的成员变量组合进来，用以实现新类的功能
>
> **初始化块**
>
> Java 使用构造器来对单个对象进行初始化操作，使用构造器先完成整个Java对象的状态初始化，然后将 Java对象返回给程序，从而让该 Java 对象的信息更加完整。与构造器作用非常类似的是初始化块，它也可以对 Java 对象进行初始化操作。
>
> 初始化块是 Java 类里可以出现的第4种成员（前面依次有成员变量、方法和构造器）
>
> 一个类里可以有多个初始化块，相同类型的初始化块之间有顺序：
>
> 前面定义的初始化块先执行，后面定义的初始化块后执行。
>
> ```java
> [修饰符] {
>    // 初始化块的可执行代码
> }
> ```
>
> 初始化块的修饰符只能是 static :
>
> 1. 使用 static 修饰的初始化块被称为静态初始化块
> 2. 初始化块内可以包含任何可执行性语句，包括定义局部变量、调用其他对象的方法，以及使用分支、循环语句等。
> 3. 如果两个构造器中有相同的初始化代码，且这些初始化代码无须接收参数，就可以把它们放在初始化块中定义
> 4. Java系统加载并初始化某个类时，总是保证该类的所有父类（包括直接父类和间接父类）全部加载并初始化
>
> 例子：[Person对象创建的过程](https://github.com/weily22/Java_Base/blob/master/src/xiaomi/Person.java)
>
> 当创建Java对象时，系统总是先调用该类里定义的初始化块
>
> --
>
> **Java 8 增强的包装类**
>
> Java 包含了8中基本数据类型，Java为其提供了对应的包装类：
>
> | 基本数据类型 | 包装类    |
> | ------------ | --------- |
> | byte         | Byte      |
> | short        | Short     |
> | int          | Integer   |
> | long         | Long      |
> | char         | Character |
> | float        | Float     |
> | double       | Double    |
> | boolean      | Boolean   |
>
> JDK1.5提供了自动装箱和自动拆箱功能
>
> 自动装箱：可以把一个基本类型变量直接赋给对应的包装类变量
>
> 自动拆箱：允许直接把包装类对象直接赋给一个对应的基本类型变量
>
>
>
> --end