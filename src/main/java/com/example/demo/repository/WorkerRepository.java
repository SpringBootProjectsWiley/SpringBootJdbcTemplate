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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class WorkerRepository implements WorkerDAO{
		
		@Autowired
		JdbcTemplate jdbcTemplate;
		private static final Logger log = LoggerFactory.getLogger(WorkerRepository.class);


		public boolean add(Worker worker){

			int worker_id = worker.getworkerId();
	        String first_name = worker.getfirstName();
	        String last_name = worker.getlastName();
	        int salary = worker.getSalary();
	        Date date = new Date();
	        String department = worker.getDepartment();
	        String email = worker.getEmail();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String joining_date = sdf.format(date);
	        String query = String.format("INSERT INTO worker VALUES(%d,'%s','%s',%d,'%s','%s','%s');", worker_id,
	                first_name,
	                last_name, salary, joining_date, department, email);

	        try {
	        	jdbcTemplate.execute(query);
	        	return true;
	        }catch(Exception e) {
	        	return false;
	        }
			
			

	    }

	    public boolean delete(int id)  {
	    	 String query = "DELETE FROM worker WHERE worker_id=12";
	    	 
	    	 try {
	    		 jdbcTemplate.update(query);
	    		 return true;
	    	 }catch(Exception e) {
	    		 return false;
	    	 }
	         
			
	    }

	    public List<Worker> getWorker(int id) throws SQLException {
	    	String query = String.format("SELECT * FROM worker WHERE worker_id=%d",id);
        
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

	    public boolean update(int id) {

	        String email = "mfs.akash@gmail.com";
	        String query = String.format("""
	                UPDATE worker SET
	                email = '%s'
	                WHERE worker_id = %d """, email, id);
	        
	        try {
	        	jdbcTemplate.update(query);
	        	return true;
	        }catch(Exception e) {
	        	return false;
	        }
	        
	        
	    }
}

