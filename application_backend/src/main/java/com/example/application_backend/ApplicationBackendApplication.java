package com.example.application_backend;
import com.example.application_backend.repository.personneRepository;

import com.example.application_backend.entity.Personne;
import com.example.application_backend.service.CsvReaderServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApplicationBackendApplication implements CommandLineRunner {

	private final CsvReaderServicee csvReaderServicee;
	private final personneRepository personneRepository;

	@Autowired
	public ApplicationBackendApplication(CsvReaderServicee csvReaderServicee, personneRepository personneRepository) {
		this.csvReaderServicee = csvReaderServicee;
		this.personneRepository = personneRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Personne> personnes = csvReaderServicee.readCSV();
		for (Personne personne : personnes) {
			personneRepository.save(personne);
		}
	}
}
