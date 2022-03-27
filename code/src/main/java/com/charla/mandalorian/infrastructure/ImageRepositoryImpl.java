package com.charla.mandalorian.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.charla.mandalorian.domain.ImageRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {

	private final String TEST_FILE = "test.jpg"; 
	private final String EXTENSION = ".jpg";
	private final Map<String, String> imageRepository = new HashMap<>() {{this.put("TESTCAM", TEST_FILE);}};
	 
	@Override
	public byte[] getImage(String idCamera) {
		byte[] fileRead = new byte[0];
		ClassLoader classLoader = getClass().getClassLoader();
		System.out.println("Infrastructure module");

		if(idCamera!=null) {
			String fileName = imageRepository.get(idCamera)==null?TEST_FILE:imageRepository.get(idCamera);
			 URL resource = classLoader.getResource(fileName);
			 File file;
			 System.out.println(fileName);
			try {
				file = new File(resource.toURI());
				fileRead = Files.readAllBytes(file.toPath());
			} catch (URISyntaxException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(fileRead);
		return fileRead;
	}

	@Override
	public void createImage(String idCamera, String fileName, byte[] image) {
		ClassLoader classLoader = getClass().getClassLoader();
		
			File file;
			try {
				file = new File("src/main/resources/"+fileName);
				
				FileOutputStream fos = new FileOutputStream(file);
			  fos.write(image);
			  fos.close();
			  imageRepository.put(idCamera, fileName);
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
