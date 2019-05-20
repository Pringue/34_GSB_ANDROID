package com.example.sabine.projetantibio2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabine.projetantibio2019.mesClasses.Antibiotique;
import com.example.sabine.projetantibio2019.mesClasses.Api;
import com.example.sabine.projetantibio2019.mesClasses.Categorie;
import com.example.sabine.projetantibio2019.mesClasses.Compte;
import com.example.sabine.projetantibio2019.mesClasses.DataAntibio;
import com.example.sabine.projetantibio2019.mesClasses.recupAntibio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int nbParJourMax;
    String Antibiotique;
    ListView lstCategorie;
    ListView lstAntibiotique;
    TextView leText;
    TextView categTitre;
    TextView nbMaxParJour;
    TextView nomAntibio;
    TextView doseAntibio;
    TextView resultCalc;
    TextView txtMdp;
    TextView txtNom;
    EditText entrerKilo;
    EditText editMdp;
    EditText editNom;
    Button lancerCalc;
    Button btnConnexion;
    Button retAntibio;
    Button leButton;
    List<Categorie> lesCategories;
    static public ArrayList<Categorie> lesCategs;
    static public ArrayList<Compte> lesComptes;
    List<Antibiotique> lesAntibiotiques;
    static public ArrayList<recupAntibio> lesAntibios;
    float doseKilo;
    int nbParJour;
    static public int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstCategorie = (ListView) findViewById(R.id.lstAntibio);
        lstAntibiotique = (ListView) findViewById(R.id.lstAntibiotique);
        leText = (TextView) findViewById(R.id.titre);
        categTitre = (TextView) findViewById(R.id.categTitle);
        nbMaxParJour = (TextView) findViewById(R.id.nbMaxParJour);
        nomAntibio = (TextView) findViewById(R.id.nomAntibio);
        doseAntibio = (TextView) findViewById(R.id.doseAntibio);
        txtNom = (TextView) findViewById(R.id.txtNom);
        txtMdp = (TextView) findViewById(R.id.txtMdp);
        resultCalc = (TextView) findViewById(R.id.resultatCalcul);
        btnConnexion = (Button) findViewById(R.id.btnConnexion);
        leButton = (Button) findViewById(R.id.btnRetour);
        lancerCalc = (Button) findViewById(R.id.calculer);
        retAntibio = (Button) findViewById(R.id.retourAntibio);
        entrerKilo = (EditText) findViewById(R.id.nbKilo);
        editMdp = (EditText) findViewById(R.id.editMdp);
        editNom = (EditText) findViewById(R.id.editNom);
        DataAntibio.initialiser();
        //Main_menu();

        Main_menu();
        /*btnConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nom = editNom.getText().toString();
                String mdp = editMdp.getText().toString();
                size = 0;
                Api.getAPI().getCompte(nom, mdp).enqueue(new Callback<ArrayList<Compte>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Compte>> call, Response<ArrayList<Compte>> response)
                    {
                        lesComptes = response.body();
                        size = lesComptes.size();
                    }
                    public void onFailure(Call<ArrayList<Compte>> call, Throwable t)
                    {
                        Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                Toast.makeText(MainActivity.this, String.valueOf(size), Toast.LENGTH_LONG).show();
                if (size == 1)
                {
                    txtMdp.setVisibility(view.GONE);
                    editMdp.setVisibility(view.GONE);
                    txtNom.setVisibility(view.GONE);
                    editNom.setVisibility(view.GONE);
                    btnConnexion.setVisibility(view.GONE);
                    categTitre.setVisibility(view.VISIBLE);
                    lstCategorie.setVisibility(view.VISIBLE);
                    Main_menu();
                }
            }
        });*/
    }

    public void Main_menu()
    {
        //lesCategories = DataAntibio.getLesCategories();
        Api.getAPI().getLesCategories().enqueue(new Callback<ArrayList<Categorie>>() {
            @Override
            public void onResponse(Call<ArrayList<Categorie>> call, Response<ArrayList<Categorie>> response) {
                lesCategs = response.body();
                ArrayList<String> categ = new ArrayList<String>();
                for(Categorie c : lesCategs){
                    categ.add(c.getLibelle().toUpperCase());
                }
                //Adaptateur pour faire le lien entre la list du programme et la liste de l'interface
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, categ);
                lstCategorie.setAdapter(adapter);
            };
            @Override
                public void onFailure(Call<ArrayList<Categorie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                }
        });

        //selection d'un antibiotique
        lstCategorie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categorie = lesCategs.get(position).getLibelle();
                leText.setText("Sélectionner un antibiotique :");
                leButton.setVisibility(view.VISIBLE);
                leText.setVisibility(view.VISIBLE);
                lstAntibiotique.setVisibility(view.VISIBLE);
                nbMaxParJour.setVisibility(view.VISIBLE);
                lstCategorie.setVisibility(view.GONE);
                categTitre.setVisibility(view.GONE);
                Api.getAPI().getLesAntibiotiques(categorie).enqueue(new Callback<ArrayList<recupAntibio>>() {
                    @Override
                    public void onResponse(Call<ArrayList<recupAntibio>> call, Response<ArrayList<recupAntibio>> response) {
                        lesAntibios = response.body();
                        nbParJourMax = 0;
                        ArrayList<String> antibio = new ArrayList<String>();
                        for(recupAntibio a : lesAntibios){
                            antibio.add(a.getLibelle().toUpperCase());
                            if (nbParJourMax < a.getNombreParJour())
                            {
                                nbParJourMax = a.getNombreParJour();
                            }
                        }
                        //Adaptateur pour faire le lien entre la list du programme et la liste de l'interface
                        ArrayAdapter<String> adapter =
                                new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, antibio);
                        lstAntibiotique.setAdapter(adapter);
                        nbMaxParJour.setText("Nombre max de prise par jour : "+String.valueOf(nbParJourMax));
                    };
                    @Override
                    public void onFailure(Call<ArrayList<recupAntibio>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        //retour sur la selection de categorie
        leButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                leText.setText("Sélectionner une catégorie :");
                leButton.setVisibility(view.GONE);
                leText.setVisibility(view.GONE);
                nbMaxParJour.setVisibility(view.GONE);
                lstCategorie.setVisibility(view.VISIBLE);
                lstAntibiotique.setVisibility(view.GONE);
                categTitre.setVisibility(view.VISIBLE);
                Main_menu();
            }
        });

        //Apres avoir selectionner un antibiotique
        lstAntibiotique.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Antibiotique = lesAntibios.get(position).getLibelle();
                doseKilo = lesAntibios.get(position).getDoseKilo();
                float dosePrise = lesAntibios.get(position).getDosePrise();
                String unite = lesAntibios.get(position).getUnite();
                nbParJour = lesAntibios.get(position).getNombreParJour();
                lstAntibiotique.setVisibility(view.GONE);
                leButton.setVisibility(view.GONE);
                leText.setVisibility(view.GONE);
                nbMaxParJour.setVisibility(view.GONE);
                nomAntibio.setVisibility(view.VISIBLE);
                retAntibio.setVisibility(view.VISIBLE);
                nomAntibio.setText(Antibiotique);

                //if (DataAntibio.isInstanceAntiBioPasKilo(Antibiotique))
                if (doseKilo != 0)
                {
                    resultCalc.setVisibility(view.VISIBLE);
                    entrerKilo.setVisibility(view.VISIBLE);
                    lancerCalc.setVisibility(view.VISIBLE);
                }

                else
                {
                    doseAntibio.setVisibility(view.VISIBLE);
                    doseAntibio.setText(dosePrise+" "+unite+" par prises "+nbParJour+" fois par jour");
                }
            }
        });

        lancerCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String kiloS = entrerKilo.getText().toString();
                if (!kiloS.equals("")) {
                    int kilo = Integer.parseInt(kiloS);
                    float doseParKilo = doseKilo * kilo;
                    resultCalc.setText("Il faut " + doseParKilo + " mg de l'antibiotique "+nbParJour+" fois par jour");
                }
            }
        });

        //retour sur les antibiotiques
        retAntibio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                lstAntibiotique.setVisibility(view.VISIBLE);
                leButton.setVisibility(view.VISIBLE);
                leText.setVisibility(view.VISIBLE);
                nbMaxParJour.setVisibility(view.VISIBLE);
                nomAntibio.setVisibility(view.GONE);
                doseAntibio.setVisibility(view.GONE);
                retAntibio.setVisibility(view.GONE);
                resultCalc.setVisibility(view.GONE);
                resultCalc.setText("");
                entrerKilo.setVisibility(view.GONE);
                entrerKilo.setText("");
                lancerCalc.setVisibility(view.GONE);
            }
        });
    }
}