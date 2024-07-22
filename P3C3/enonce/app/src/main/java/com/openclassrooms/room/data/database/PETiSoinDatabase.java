package com.openclassrooms.room.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.openclassrooms.room.data.dao.AnimalDao;
import com.openclassrooms.room.data.entity.Animal;

@Database(entities = { Animal.class }, version = 1)
public abstract class PETiSoinDatabase
    extends RoomDatabase
{

  public abstract AnimalDao animalDao();

}
