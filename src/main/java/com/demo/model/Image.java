package com.demo.model;


import java.util.Arrays;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String status;
	private byte[] imageDetails;
	
	public Image(){
		
	}

	// constructor,getters and setters,toString() method
	public Image(String name, String status, byte[] imageDetails) {
		this.name = name;
		this.status = status;
		this.imageDetails = imageDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getImageDetails() {
		return imageDetails;
	}

	public void setImageDetails(byte[] imageDetails) {
		this.imageDetails = imageDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", status=" + status + ", imageDetails="
				+ Arrays.toString(imageDetails) + "]";
	}

}
