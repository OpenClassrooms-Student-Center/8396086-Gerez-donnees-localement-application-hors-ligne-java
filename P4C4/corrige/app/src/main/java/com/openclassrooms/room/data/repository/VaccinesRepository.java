package com.openclassrooms.room.data.repository;

import java.util.List;
import javax.inject.Inject;

import androidx.lifecycle.LiveData;

import com.openclassrooms.room.data.dao.VaccineDao;
import com.openclassrooms.room.data.entity.Vaccine;

final public class VaccinesRepository
{

  private final VaccineDao vaccineDao;

  @Inject
  public VaccinesRepository(VaccineDao vaccineDao)
  {
    this.vaccineDao = vaccineDao;
  }

  public LiveData<List<Vaccine>> getAllVaccines(long animalId)
  {
    return vaccineDao.getAllVaccinesByAnimalId(animalId);
  }

}
