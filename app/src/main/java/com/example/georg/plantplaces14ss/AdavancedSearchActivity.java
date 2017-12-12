package com.example.georg.plantplaces14ss;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Georg on 06.12.2017.
 */

public class AdavancedSearchActivity extends AppCompatActivity {
    private static final int IMAGE_GALLERY=10;
    private AutoCompleteTextView actPlantName;
    public static final String SEARCH_PLANT_NAME= "SEARCH_PLANT_NAME";
    public static final int PLANT_RESULTS=1;
    private Bitmap selectedImage;
    public ImageView imgPlantSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advancedsearch);
        //layout mit diesem activity verbinden

        //
        actPlantName = findViewById(R.id.actPlantName);
        imgPlantSearch = (ImageView)findViewById(R.id.imgPlantSearch);
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

        //nur wenn erhaltenes resultat ok ausführen, sonst wird auch ausgeführt, wenn kein gültiges resultat(hier z.b. kein photo gemacht),was dazu führt
        //dass app abstürtz, wenn ich auf zürück zum vorherigen bildschirm klicke

        if(resultCode==RESULT_OK){
        super.onActivityResult(requestCode, resultCode, data);


        //wenn plantresultsactivity finish(),
        if(requestCode==PLANT_RESULTS){
            Plant plant=(Plant) data.getSerializableExtra(PlantResultsActivity.PLANT_RESULT);
           // Toast.makeText(this,"received: "+plant,Toast.LENGTH_LONG).show();
            getIntent().putExtra(PlantResultsActivity.PLANT_RESULT,plant);

            setResult(RESULT_OK,getIntent());

            finish();

        }else if(requestCode==IMAGE_GALLERY){
            //wir haben eine antwort von image gallery bekommen
            //finde den pfad des ausgewählten bilder
            Uri photoLocation=data.getData();
            //öffne es als stream von bytes
            try {
                //stream von daten
                InputStream openInputStream=getContentResolver().openInputStream(photoLocation);
                //take stream of data konvertiere in bitmap
                selectedImage = BitmapFactory.decodeStream(openInputStream);
                imgPlantSearch.setImageBitmap(selectedImage);

                //unser bild an imageview hinzufügen

            } catch (FileNotFoundException e) {
                e.printStackTrace();

                //alamiere user  getString(R.string.alarmMessage)?????
                Toast.makeText(this, getString(R.string.alarmMessage), Toast.LENGTH_LONG).show();

            }
        }
    }}
    //wenn selectPicturebutton geklickt
    public void onSelectAPictureClick(View v){
        //wir wollen bild von gallery
        Intent photoPickerIntent=new Intent(Intent.ACTION_PICK);
        //präzisiere, wo man bild finden kann
        //wir haben hier nur den pfad, machen ansonsten noch nichts
        //gib mir den pfad wo wir bilder halten, filesystemdirektory, also zugriff auf bilder des geräts
        String path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
    //convert to uri, weil unsere gallerie das erwartet
        Uri picturesDicrectory=Uri.parse(path);
    //setzte data und typ auf dieses intent, wir sagen ihm , wo er nachschauen muss und welcher typ
        //können hier auch auswählen was für typ von bilder "image/png" oder "image/jpeg" oder wie hier alle typen
        photoPickerIntent.setDataAndType(picturesDicrectory,"image/*");
        //start die aktivit, wir wollen resultat
        startActivityForResult(photoPickerIntent,IMAGE_GALLERY);

    }
}
