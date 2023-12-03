package com.example.application_backend.controler;

import com.example.application_backend.entity.Personne;
import com.example.application_backend.repository.personneRepository;
import com.example.application_backend.service.CsvReaderServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnes")
public class controler {

    private final CsvReaderServicee csvReaderService;
    private final personneRepository personneRepository;

    @Autowired
    public controler(CsvReaderServicee csvReaderService, personneRepository personneRepository) {
        this.csvReaderService = csvReaderService;
        this.personneRepository = personneRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personne>> getAllPersonnes() {
        List<Personne> personnes = csvReaderService.readCSV();
        return ResponseEntity.ok(personnes);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterPersonne(@RequestBody Personne personne) {
        personneRepository.save(personne);
        return new ResponseEntity<>("Personne ajoutée avec succès", HttpStatus.CREATED);
    }
}

