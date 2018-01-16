package com.sxshunrj.test;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/22 16:21
 * Desc：
 */
public class Client {
    public static void main(String[] args) throws Exception {
        int rmiPort = 1099;
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://192.168.10.70:"+rmiPort+"/"+"Hello");
        JMXConnector jmxc = JMXConnectorFactory.connect(url);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        ObjectName name = new ObjectName("com.shunrj.test:type=Hello");
        HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, name, HelloMBean.class, false);
        System.out.println(proxy.say());
    }

    public interface HelloMBean {
        String say();
    }
}
