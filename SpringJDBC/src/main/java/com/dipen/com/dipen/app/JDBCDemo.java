package com.dipen.com.dipen.app;

import com.dipen.dao.CircleDaoImpl;
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

            CircleDaoImpl circleDaoImpl = context.getBean("circleDaoImpl",CircleDaoImpl.class);
            Circle circle = null;
            try {
                circle = circleDaoImpl.getCircle(1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(circle.getName());
        }
    }
}
