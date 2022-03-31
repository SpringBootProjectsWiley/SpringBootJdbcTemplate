package com.example.demo.repository;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.WorkerDAO;
import com.example.demo.model.Worker;

@Repository
public class WorkerRepository implements WorkerDAO{
		
		@Autowired
		JdbcTemplate jdbcTemplate;

		public String add() throws SQLException {

			int worker_id = 12;
	        String first_name = "Kunal";
	        String last_name = "Naikade";
	        int salary = 8000;
	        Date date = new Date();
	        String department = "HR";
	        String email = "kunal@gmail.com";
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String joining_date = sdf.format(date);
	        String query = String.format("INSERT INTO worker VALUES(%d,'%s','%s',%d,'%s','%s','%s');", worker_id,
	                first_name,
	                last_name, salary, joining_date, department, email);

	        
			jdbcTemplate.execute(query);
			return "Record Added";

	    }

	    public String delete() throws SQLException {
	    	 String query = "DELETE FROM worker WHERE worker_id=12";
	         jdbcTemplate.update(query);
			return "Record Deleted";
	    }

	    public List<Worker> getWorker() throws SQLException {
	    	String query = "SELECT * FROM worker WHERE worker_id=1";
        
	        return jdbcTemplate.query(query,new RowMapper<Worker>(){  
	            @Override  
	            public Worker mapRow(ResultSet rs, int rownumber) throws SQLException {  
	            	Worker e=new Worker();  
	                e.setworkerId(rs.getInt(1));
	                e.setfirstName(rs.getString(2));
	                e.setlastName(rs.getString(3));
	                e.setSalary(rs.getInt(4));
	                e.setjoiningDate(rs.getString(5));
	                e.setDepartment(rs.getString(6));
	                e.setEmail(rs.getString(7));
	                return e;  
	            }  
	            });  
	    }

	    public List<Worker> getWorkers() throws SQLException {
	        String query = "SELECT * FROM worker";
	        return jdbcTemplate.query(query,new RowMapper<Worker>(){  
	            @Override  
	            public Worker mapRow(ResultSet rs, int rownumber) throws SQLException {  
	            	Worker e=new Worker();  
	                e.setworkerId(rs.getInt(1));
	                e.setfirstName(rs.getString(2));
	                e.setlastName(rs.getString(3));
	                e.setSalary(rs.getInt(4));
	                e.setjoiningDate(rs.getString(5));
	                e.setDepartment(rs.getString(6));
	                e.setEmail(rs.getString(7));
	                return e;  
	            }  
	            });  
	    }

	    public String update() throws SQLException {

	    	int workerId = 12;
	        String firstName = "omkar";
	        String lastName = "naikade";
	        int salary = 5000;
	        Date date = new Date();
	        String department = "HR";
	        String email = "mfs.akash@gmail.com";
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String joiningDate = sdf.format(date);
	        String query = String.format("""
	                UPDATE worker SET
	                worker_id =%d,
	                first_name = '%s',
	                last_name ='%s',
	                salary =%d,
	                joining_date = '%s',
	                department = '%s',
	                email = '%s'
	                WHERE worker_id = %d """, workerId,
	                firstName,
	                lastName, salary, joiningDate, department, email, workerId);
	        jdbcTemplate.update(query);
	        return "Record Updated!";
	    }
}

