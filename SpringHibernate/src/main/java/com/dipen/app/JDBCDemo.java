package com.dipen.app;

import com.dipen.dao.CircleDaoImpl;
import com.dipen.hibernatedao.CircleHbmDaoImpl;
import com.dipen.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.SQLException;

/**
 * Created by dipen on 6/9/2017.
 */
public class JDBCDemo {
    /**
     * Hello world!
     *
     */
    public static class App
    {
        public static void main( String[] args )
        {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

            CircleHbmDaoImpl circleDaoImpl = context.getBean("circleHbmDaoImpl",CircleHbmDaoImpl.class);

            System.out.println(circleDaoImpl.getCount());

        }
    }
}
