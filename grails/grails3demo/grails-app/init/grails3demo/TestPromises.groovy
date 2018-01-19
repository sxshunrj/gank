package grails3demo

import static grails.async.Promises.*
/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/17 19:01
 * Desc：
 */

class TestPromises {

    def test(){
        def a = task {1 + 1}
        def b = task {1 + 2}
        def c = task {1 + 3}
        assert [4,16,64] == waitAll(a, b, c)
    }

    public static void main(String[] args) {
        def promises = new TestPromises()
        promises.test()
    }

}
