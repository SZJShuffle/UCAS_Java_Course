# UCAS Java Course
国科大春季选修课《Java语言程序设计》的课程记录。
## Lecture Notes
[Java Lecture Notes](https://github.com/JShuffle/UCAS_Java_Homwork/tree/master/Lecture%20Notes)

仅供私下学习使用。
## Homwork
### HW1
面向对象程序设计的基本知识。
### HW2
解析XML格式文件。
### HW3
多线程编程基础知识。
### Big HW
编写一款简单的聊天软件。

思路：

1.调用AWT库创建GUI组件与监听事件。

2.多线程：1个线程用于收，另一个用于发。

3.基于Udp协议进行通信。

发送消息：利用发送消息按钮的监听事件获取TextArea组件中输入的文本，并将文本打包给Udp通信中的数据包。

接收消息：解析Udp通信中数据包的通信内容，并把IP Port Message输出到TextArea组件中。
