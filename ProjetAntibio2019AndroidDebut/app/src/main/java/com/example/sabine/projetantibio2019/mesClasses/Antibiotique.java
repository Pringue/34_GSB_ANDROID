package com.example.sabine.projetantibio2019.mesClasses;

public abstract class Antibiotique {
    private String libelle;
    private String libelleG;
    private String unite;

    public Antibiotique(String pLibelle, String pLibelleG, String pUnite)    {
        this.libelle = pLibelle;
        this.libelleG = pLibelleG;
        this.unite = pUnite;
    }
    public String getLibelle()    {
        return this.libelle;
    }
    public String getLibelleG()    {
        return this.libelleG;
    }
    public String getUnite()    {
        return this.unite;
    }
}
