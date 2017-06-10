package com.dipen.simplejdbctemplatedao;

import com.dipen.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dipen on 6/9/2017.
 */
@Component
public class CircleSimpleJdbcTemplateDaoImpl extends JdbcDaoSupport{

    public Integer getCount()
    {
        String sql = "Select count(*) from circle";
        return this.getJdbcTemplate().queryForObject(sql,Integer.class);
    }



}
