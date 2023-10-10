package com.example.demo.controi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Lokesh;
import com.example.demo.repo.LokeshRepo;

@RestController
public class LokeshContr {
	@Autowired
	private LokeshRepo lr;
	@PostMapping("/lokesh")
	public ResponseEntity<Lokesh>savedata(@RequestBody Lokesh loki){
		return new ResponseEntity<Lokesh>(lr.save(loki),HttpStatus.CREATED);
	}
	@GetMapping("/lokesh")
	public ResponseEntity<List<Lokesh>>getall(){
		return new ResponseEntity<>(lr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/lokesh/{id}")
	public ResponseEntity<Lokesh>getdata(@PathVariable int id,@RequestBody Lokesh loki){
		Optional<Lokesh>op=lr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("/lokesh/{id}")
	public ResponseEntity<Lokesh>updatedata(@PathVariable int id,@RequestBody Lokesh loki){
		Optional<Lokesh>op=lr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(lr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
	}

	
	}
	@DeleteMapping("/lokesh/{id}")
	public ResponseEntity<Lokesh>deletedata(@PathVariable int id,@RequestBody Lokesh loki){
		Optional<Lokesh>op=lr.findById(id);
		if(op.isPresent()) {
			lr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
