package com.openclassrooms.room.data.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.openclassrooms.room.data.entity.Animal;

@Dao
public interface AnimalDao
{

  @Query("SELECT * FROM animal WHERE id = :id")
  Animal getAnimalById(long id);

  @Query("SELECT * FROM animal")
  LiveData<List<Animal>> getAllAnimals();

  @Upsert
  void addAnimal(Animal animal);

  @Delete
  void deleteAnimal(Animal animal);

}
