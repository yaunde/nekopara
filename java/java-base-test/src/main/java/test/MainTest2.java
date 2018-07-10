package test;

import java.rmi.registry.Registry;
import java.util.HashSet;
import java.util.Set;

public class MainTest2 {
    public static void main(String[] args) {
        //main(args);
        //Registry
        Set<String> set = new HashSet<>();
        int i = 0;
        while(true){
            set.add("s:"+i);
            i++;
        }

    }
}
