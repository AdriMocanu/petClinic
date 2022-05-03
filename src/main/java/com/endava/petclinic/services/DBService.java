package com.endava.petclinic.services;

import com.endava.petclinic.model.Owner;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBService {

    public Owner getOwnerById(Long id) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://bhdtest.endava.com:3306/petclinic", "root", "root")) {

            Map<String, String> mapColumnsToProperties = new HashMap<String, String>();

            mapColumnsToProperties.put("first_name", "firstName");
            mapColumnsToProperties.put("last_name", "lasttName");
            BeanProcessor beanProcessor = new BeanProcessor(mapColumnsToProperties);
            RowProcessor rowProcessor = new BasicRowProcessor(beanProcessor);
            ResultSetHandler<Owner> h = new BeanHandler<Owner>(Owner.class);

            QueryRunner runner = new QueryRunner();
            Owner owner = runner.query(conn, "SELECT * from owners where id = " + id, h);
            conn.close();
            return owner;
        } catch (SQLException e) {
            throw new RuntimeException("Can't connect to DB", e);
        }

    }
}
