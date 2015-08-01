/**
 * ------------------------------ 代理模式(Proxy) -------------------------------
(1)
代理的好处:
--->是可以在间接访问对象的同时,要其前或后,添加其它的逻辑代码.
--->对原来逻辑进行添加其它逻辑,最终生成新的逻辑.即:对类的方法添加一些额外的逻辑,生成新的方法逻辑.
(2)
静态代理:
-->一个原类与一个代理类要一一对应。
-->两者都实现共同的接口或继承相同的抽象类；
-->只是在代理类中,实例化原类，在原类方法的前后添加新的逻辑。


------------------------------ 代理模式(Proxy) -------------------------------
(1)
代理的好处:
--->是可以在间接访问对象的同时,要其前或后,添加其它的逻辑代码.
--->对原来逻辑进行添加其它逻辑,最终生成新的逻辑.即:对类的方法添加一些额外的逻辑,生成新的方法逻辑.
(2)
静态代理:
-->一个原类与一个代理类要一一对应。
-->两者都实现共同的接口或继承相同的抽象类；
-->只是在代理类中,实例化原类，在原类方法的前后添加新的逻辑。
如下:
抽象角色：
abstract public class Subject
{
    abstract public void request();
}
真实角色：
public class RealSubject extends Subject
{
       public void request()
       {
              System.out.println("From real subject.");
       }
}
代理角色：
public class ProxySubject extends Subject
{
    private RealSubject realSubject;  //以真实角色作为代理角色的属性
       public ProxySubject()
       { realSubject=new RealSubject(); }
       public void request()  //与原方法名相同
       {
        preRequest();
        realSubject.request();  //此处执行真实对象的request方法
        postRequest();
      }
    private void preRequest()
    {
        //something you want to do before requesting
    }
    private void postRequest()
    {
        //something you want to do after requesting
    }
}
客户端调用：
Subject sub=new ProxySubject();
Sub.request();
(3)
动态代理类
Java动态代理类位于Java.lang.reflect包下，一般主要涉及到以下两个类：
1)
Interface InvocationHandler：该接口中仅定义了一个方法：invoke(Object obj,Method method, Object[] args)
。在实际使用时，第一个参数obj一般是指代理类，method是被代理的方法，args为该方法的参数数组。这个抽象方法
在代理类中动态实现。
2)
Proxy：该类即为动态代理类，其中主要包含以下内容：
Static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)：返回代理类
的一个实例，返回后的代理类可以当作被代理类使用。
所谓Dynamic Proxy是这样一种class：它是在运行时生成的class，在生成它时你必须提供一组interface给它，然后
该class就宣称它实现了这些 interface。
3)
在使用动态代理类时，我们必须实现InvocationHandler接口，
public interface Subject
{
    public void request();
}
具体角色RealSubject：同上；
代理角色：
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
public class DynamicSubject implements InvocationHandler {
  private Object sub;
  public DynamicSubject(Object obj) {
    sub = obj;
  }
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before calling " + method);
    method.invoke(sub,args);
    System.out.println("after calling " + method);
    return null;
  }
}
==>
method.invoke(sub,args);
其实就是调用被代理对象的将要被执行的方法，方法参数sub是实际的被代理对象，args为执行被代理对象相应操作所
需的参数。通过动态代理类，我们可以在调用之前或之后执行一些相关操作。
客户端：
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class Client
{
    static public void main(String[] args) throws Throwable
    {
      RealSubject rs = new RealSubject();  //在这里指定被代理类
      InvocationHandler ds = new DynamicSubject(rs);  //初始化代理类
      Subject subject = (Subject) Proxy.newProxyInstance(rs.getClass().getClassLoader(),rs.getClass
().getInterfaces(),ds );
      subject.request();
}
5)
实例二：
package dynamicProxy;
public interface Work {
 public void startWork();
}
package dynamicProxy;
public class JasonWork implements Work {
 public void startWork() {
  System.out.println("jason start to work...");
 }
}
public interface Play {
 public void startPlay();
}
public class JasonPlay implements Play {
 public void startPlay() {
  System.out.println("jason start to play...");
 }
}
public class Test {
public static void main(String[] args)
{
                JasonWork work=new JasonWork();
                InvocationHandler dynamicProxy=new DynamicProxy(work);
                Work jasonproxy=(Work)Proxy.newProxyInstance(work.getClass().getClassLoader(),
work.getClass().getInterfaces(), dynamicProxy);
                jasonproxy.startWork();
  JasonPlay play=new JasonPlay();
  InvocationHandler dynamicProxy=new DynamicProxy(play);
  Play jasonproxy=(Play)Proxy.newProxyInstance(play.getClass().getClassLoader(),
play.getClass().getInterfaces(), dynamicProxy);
  jasonproxy.startPlay();
 }
}
===>动态代理类,可以与任何类型的真实类(work/play),进行结合,进行动态的代理.
 
 
 
 
 */
/**
 * @author jack 2015
 * 2015年8月2日 上午12:26:12
 */
package design.pattern.proxy;