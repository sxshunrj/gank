import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 16:03
 * Desc：
 */
public class MTest {


    public static void main(String[] args) {
        Table<String, String, List<String>> table = HashBasedTable.create();
        table.put("t1", "g1", Lists.newArrayList("http1", "http2", "http3"));
        table.put("t1", "g2", Lists.newArrayList("http4", "http5", "http6"));
        table.put("t2", "g1", Lists.newArrayList("http7", "http8", "http9"));

        System.out.println(JSON.toJSONString(table.columnKeySet()));
        System.out.println(JSON.toJSONString(table.columnMap()));
        System.out.println(JSON.toJSONString(table.cellSet()));

        System.out.println("-------------");
        List<String> callbackUrls = Lists.newArrayList();
        String topicName = "t1";
        Set<Table.Cell<String, String, List<String>>> cells = table.cellSet();
        for(Table.Cell<String, String, List<String>> cell : cells){
            if("t1".equals(cell.getRowKey())){
                callbackUrls.addAll(cell.getValue());
            }
        }

        System.out.println(topicName+"--->"+JSON.toJSONString(callbackUrls));


    }
}
