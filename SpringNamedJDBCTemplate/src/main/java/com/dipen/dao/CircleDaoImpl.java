package com.dipen.dao;

import com.dipen.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by dipen on 6/9/2017.
 */
@Component
public class CircleDaoImpl {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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


    public Integer getCount()
    {
        String sql = "Select count(*) from circle";
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public String getName(int id)
    {
        String sql = "Select name from circle where id=?";
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate.queryForObject(sql,new Object[]{id},String.class);
    }

    public Circle getCircleById(int id)
    {
        String sql = "Select * from circle where id=?";
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new CircleMapper());
    }

    public List<Circle> getAllCircle()
    {
        String sql = "Select * from circle";
        return jdbcTemplate.query(sql,new CircleMapper());
    }


  /*  public void createCircle(Circle circle)
    {
        String sql = "Insert into circle (id,'name') values(?,?)";
        jdbcTemplate.update(sql,new Object[]{circle.getId(),circle.getName()});

    }*/

    public void createCircle(Circle circle)
    {
        String sql = "Insert into circle (id,'name') values(:id,:name)";
        SqlParameterSource sps =  new MapSqlParameterSource("id",circle.getId()).
                addValue("name",circle.getName());
        jdbcTemplate.update(sql,sps);

    }

    public void  createTable(){
        String sql = "CREATE TABLE TRIANGLES (id INTEGER ,name VARCHAR (50))";
        jdbcTemplate.execute(sql);
    }
    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        //this.dataSource = dataSource;
        setJDBCTemplate(dataSource);

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static class CircleMapper implements RowMapper<Circle>
    {

        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("id"));
            circle.setName(resultSet.getString("name"));
            return null;
        }
    }

    private void setJDBCTemplate(DataSource dataSource)
    {
        this.jdbcTemplate =new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

}
