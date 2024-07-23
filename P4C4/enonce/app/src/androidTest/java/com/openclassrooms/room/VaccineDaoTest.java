package com.openclassrooms.room;

import java.util.Date;
import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.room.data.database.PETiSoinDatabase;
import com.openclassrooms.room.data.entity.Animal;
import com.openclassrooms.room.data.entity.Animal.Race;
import com.openclassrooms.room.data.entity.Animal.Type;
import com.openclassrooms.room.data.entity.Vaccine;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public final class VaccineDaoTest
{

  @Rule
  public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

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

  @Test
  public void testShouldInsertVaccineIntoDatabaseSuccessfully()
      throws InterruptedException
  {
    //We first insert an animal
    final Animal animal = new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    );

    database.animalDao().addAnimal(animal);

    //then a vaccine
    final Vaccine vaccine = new Vaccine(
        1,
        "leucose",
        new Date(),
        1
    );

    database.vaccineDao().addVaccine(vaccine);

    final List<Vaccine> vaccines = LiveDataTestUtil.getOrAwaitValue(database.vaccineDao().getAllVaccinesByAnimalId(1));
    assertEquals(1, vaccines.size());
    assertEquals(1, vaccines.get(0).id);
  }

  @Test
  public void testShouldUpdateVaccineIntoDatabaseSuccessfully()
      throws InterruptedException
  {
    //We first insert an animal
    final Animal animal = new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    );

    database.animalDao().addAnimal(animal);

    //then a vaccine
    final Vaccine vaccine = new Vaccine(
        1,
        "leucose",
        new Date(),
        1
    );

    database.vaccineDao().addVaccine(vaccine);

    //Update the date with Monday 8 January 2024 21:26:38
    final Vaccine updatedVaccine = new Vaccine(
        vaccine.id,
        vaccine.name,
        new Date(1704749198 * 1000L),
        vaccine.animalId
    );

    database.vaccineDao().addVaccine(updatedVaccine);

    final List<Vaccine> vaccines = LiveDataTestUtil.getOrAwaitValue(database.vaccineDao().getAllVaccinesByAnimalId(1));
    assertEquals(1, vaccines.size());
    assertEquals(1, updatedVaccine.id);
    assertEquals(new Date(1704749198 * 1000L), updatedVaccine.injectionDate);
  }

  @Test
  public void testShouldDeleteVaccineFromDatabaseSuccessfully()
      throws InterruptedException
  {
    //We first insert an animal
    final Animal animal = new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    );

    database.animalDao().addAnimal(animal);

    //then a vaccine
    final Vaccine vaccine = new Vaccine(
        1,
        "leucose",
        new Date(),
        1
    );

    database.vaccineDao().addVaccine(vaccine);

    database.vaccineDao().deleteVaccine(vaccine);

    final List<Vaccine> vaccines = LiveDataTestUtil.getOrAwaitValue(database.vaccineDao().getAllVaccinesByAnimalId(1));
    assertTrue(vaccines.isEmpty());
  }

}
