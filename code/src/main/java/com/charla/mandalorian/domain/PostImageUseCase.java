package com.charla.mandalorian.domain;

import org.springframework.web.multipart.MultipartFile;

public interface PostImageUseCase {

	void postImage(String idCamera, MultipartFile file);
}
