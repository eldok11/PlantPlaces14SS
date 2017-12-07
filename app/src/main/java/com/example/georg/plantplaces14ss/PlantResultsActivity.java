package com.example.georg.plantplaces14ss;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Georg on 06.12.2017.
 */

public class PlantResultsActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bekomme daten von adavancedserachactivity, welches bei edittext eingegeben wurde.
        String searchTerm = getIntent().getStringExtra("SEARCH_PLANT_NAME");


        ArrayList<Plant> allPlants = new ArrayList<Plant>();

        //wenn redbud gleich searchTerm variable, dann hinzufügen
        if (searchTerm.equalsIgnoreCase("Redbud")){

            Plant redbud = new Plant();
            redbud.setCommon("Redbud");
            redbud.setGenus("Cercis");
            redbud.setSpecies("candensis");

            allPlants.add(redbud);
    }
        //wenn irgendwas pawpaw, pawpaw also enthalten ist, der liste hinzufügen
        if(searchTerm.contains("pawpaw")) {
            Plant pawpaw = new Plant();
            pawpaw.setCommon("pawpaw");
            pawpaw.setGenus("asimin");
            pawpaw.setSpecies("triloba");

            allPlants.add(pawpaw);
        }

        if(allPlants.size()==0){
            Plant empty=new Plant();
            empty.setCommon("no plants match your result, please try again");
            empty.setGenus("");
            empty.setSpecies("");
            allPlants.add(empty);
        }
        //nimmt die arraylist auf und zeigt es im display für den user an, erbt von listactivity
        ArrayAdapter<Plant> plantAdapter = new ArrayAdapter<Plant>(this,android.R.layout.simple_list_item_1, allPlants);
        setListAdapter(plantAdapter);
        //objekt wird so angezeigt, wie wir in der tostring methode angegeben haben, die hier aufgerufen wird
        //auch listview objekt möglich, dass dann listView.setAdapter(plantAdapter); benutzt benutzt werden kann
    }


}
