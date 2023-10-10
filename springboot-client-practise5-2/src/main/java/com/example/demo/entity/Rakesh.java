package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Rakesh {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rakiid;
	private String legs;
	public Rakesh() {
		
	}
	public Rakesh(int rakiid, String legs) {
		super();
		this.rakiid = rakiid;
		this.legs = legs;
	}
	public int getRakiid() {
		return rakiid;
	}
	public void setRakiid(int rakiid) {
		this.rakiid = rakiid;
	}
	public String getLegs() {
		return legs;
	}
	public void setLegs(String legs) {
		this.legs = legs;
	}
	@Override
	public String toString() {
		return "Rakesh [rakiid=" + rakiid + ", legs=" + legs + "]";
	}
	
	
	
}
