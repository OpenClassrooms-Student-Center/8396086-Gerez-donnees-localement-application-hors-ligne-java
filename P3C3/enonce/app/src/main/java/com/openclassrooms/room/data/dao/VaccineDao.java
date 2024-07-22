package com.openclassrooms.room.data.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.openclassrooms.room.data.entity.Vaccine;

@Dao
public interface VaccineDao
{

  @Query("SELECT * FROM vaccine WHERE animalId = :animalId")
  LiveData<List<Vaccine>> getAllVaccinesByAnimalId(long animalId);

  @Upsert
  void addVaccine(Vaccine vaccine);

  @Delete
  void deleteVaccine(Vaccine vaccine);

}
