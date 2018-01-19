package com.sxshunrj.test;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/22 16:15
 * Desc：
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.agent();
    }

    public void agent() throws Exception{
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = new ObjectName("com.shunrj.test:type=Hello");
        mbs.registerMBean(new Hello(),name);

        int rmiPort = 1099;
        Registry registry = LocateRegistry.createRegistry(rmiPort);

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://192.168.10.70:"+rmiPort+"/"+"Hello");
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        jmxConnector.start();
    }

    public void register() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.pay.trade.test.mbean:type=Hello");
        Hello mbean = new Hello();
        mBeanServer.registerMBean(mbean,name);
        System.out.println("1注册结果：" + mBeanServer.isRegistered(name));
    }

    public void invoke() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.pay.trade.test.mbean:type=Hello");
        System.out.println("ret:"+mBeanServer.invoke(name,"say" , null, null));
    }


    public void unregister() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.pay.trade.test.mbean:type=Hello");
        mBeanServer.unregisterMBean(name);
        System.out.println("2注册结果：" + mBeanServer.isRegistered(name));
    }

    public static class Hello implements HelloMBean {
        @Override
        public String say() {
            return "sxs";
        }
    }

    public interface HelloMBean {
        String say();
    }
}
