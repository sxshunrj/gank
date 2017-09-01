import com.alibaba.fastjson.JSON;
import com.sxshunrj.test.Application;
import com.sxshunrj.test.dao.TbUserDao;
import com.sxshunrj.test.model.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/9/1 18:25
 * Desc：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MTest {

    @Autowired
    TbUserDao tbUserDao;

    @Test
    public void test(){
        TbUser tbUser = tbUserDao.selectByPrimaryKey(4l);
        System.out.println(JSON.toJSONString(tbUser));
    }

}
