package com.example.sabine.projetantibio2019.mesClasses;

import java.util.ArrayList;
import java.util.List;

public class DataAntibio {
    static private List<Antibiotique> lesAntibiotiques;
    static private List<Categorie> lesCategories;

    static public void initialiser()    {

        DataAntibio.lesCategories = new ArrayList<Categorie>();
        Categorie uneCategorie1 = new Categorie("Aminoglycosides", 1);
        DataAntibio.lesCategories.add(uneCategorie1);

        DataAntibio.lesAntibiotiques = new ArrayList<Antibiotique>();
        AntibioParKilo unAntibioParKilo;
        unAntibioParKilo = new AntibioParKilo("Amiklin","AmiKacine", uneCategorie1,15);
        DataAntibio.lesAntibiotiques.add(unAntibioParKilo);
        unAntibioParKilo = new AntibioParKilo("Garamycine","Gentamicine", uneCategorie1,6);
        DataAntibio.lesAntibiotiques.add(unAntibioParKilo);
    }

    static public List<Categorie> getLesCategories()    {
         return DataAntibio.lesCategories;
    }

    static public boolean isInstanceAntiBioPasKilo(String antibio)
    {
        boolean ret = true;
        for (Antibiotique a : lesAntibiotiques)
        {
            if (a.getLibelle() == antibio)
            {
            }
        }
        return ret;
    }

    static public int recupDoseParKilo(String antibio)
    {
        int ret = 0;
        for (Antibiotique a : lesAntibiotiques)
        {
            if (a.getLibelle() == antibio)
            {
                if (a instanceof AntibioParKilo)
                {
                    ret = ((AntibioParKilo) a).getDoseKilo();
                }
            }
        }
        return ret;
    }

    static public float recupPrise(String antibio)
    {
        float ret = 0;
        for (Antibiotique a : lesAntibiotiques)
        {
            if (a.getLibelle() == antibio)
            {
                if (a instanceof AntibioParPrise)
                {
                    ret = ((AntibioParPrise) a).getDosePrise();
                }
            }
        }
        return ret;
    }

    static public int recupNombreParJour(String antibio)
    {
        int ret = 0;
        for (Antibiotique a : lesAntibiotiques)
        {
            if (a.getLibelle() == antibio)
            {
                if (a instanceof AntibioParPrise)
                {
                    ret = ((AntibioParPrise) a).getNombre();
                }
            }
        }
        return ret;
    }
}
