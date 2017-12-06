package com.example.georg.plantplaces14ss;

import java.util.List;

/**
 * Created by Georg on 06.12.2017.
 * methoden für die plants
 */

public interface IPlantDAO {
    /**
     * plant speichern
     * @param plant das obejekt, dass wir speicher wellen
     * @throws Exception
     */

    public void save(Plant plant)throws Exception;

    /**
     *
     * @param searchPlant gibt eine liste wieder nach den kriterien
     * @return
     * @throws Exception
     */
    public List<Plant> fetch(Plant searchPlant)throws Exception;

    /**
     * nur der plant mit dieser id
     * @param id
     * @return
     */
    public Plant fetchPlantById(int id)throws Exception;

}
