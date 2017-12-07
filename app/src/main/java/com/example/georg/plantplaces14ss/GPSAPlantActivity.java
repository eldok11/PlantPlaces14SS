package com.example.georg.plantplaces14ss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GPSAPlantActivity extends AppCompatActivity {
    EditText description;
    TextView txtSelectedPlant;
    private Plant plant;

        //text hinzugefögt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_plants);

       description= findViewById(R.id.editText);
       txtSelectedPlant =findViewById(R.id.txtSelectedPlant);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_plants,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void searchClick(View v){

        //neue aktivität oder fensterlayout öffnen
        Intent searchIntent =new Intent(this,AdavancedSearchActivity.class);
        // aktivität starten nicht verwessen im manifest
        startActivityForResult(searchIntent,AdavancedSearchActivity.PLANT_RESULTS);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
   if(requestCode==AdavancedSearchActivity.PLANT_RESULTS){
       plant=(Plant)data.getSerializableExtra(PlantResultsActivity.PLANT_RESULT);

       txtSelectedPlant.setText(plant.toString());
   }
    }

}
