package com.example.sabine.projetantibio2019.mesClasses;

public class AntibioParKilo extends Antibiotique{
    private int doseKilo;
    public AntibioParKilo(String pLibelle,  String pUnite, Categorie pCategorie, int pDoseKilo)    {
        super(pLibelle, "test", pUnite);
        this.doseKilo = pDoseKilo;
    }
    public int getDoseKilo()    {
        return this.doseKilo;
    }
}
