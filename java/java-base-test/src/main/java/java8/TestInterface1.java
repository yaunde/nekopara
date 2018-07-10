package java8;


public interface TestInterface1 {
    /*static void test(){
        System.out.println("jingtai");
    }*/

    default void test2(){
        System.out.println("moren");
    }
    /*void test();*/
}
@FunctionalInterface
interface TestInterface2 extends  TestInterface1{
    /*static void test(){
        System.out.println("jingtai2");
    }*/

    default void test2(){
        System.out.println("moren2");
    }

    void test();
}


interface TestInterface3 extends TestInterface2{

}

class TestMain {
    public static void main(String[] args) {
       // TestInterface3.test();
    }
}
