package com.sxshunrj.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/23 15:55
 * Desc：
 */
public class MTest {
    public static void main(String[] args) throws NamingException, SQLException {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");

        InitialContext ctx = new InitialContext(props);
//        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jndi/mybatis");//java:comp/env/是一个J2EE环境的定义
        DataSource ds = (DataSource) ctx.lookup("jndi/myjdbc");//java:comp/env/是一个J2EE环境的定义
        Connection conn = ds.getConnection();
        ResultSet resultSet = conn.createStatement().executeQuery("select * from tb_area");
        while (resultSet.next()){
            System.out.println(resultSet.getString("description"));
        }
    }
}
