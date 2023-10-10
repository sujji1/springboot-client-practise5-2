package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Lokesh {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String hands;
	private int phoneno;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Rakesh>rakesh=new ArrayList<>();
	public Lokesh() {
		
	}
	public Lokesh(int id, String hands, int phoneno, List<Rakesh> rakesh) {
		super();
		this.id = id;
		this.hands = hands;
		this.phoneno = phoneno;
		this.rakesh = rakesh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHands() {
		return hands;
	}
	public void setHands(String hands) {
		this.hands = hands;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public List<Rakesh> getRakesh() {
		return rakesh;
	}
	public void setRakesh(List<Rakesh> rakesh) {
		this.rakesh = rakesh;
	}
	@Override
	public String toString() {
		return "Lokesh [id=" + id + ", hands=" + hands + ", phoneno=" + phoneno + ", rakesh=" + rakesh + "]";
	}
	
	
	
}
