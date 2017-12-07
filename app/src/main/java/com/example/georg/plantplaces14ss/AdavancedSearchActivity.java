package com.example.georg.plantplaces14ss;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/**
 * Created by Georg on 06.12.2017.
 */

public class AdavancedSearchActivity extends AppCompatActivity {

    private AutoCompleteTextView actPlantName;
    public static final String SEARCH_PLANT_NAME= "SEARCH_PLANT_NAME";
    public static final int PLANT_RESULTS=1;

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
        plantResultsIntent.putExtra(SEARCH_PLANT_NAME,searchPlantName);

        //anstatt staractivity, staractivityforresult erwartet einen rückgabewert
        startActivityForResult(plantResultsIntent,PLANT_RESULTS);

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //wenn plantresultsactivity finish(),
        if(requestCode==PLANT_RESULTS){
            Plant plant=(Plant) data.getSerializableExtra(PlantResultsActivity.PLANT_RESULT);
           // Toast.makeText(this,"received: "+plant,Toast.LENGTH_LONG).show();
            getIntent().putExtra(PlantResultsActivity.PLANT_RESULT,plant);

            setResult(RESULT_OK,getIntent());

            finish();

        }
    }
}
