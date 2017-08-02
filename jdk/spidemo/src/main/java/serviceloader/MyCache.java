package serviceloader;

import com.sun.beans.util.Cache;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/23 14:50
 * Desc：
 */
public class MyCache extends Cache<String,String> {
    public MyCache(Kind kind, Kind kind1) {
        super(kind, kind1);
    }

    @Override
    public String create(String s) {
        return s;
    }

    public static void main(String[] args) {

    }

}
