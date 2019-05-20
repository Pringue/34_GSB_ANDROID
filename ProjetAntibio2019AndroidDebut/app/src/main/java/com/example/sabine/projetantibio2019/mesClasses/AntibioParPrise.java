package com.example.sabine.projetantibio2019.mesClasses;

public class AntibioParPrise extends Antibiotique{
    private float dosePrise;
    private int nombreParJour;
    public AntibioParPrise(String pLibelle,  String pUnite, Categorie pCategorie, int pDosePrise,int pNombre)    {
        super(pLibelle, "test", pUnite);
        this.dosePrise = pDosePrise;
        this.nombreParJour = pNombre;
    }
    public float getDosePrise()    {
        return this.dosePrise;
    }
    public int getNombre()    {
        return this.nombreParJour;
    }
}
