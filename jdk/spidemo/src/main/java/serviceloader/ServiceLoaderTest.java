package serviceloader;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/18 17:42
 * Desc：
 */
public class ServiceLoaderTest {
    public static void main(String[] args) {

        ServiceLoader<MyInterface> serviceLoader = ServiceLoader.load(MyInterface.class);
//        Iterator<MyInterface> impls = serviceLoader.iterator();
//        while (impls.hasNext()) {
//            MyInterface myInterface = impls.next();
//
//            String ret = myInterface.sayHello("sxs");
//            System.out.println(ret);
//        }

        for(MyInterface myInterface : serviceLoader){
            String ret = myInterface.sayHello("qwe");
            System.out.println(ret);
        }



    }
}
