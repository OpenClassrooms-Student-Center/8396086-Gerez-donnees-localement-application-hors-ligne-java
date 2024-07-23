package com.openclassrooms.room.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
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

  private static volatile PETiSoinDatabase INSTANCE;

  public abstract AnimalDao animalDao();

  public abstract VaccineDao vaccineDao();

  public static PETiSoinDatabase getDatabase(final Context context)
  {
    if (INSTANCE == null)
    {
      synchronized (PETiSoinDatabase.class)
      {
        if (INSTANCE == null)
        {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PETiSoinDatabase.class, "PETiSoinDatabase").build();
        }
      }
    }

    return INSTANCE;

  }

}
