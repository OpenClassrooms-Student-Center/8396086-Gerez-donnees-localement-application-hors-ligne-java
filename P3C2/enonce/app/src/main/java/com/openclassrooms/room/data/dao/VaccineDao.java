package com.openclassrooms.room.data.dao;

import java.util.List;

import androidx.lifecycle.LiveData;

import com.openclassrooms.room.data.entity.Vaccine;

public interface VaccineDao
{

  LiveData<List<Vaccine>> getAllVaccinesByAnimalId(long animalId);

  void addVaccine(Vaccine vaccine);

  void deleteVaccine(Vaccine vaccine);
  
}
