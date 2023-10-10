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


import com.example.demo.entity.Rakesh;
import com.example.demo.repo.RakeshRepo;

@RestController
public class RakeshCont {

	@Autowired
	private RakeshRepo rr;
	@PostMapping("/rakesh")
	public ResponseEntity<Rakesh>savedata(@RequestBody Rakesh raki){
		return new ResponseEntity<Rakesh>(rr.save(raki),HttpStatus.CREATED);
	}
	@GetMapping("/rakesh")
	public ResponseEntity<List<Rakesh>>getall(){
		return new ResponseEntity<>(rr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/rakesh/{id}")
	public ResponseEntity<Rakesh>getdata(@PathVariable int id,@RequestBody  Rakesh raki){
		Optional<Rakesh>op=rr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("/rakesh/{id}")
	public ResponseEntity<Rakesh>updatedata(@PathVariable int id,@RequestBody  Rakesh raki){
		Optional<Rakesh>op=rr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(rr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
	}

	
	}
	@DeleteMapping("/rakesh/{id}")
	public ResponseEntity<Rakesh>deletedata(@PathVariable int id,@RequestBody Rakesh raki){
		Optional<Rakesh>op=rr.findById(id);
		if(op.isPresent()) {
			rr.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
