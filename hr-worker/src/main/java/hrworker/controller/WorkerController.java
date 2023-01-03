package hrworker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrworker.entities.Worker;
import hrworker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
}
