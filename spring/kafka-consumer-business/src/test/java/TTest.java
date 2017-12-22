import org.apache.ibatis.io.Resources;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/9/7 10:05
 * Desc：
 */
public class TTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        C a = new C();
//        a.t();
        Class<?> aClass = Resources.classForName("com.test.D");
        System.out.println(aClass.getName());
    }
}
