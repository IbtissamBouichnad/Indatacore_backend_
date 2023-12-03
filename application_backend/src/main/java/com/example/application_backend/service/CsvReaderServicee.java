package com.example.application_backend.service;

import com.example.application_backend.entity.Personne;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderServicee {

    public List<Personne> readCSV() {
        List<Personne> personnes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ibtis\\Downloads\\app_Ibtissam_bouichnad\\fichier_backend.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";"); // Adapter selon le séparateur dans votre fichier CSV

                // Création d'une personne à partir des données du fichier CSV
                Personne personne = new Personne();
                personne.setId(Long.parseLong(data[0]));
                personne.setName(data[1]);
                personne.setJob(data[2]);
                personne.setImageUrl(data[3]);

                personnes.add(personne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personnes;
    }
}
