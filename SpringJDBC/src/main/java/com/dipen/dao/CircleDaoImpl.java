package com.dipen.dao;

import com.dipen.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by dipen on 6/9/2017.
 */
@Component
public class CircleDaoImpl {
    @Autowired
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Circle getCircle(int id) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Connection connection = dataSource.getConnection();
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
