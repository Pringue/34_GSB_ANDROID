package com.example.sabine.projetantibio2019.mesClasses;

public class recupAntibio {
    private int id;
    private String libelle;
    private String libelleG;
    private String unite;
    private int nombreParJour;
    private float dosePrise;
    private float doseKilo;
    private int idCateg;

    public recupAntibio(int id, String libelle, String libelleG, String unite, int nombreParJour, float dosePrise, float doseKilo, int idCateg) {
        this.id = id;
        this.libelle = libelle;
        this.libelleG = libelleG;
        this.unite = unite;
        this.nombreParJour = nombreParJour;
        this.dosePrise = dosePrise;
        this.doseKilo = doseKilo;
        this.idCateg = idCateg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelleG() {
        return libelleG;
    }

    public void setLibelleG(String libelleG) {
        this.libelleG = libelleG;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getNombreParJour() {
        return nombreParJour;
    }

    public void setNombreParJour(int nombreParJour) {
        this.nombreParJour = nombreParJour;
    }

    public float getDosePrise() {
        return dosePrise;
    }

    public void setDosePrise(float dosePrise) {
        this.dosePrise = dosePrise;
    }

    public float getDoseKilo() {
        return doseKilo;
    }

    public void setDoseKilo(float doseKilo) {
        this.doseKilo = doseKilo;
    }

    public int getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }
}
