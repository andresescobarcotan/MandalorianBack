package com.charla.mandalorian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.charla.mandalorian.domain.GetImageUseCase;
import com.charla.mandalorian.domain.PostImageUseCase;
import com.charla.mandalorian.infrastructure.ImageRepositoryImpl;
import com.charla.mandalorian.usecase.GetImageUseCaseImpl;
import com.charla.mandalorian.usecase.PostImageUseCaseImpl;



@Configuration
public class ConfigurationMandalorian {

	@Bean
	public GetImageUseCase getImageUseCase(ImageRepositoryImpl imageRepositoryImpl) {
		return new GetImageUseCaseImpl(imageRepositoryImpl);
	}

	
	@Bean
	public PostImageUseCase postImageUseCase(ImageRepositoryImpl imageRepositoryImpl) {
		return new PostImageUseCaseImpl(imageRepositoryImpl);
	}


}
