package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Worker;

public interface WorkerDAO {
	public boolean add(Worker worker) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public List<Worker> getWorker(int id) throws SQLException;

    public List<Worker> getWorkers() throws SQLException;

    public boolean update(int id) throws SQLException;
}

