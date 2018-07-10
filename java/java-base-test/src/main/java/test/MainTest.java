package test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();

        File file = new File("D:\\out","a.txt");
        System.out.println(file.getPath());
        System.out.println(file.getName());

        File file1 = new File("D:/out","a.txt");
        System.out.println("file1 "+file1.getPath());
        System.out.println("file1 "+ file1.getName());

        {{ }};
        new A (){{ a(); b();}};
        out:{break out;}
        inner:{System.out.println("aaa");}

        //inner:{continue inner;}

        for (int i = 0; i<10 ; i++){
            continue;

        }
        System.out.println("------------------------------");

        //String s;
        //System.out.println("s="+s);

        String imgUrl = "http://examle.com/xxx/yyy245/pichdjejjdhe9.png";
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1,imgUrl.lastIndexOf("."));

        System.out.println(fileName);

        //String pattern = "\\d+";
        String pattern = "([a-zA-Z]*)(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(imgUrl);

        int start = 0;
        int end = 0;

        while(m.find()){
            start = m.start();
            end = m.end();
            System.out.println("---"+m.group());
            System.out.println("---"+m.group(1));
            System.out.println("---"+m.group(2));

            System.out.println("start: "+start+"  end: "+end);
            //int num = Integer.parseInt(imgUrl.substring(start, end));
            //System.out.println(num);
        }

        System.out.println("捕获个数:groupCount()="+m.groupCount());
        System.out.println("____________________________________");

        Pattern p = Pattern.compile("(\\d+,)(\\d+)");
        String s = "123,456-34,345";
        Matcher m1 = p.matcher(s);

        while(m1.find()) {

            System.out.println("m.group():"+m1.group()); //打印一个大组
            System.out.println("m.group(1):"+m1.group(1)); //打印组1
            System.out.println("m.group(2):"+m1.group(2)); //打印组2
            System.out.println();
        }
        System.out.println("捕获个数:groupCount()="+m1.groupCount());
        
        //ConcurrentHashMap
        
        int count = 0;
        count = count++;
        System.out.println("------ "+count);

    }
}

class A {
    public void a (){
        System.out.println("a method");
    }

    public void b (){
        System.out.println("b method");
    }
}
