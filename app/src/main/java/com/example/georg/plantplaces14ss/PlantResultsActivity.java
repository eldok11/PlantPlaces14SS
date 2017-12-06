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

        Plant redbud=new Plant();
        redbud.setCommon("Redbud");
        redbud.setGenus("Cercis");
        redbud.setSpecies("candensis");

        Plant pawpaw=new Plant();
        pawpaw.setCommon("pawpaw");
        pawpaw.setGenus("asimin");
        pawpaw.setSpecies("triloba");

        ArrayList<Plant>allPlants=new ArrayList<Plant>();

        allPlants.add(redbud);
        allPlants.add(pawpaw);
        //nimmt die arraylist auf und zeigt es im display für den user an, erbt von listactivity
        ArrayAdapter<Plant> plantAdapter = new ArrayAdapter<Plant>(this,android.R.layout.simple_list_item_1, allPlants);
        setListAdapter(plantAdapter);
        //objekt wird so angezeigt, wie wir in der tostring methode angegeben haben, die hier aufgerufen wird
    }


}
