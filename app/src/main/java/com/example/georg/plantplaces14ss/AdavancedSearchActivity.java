package com.example.georg.plantplaces14ss;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;

/**
 * Created by Georg on 06.12.2017.
 */

public class AdavancedSearchActivity extends AppCompatActivity {

    private AutoCompleteTextView actPlantName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advancedsearch);
        //layout mit diesem activity verbinden

        //
        actPlantName = findViewById(R.id.actPlantName);
    }


      // nicht vergessen im manifest aktivity anzugeben
    public void searchForPlants(View view){
        Intent plantResultsIntent=new Intent(this,PlantResultsActivity.class);

        //daten abspeichern, die vom user im edittext eingegeben werude.
        String searchPlantName = actPlantName.getText().toString();

        //daten an nächste aktivity geben
        plantResultsIntent.putExtra("SEARCH_PLANT_NAME",searchPlantName);

        startActivity(plantResultsIntent);

        }


}
