package im.zhaojun.common.util;

import im.zhaojun.common.information.Sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Supplier;

/**
 * @author Jesse He
 * @version 1.0.0
 * @date 2020/6/11
 */
public class TimeUtils {

    static Logger logger = LoggerFactory.getLogger("time");

    private static ThreadLocal<Time> time=ThreadLocal.withInitial(Time::new);


    public  static void start(){
        time.get().start=System.currentTimeMillis();
    }

    public static void timing(String msg){
        time.get().end=System.currentTimeMillis();
        logger.info(msg+" 耗时:"+(time.get().end-time.get().start));
    }

    private static class Time{
        public long start;
        public long end;
    }

    private static ThreadLocal<String> stringThreadLocal=ThreadLocal.withInitial(()->null);

    public static void main(String[] args) {
//        stringThreadLocal.set("haha");
//        System.out.println(stringThreadLocal.get());
//        stringThreadLocal=null;
//        System.gc();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//       // System.out.println(stringThreadLocal.get());
//        System.out.println(Thread.currentThread());
//        String n=new String("a仔");
//        ReferenceQueue<String> referenceQueue=new ReferenceQueue<>();
//        Student student=new Student(n,referenceQueue);
//        n=null;
//        System.out.println(student.getName());
//        System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0);
//        System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0);
//        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0);
//        int[][] arrs=new int[10000][];
//            for(int i=0;i<arrs.length;i++){
//                arrs[i]=new int[16*1024*1024];
//                System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0);
//            }
//        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0);
//        System.out.println(referenceQueue.poll());


//        HashMap.Entry<String,String> entry=new  HashMap.Entry<String,String>(){}

//        System.out.println(0x61c88647+0x61c88647);

        System.out.println((Math.sqrt(5)-1)/2);
        System.out.println((int)((Math.sqrt(5)-1)*Math.pow(2,31)));
        System.out.println(Math.pow(2,32));

    }


    public static class Student extends SoftReference<String>{

        public Student(String referent, ReferenceQueue<String> queue) {
            super(referent,queue);
        }

        public String getName(){
            return super.get();
        }
    }



}
