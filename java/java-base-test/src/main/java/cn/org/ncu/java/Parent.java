package cn.org.ncu.java;

public class Parent {
    int x = 10;

    public Parent(){
        add(2);
    }

    void add(int y){
        x += y;
    }
}

class Child extends Parent{
    int x = 9;

    /*public Child(){
        add(2);
    }*/

    void add(int y) {
        x +=y;
    }

    public static void main(String[] args){
        Parent p = new Child();
        System.out.println(p.x);
    }
}
