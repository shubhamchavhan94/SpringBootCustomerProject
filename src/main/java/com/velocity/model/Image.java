package com.velocity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String type;

	@Lob
	private byte[] imageDetails;

	public Image() {

	}

	public Image(String name, String type, byte[] imageDetails) {
		super();
		this.name = name;
		this.type = type;
		this.imageDetails = imageDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageDetails() {
		return imageDetails;
	}

	public void setImageDetails(byte[] imageDetails) {
		this.imageDetails = imageDetails;
	}

}
