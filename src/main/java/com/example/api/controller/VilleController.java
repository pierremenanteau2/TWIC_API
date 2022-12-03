package com.example.api.controller;


import com.example.api.dao.DaoFactory;
import com.example.api.dao.VilleDao;
import com.example.api.model.Ville;
import com.example.api.repository.VilleForms;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VilleController {

    private final DaoFactory daoFactory = DaoFactory.getInstance();

    @GetMapping(value = "/allVilles")
    public List<String> getAll() {
        System.out.println("Ma méthode zebi, qui ne marche pas");
        VilleDao villeDao = daoFactory.getVilleDao();
        return villeDao.getVille();
    }

    @GetMapping(value = "/ville")
    public String get(@RequestParam(required = false, value = "codePostal") String codePostal) {
        VilleForms finder = new VilleForms();
        List<Ville> villes = finder.listVilles();
        String villesString = "";
        for (Ville ville : villes) {
            villesString += ville.getCodeCommuneInsee() + "," + ville.getNomCommune() + "," + ville.getCodePostal() + ","+
            ville.getLibelleAcheminement()+","+ville.getLigne5()+","+ville.getLatitude()+","+ville.getLongitude()+',';
        }
        System.out.println("Controller :" + villesString);
        return villesString;
    }

    @PostMapping(value = "/save")
    public void post(@RequestParam(value = "Code_commune_INSEE") String codeCommuneInsee,
                       @RequestParam(value = "Nom_commune") String nomCommune,
                       @RequestParam(value = "Code_postal") String codePostal,
                       @RequestParam(value = "Libelle_acheminement") String libelle,
                       @RequestParam(value = "Ligne_5") String ligne5,
                       @RequestParam(value = "Latitude") String latitude,
                       @RequestParam(value = "Longitude") String longitude) {

        VilleForms finder = new VilleForms();
        Ville ville = finder.findVilleByCodeCommune(codeCommuneInsee);
        VilleForms saver = new VilleForms();
        if (ville == null) {
            saver.saveVille(
                    new Ville(Integer.parseInt(codeCommuneInsee), nomCommune, Integer.parseInt(codePostal),
                            libelle, ligne5, Float.parseFloat(latitude), Float.parseFloat(longitude)));
        }
    }

    @PutMapping(value = "/put/{codeCommuneInsee}")
    public void put(@PathVariable String codeCommuneInsee,
                      @RequestBody Ville ville) {
        VilleForms finder = new VilleForms();
        Ville currentVille = finder.findVilleByCodeCommune(codeCommuneInsee);
        VilleForms editer = new VilleForms();
        if (currentVille == null) {
            editer.saveVille(ville);
        } else {
            ville.setCodeCommuneInsee(Integer.parseInt(codeCommuneInsee));
            editer.editVille(ville);
        }
    }
}