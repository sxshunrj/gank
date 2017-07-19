package serviceloader;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/18 17:55
 * Desc：
 */
public class MyInterfaceImpl1 implements MyInterface {
    @Override
    public String sayHello(String name) {
        return "hello1 "+name;
    }
}
