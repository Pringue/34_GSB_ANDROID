package com.example.sabine.projetantibio2019.mesClasses;

public class Categorie {
    private int id;
    private String libelle;
    public Categorie(String pLibelle, int pId) {
        this.libelle = pLibelle;
        this.id = pId;
    }
    public String getLibelle()  {
        return this.libelle;
    }
    public int getId(){return this.id;}
    public boolean equals(Object o){ // pour utiliser indexOf ou contains
        String libelle =((Categorie) o).getLibelle();
        return (this.libelle.equals(libelle));
    }
}
