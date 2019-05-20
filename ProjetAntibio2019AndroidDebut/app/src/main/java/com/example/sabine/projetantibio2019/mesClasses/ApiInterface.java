package com.example.sabine.projetantibio2019.mesClasses;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getLesCategories.php")
    Call<ArrayList<Categorie>> getLesCategories();

    @GET("getLesAntibiotiques.php")
    Call<ArrayList<recupAntibio>> getLesAntibiotiques(@Query("categorie") String categ);

    @GET("getCompte.php")
    Call<ArrayList<Compte>> getCompte(@Query("nom") String nom, @Query("mdp") String mdp);
}