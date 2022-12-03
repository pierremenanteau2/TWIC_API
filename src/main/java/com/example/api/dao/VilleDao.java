package com.example.api.dao;

import com.example.api.model.Ville;
import java.util.List;

public interface VilleDao {
    List<String> getVille();
    void addVille(Ville ville);
    void alterVille(Ville ville);
    Ville findVilleByCodeCommune(String codeCommuneInsee);
    List<Ville> listVilles();
    List<Ville> listVillesByCodePostal(String codePostal);
}