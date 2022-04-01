package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	WorkerRepository repository;
	
	@GetMapping("/:{id}")
	public List<Worker> getWorker(@PathVariable("id") int id) throws SQLException {
		return repository.getWorker(id);
	}
	
	@GetMapping("/all")
	public List<Worker> getWorkers() throws SQLException {
		return repository.getWorkers();
	}
	
	@PostMapping("/create")
	public boolean createWorker(@RequestBody Worker worker) throws SQLException {
		return repository.add(worker);
	}
	
	@PatchMapping("/update/:{id}")
	public boolean updateWorker(@PathVariable int id,@RequestBody Worker worker) throws SQLException {
		return repository.update(id);
	}
	
	@DeleteMapping("/delete/:{id}")
	public boolean deleteWorker(@PathVariable int id) throws SQLException {
		return repository.delete(id);
	}
}

