package com.openclassrooms.room.data.repository;

import java.util.List;
import javax.inject.Inject;

import androidx.lifecycle.LiveData;

import com.openclassrooms.room.data.dao.AnimalDao;
import com.openclassrooms.room.data.entity.Animal;

final public class AnimalsRepository
{

  private final AnimalDao animalDao;

  @Inject
  public AnimalsRepository(AnimalDao animalDao)
  {
    this.animalDao = animalDao;
  }

  public LiveData<List<Animal>> getAllAnimals()
  {
    return animalDao.getAllAnimals();
  }

}
