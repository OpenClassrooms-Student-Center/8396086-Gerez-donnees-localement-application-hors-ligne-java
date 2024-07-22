package com.openclassrooms.room.data.dao;

import java.util.List;

import androidx.lifecycle.LiveData;

import com.openclassrooms.room.data.entity.Animal;

public interface AnimalDao
{

  Animal getAnimalById(long id);

  LiveData<List<Animal>> getAllAnimals();

  void addAnimal(Animal animal);

  void deleteAnimal(Animal animal);

}
