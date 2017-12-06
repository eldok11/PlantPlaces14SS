package com.example.georg.plantplaces14ss;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Georg on 06.12.2017.
 */

public class AdavancedSearchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advancedsearch);
        //layout mit diesem activity verbinden
    }


      // nicht vergessen im manifest aktivity anzugeben
    public void searchForPlants(View view){
        Intent plantResultsIntent=new Intent(this,PlantResultsActivity.class);
        startActivity(plantResultsIntent);

        }


}
