package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ville {
    private int codeCommuneInsee;
    private String nomCommune;
    private int codePostal;
    private String libelleAcheminement;
    private String ligne5;
    private float latitude;
    private float longitude;
    private Long id;

    public Ville(int codeCommuneInsee, String nomCommune, int codePostal, String libelleAcheminement, String ligne5, float latitude, float longitude) {
        this.codeCommuneInsee = codeCommuneInsee;
        this.nomCommune = nomCommune;
        this.codePostal = codePostal;
        this.libelleAcheminement = libelleAcheminement;
        this.ligne5 = ligne5;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Ville() {
    }

    public int getCodeCommuneInsee() {
        return this.codeCommuneInsee;
    }

    public void setCodeCommuneInsee(int codeCommuneInsee) {
        this.codeCommuneInsee = codeCommuneInsee;
    }

    public String getNomCommune() {
        return this.nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public int getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibelleAcheminement() {
        return this.libelleAcheminement;
    }

    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }

    public String getLigne5() {
        return this.ligne5;
    }

    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
