package com.sxshunrj.springboot.common.extend;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/12/15 11:36
 * Desc：
 */
@Component
public class RegisterBean implements BeanFactoryPostProcessor {

    private DefaultListableBeanFactory beanFactory;
    private BeanInfo beanInfo;

    public RegisterBean() {
    }

    public RegisterBean(BeanInfo beanInfo){
        this.beanInfo = beanInfo;
    }

    public void postProcessBeanFactory(BeanInfo beanInfo) throws BeansException {
        this.beanInfo = beanInfo;
        this.postProcessBeanFactory(this.beanFactory);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if(null != beanFactory){
            this.beanFactory = (DefaultListableBeanFactory) beanFactory;
        }

        if(null != beanInfo && null != beanInfo.getClazz()){
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(beanInfo.getClazz());

            if(StringUtils.isNotBlank(beanInfo.getInitMethodName())){
                builder.setInitMethodName(beanInfo.getInitMethodName());
            }

            if(beanInfo.getPropertyMap().size() > 0){
                Set<Map.Entry<String, Object>> entrySet = beanInfo.getPropertyMap().entrySet();
                Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, Object> next = iterator.next();
                    builder.addPropertyValue(next.getKey(), next.getValue());
                }
            }

            this.beanFactory.registerBeanDefinition(toLowerCaseFirstOne(beanInfo.getClazz().getSimpleName()), builder.getBeanDefinition());
            this.beanFactory.initializeBean(beanInfo.getClazz(), beanInfo.getClazz().getName());
        }
    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static class BeanInfo<T> {
        private Class<T> clazz;
        private String initMethodName;
        private Map<String, Object> propertyMap = Maps.newHashMap();

        public Class<T> getClazz() {
            return clazz;
        }

        public void setClazz(Class<T> clazz) {
            this.clazz = clazz;
        }

        public String getInitMethodName() {
            return initMethodName;
        }

        public void setInitMethodName(String initMethodName) {
            this.initMethodName = initMethodName;
        }

        public Map<String, Object> getPropertyMap() {
            return propertyMap;
        }

        public void setPropertyMap(Map<String, Object> propertyMap) {
            this.propertyMap = propertyMap;
        }
    }


}
