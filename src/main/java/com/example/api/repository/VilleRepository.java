package com.example.api.repository;

import com.example.api.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VilleRepository extends JpaRepository<Ville,String> {

    List<Ville> findVillesByCodePostal(String codePostal);
    List<Ville> findVillesByNomCommune(String nomCommune);
    Ville findVillesById(String id);
    List<Ville> findAll();

}