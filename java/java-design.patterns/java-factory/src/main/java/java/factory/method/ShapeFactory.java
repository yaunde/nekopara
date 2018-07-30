package java.factory.method;


import java.factory.Shape;

/**
 * 工厂方法模式
 *
 * 定义一个创建对象的工厂接口，让子类决定实例化哪一个类，将实际创建工作推迟到子类当中。
 *
 *  使用场景
 *
 * 1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。
 * 2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
 * 3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。
 *
 */
public interface ShapeFactory {

    public Shape getShape();

}
