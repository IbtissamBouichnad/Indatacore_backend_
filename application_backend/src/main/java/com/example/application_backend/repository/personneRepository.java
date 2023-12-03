package com.example.application_backend.repository;

import com.example.application_backend.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personneRepository extends JpaRepository<Personne, Long> {

}
