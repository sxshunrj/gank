package com.sxshunrj.test;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/20 10:24
 * Desc：一致性哈希算法-没有虚拟节点
 */
public class ConsistentHashingWithoutVirtualNode {

    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers={"192.168.1.1:111", "192.168.1.2:111", "192.168.1.3:111"};

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    /**
     * 程序初始化，将所有的服务器放入sortedMap中
     */
    static {
        for(int i=0; i<servers.length;i++){
            Integer hash = getHash(servers[i]);
            sortedMap.put(hash, servers[i]);
            System.out.println("将hash值为["+hash+"]的server["+servers[i]+"]添加到Map中");
        }
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private static int getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }


    /**
     * 得到应当路由到的结点
     */
    private static String getServer(String obj){
        Integer hash = getHash(obj);

        SortedMap<Integer, String> integerStringSortedMap = sortedMap.tailMap(hash);
        return sortedMap.get(integerStringSortedMap.firstKey());
    }

    public static void main(String[] args) {
        String obj = "12222";
        System.out.println(getServer(obj));

        obj = "77777777";
        System.out.println(getServer(obj));

        obj = "34444444";
        System.out.println(getServer(obj));
    }
}
