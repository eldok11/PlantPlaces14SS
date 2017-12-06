package com.example.georg.plantplaces14ss;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georg on 06.12.2017.
 */

public class PlantDAOStub implements IPlantDAO {
    @Override
    public void save(Plant plant) throws Exception {
        if(plant.getGenus()==null||plant.getSpecies()==null){

            throw new Exception("Plant data are incomplete");

        }else{


        }
    }

    @Override
    public List<Plant> fetch(Plant searchPlant) throws Exception {
        ArrayList<Plant>allPlants=new ArrayList<Plant>();
        if(searchPlant.getCommon().equals("Redbud")){
            Plant p=new Plant();
            p.setGenus("Cerci");
            p.setSpecies("canadensis");
            p.setCommon("Redbud");
            allPlants.add(p);
        }
        return allPlants;
    }

    @Override
    public Plant fetchPlantById(int id) throws Exception {
        return null;
    }
}
