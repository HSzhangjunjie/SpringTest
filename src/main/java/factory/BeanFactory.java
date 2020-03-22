package com.test.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @Description: 创建Bean对象的Factory,创建dao和service
 * @author: HandSomeMaker
 * @date: 2020/3/17 18:40
 */
public class BeanFactory {
    /**
     * 定义一个Properties对象
     */
    private static Properties properties;
    //使用静态代码块为properties赋值
    static {
        //注意！只能减低耦合度，不能消除耦合度
        //实例化对象
        try {
            properties=new Properties();
            //获取properties流对象
            InputStream inputStream=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            if (inputStream!=null) {
                properties.load(inputStream);
            }else {
                throw new NullPointerException("未找到配置文件");
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    /**
     * 根据Bean名称获取Bean
     * @param beanName Bean名称
     * @return Bean对象
     */
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath=properties.getProperty(beanName);
            bean=Class.forName(beanPath).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
}