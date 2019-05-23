
运行如下四段代码并解释结果

```
import java.io.*;
//implements Runnable
public class ThreadTest1 extends Thread {
public void run() {
for (int i = 0; i < 10; i++) System.out.print(" " + i);
}
public static void main(String[] args) {
new ThreadTest1().start();
new ThreadTest1().start();
}
}
```
--------------------------------
```
import java.io.*;
public class ThreadTest2 implements Runnable {
public synchronized void run() {
for (int i = 0; i < 10; i++) System.out.print(" " + i);
}
public static void main(String[] args) {
Runnable r1 = new ThreadTest2();
Runnable r2 = new ThreadTest2();
Thread t1 = new Thread(r1);
Thread t2 = new Thread(r2);
t1.start();
t2.start();
}
}
```
--------------------------------
```
import java.io.*;
public class ThreadTest3 implements Runnable {
public synchronized void run() {
for (int i = 0; i < 10; i++) System.out.print(" " + i);
}
public static void main(String[] args) {
Runnable r = new ThreadTest3();
Thread t1 = new Thread(r);
Thread t2 = new Thread(r);
t1.start();
t2.start();
}
}
```
----------------------------------
```
import java.io.*;
public class ThreadTest4 implements Runnable {
public void run() {
synchronized (this) {
for (int i = 0; i < 10; i++) System.out.print(" " + i);
}
}
public static void main(String[] args) {
Runnable r = new ThreadTest4();
Thread t1 = new Thread(r);
Thread t2 = new Thread(r);
t1.start();
t2.start();
}
}
```
