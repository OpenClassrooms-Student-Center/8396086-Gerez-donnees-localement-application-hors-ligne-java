package com.openclassrooms.room;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.openclassrooms.room.data.database.PETiSoinDatabase;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public final class VaccineDaoTest
{

  private PETiSoinDatabase database;

  @Before
  public void createDb()
  {
    database = Room
        .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), PETiSoinDatabase.class)
        .allowMainThreadQueries()
        .build();
  }

  @After
  public void closeDb()
  {
    database.close();
  }


}
