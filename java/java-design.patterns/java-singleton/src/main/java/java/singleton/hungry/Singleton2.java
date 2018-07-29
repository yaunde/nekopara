package java.singleton.hungry;

/**
 * 饿汉式（静态代码块）
 *
 * 这种方式和 {@link java.singleton.hungry.Singleton}其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，
 * 就执行静态代码块中的代码，初始化类的实例。优缺点和{@link java.singleton.hungry.Singleton}是一样的。
 *
 */
public class Singleton2 {
  // private final static Singleton2 instance;
  private static Singleton2 instance;

  static {
    instance = new Singleton2();
  }

  private Singleton2() {}

  public static Singleton2 getInstance() {
    return instance;
  }
}
