package com.example.api.repository;

import com.example.api.dao.DaoFactory;
import com.example.api.dao.VilleDao;
import com.example.api.model.Ville;

import java.util.List;

public class VilleForms {
    private final VilleDao villeDao;

    public VilleForms(){
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.villeDao = daoFactory.getVilleDao();
    }

    public List<String> getVille(){
        return this.villeDao.getVille();
    }
    public List<Ville> listVilles(){
        return this.villeDao.listVilles();
    }
    public List<Ville> findVilleByCodePostal(String codePostal){
        return this.villeDao.listVillesByCodePostal(codePostal);
    }
    public Ville findVilleByCodeCommune(String codeCommuneInsee){
        return this.villeDao.findVilleByCodeCommune(codeCommuneInsee);
    }

    public void saveVille(Ville ville){
        this.villeDao.addVille(ville);
    }

    public void editVille(Ville ville){
        this.villeDao.alterVille(ville);
    }

}
