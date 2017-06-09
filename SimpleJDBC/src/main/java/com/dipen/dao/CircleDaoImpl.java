package com.dipen.dao;

import com.dipen.model.Circle;

import java.sql.*;

/**
 * Created by dipen on 6/9/2017.
 */
public class CircleDaoImpl {

    public Circle getCircle(int id) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Connection connection = null;
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(driver).newInstance();
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/db;create=true");
        PreparedStatement ps = connection.prepareStatement("select * from circle where id=?");
        ps.setInt(1,id);

        Circle circle =null;
        ResultSet result = ps.executeQuery();
        if(result.next())
        {
            circle = new Circle(id, result.getString("name"));
        }

        result.close();
        ps.close();
        connection.close();

        return circle;
    }
}
