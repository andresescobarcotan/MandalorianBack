package com.charla.mandalorian.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ImageDTO implements Serializable{

	private String idCamera;
	private byte[] image;
	
	public String getIdCamera() {
		return idCamera;
	}
	public void setIdCamera(String idCamera) {
		this.idCamera = idCamera;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
