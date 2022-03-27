package com.charla.mandalorian.domain;

public interface ImageRepository {

	byte[] getImage(String idCamera);
	void createImage(String idCamera, String fileName, byte[] image);
}
