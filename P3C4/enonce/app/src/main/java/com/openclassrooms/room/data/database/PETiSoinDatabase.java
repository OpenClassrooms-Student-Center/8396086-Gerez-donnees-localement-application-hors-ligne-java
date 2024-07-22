package com.openclassrooms.room.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.openclassrooms.room.data.converter.Converters;
import com.openclassrooms.room.data.dao.AnimalDao;
import com.openclassrooms.room.data.dao.VaccineDao;
import com.openclassrooms.room.data.entity.Animal;
import com.openclassrooms.room.data.entity.Vaccine;

@Database(entities = { Animal.class, Vaccine.class }, version = 1)
@TypeConverters({ Converters.class })
public abstract class PETiSoinDatabase
    extends RoomDatabase
{

  public abstract AnimalDao animalDao();

  public abstract VaccineDao vaccineDao();

}
