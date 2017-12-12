package com.example.georg.plantplaces14ss;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GPSAPlantActivity extends AppCompatActivity {
    EditText description;
    TextView txtSelectedPlant;
    private Plant plant;
    private static final int CAMERA_RESULT=5;
    private Bitmap plantImage;
    private ImageView imgPlant;


        //text hinzugefögt
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_plants);

       description= findViewById(R.id.editText);
       txtSelectedPlant =findViewById(R.id.txtSelectedPlant);

        imgPlant = findViewById(R.id.imgPlant);
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
       //nur wenn wir ein gutes resultat bekommen haben
        if(resultCode==RESULT_OK){
   if(requestCode==AdavancedSearchActivity.PLANT_RESULTS){
       plant=(Plant)data.getSerializableExtra(PlantResultsActivity.PLANT_RESULT);



       txtSelectedPlant.setText(plant.toString());



        // we have received result from the camera
   }else if(requestCode==GPSAPlantActivity.CAMERA_RESULT){
      plantImage=(Bitmap)data.getExtras().get("data");
        imgPlant.setImageBitmap(plantImage);

   }
    }}
    /**
     * when phpto button is cklicked
     */

    public void onTakePhotoClicked(View v){
        //use implicit intent to invoke camera
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //start intent, and anticipate result
        startActivityForResult(cameraIntent,CAMERA_RESULT);




    }

}
