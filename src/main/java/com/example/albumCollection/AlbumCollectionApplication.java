package com.example.albumCollection;

import com.example.albumCollection.Entity.Album;
import com.example.albumCollection.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlbumCollectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AlbumCollectionApplication.class, args);
	}

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
