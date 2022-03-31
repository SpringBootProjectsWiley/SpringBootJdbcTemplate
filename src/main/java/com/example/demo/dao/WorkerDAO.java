package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Worker;

public interface WorkerDAO {
	public String add() throws SQLException;

    public String delete() throws SQLException;

    public List<Worker> getWorker() throws SQLException;

    public List<Worker> getWorkers() throws SQLException;

    public String update() throws SQLException;
}

