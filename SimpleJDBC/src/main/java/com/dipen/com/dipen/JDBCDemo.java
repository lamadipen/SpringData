package com.dipen.com.dipen;

import com.dipen.dao.CircleDaoImpl;
import com.dipen.model.Circle;

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
            Circle circle = null;
            try {
                circle = new CircleDaoImpl().getCircle(1);
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
