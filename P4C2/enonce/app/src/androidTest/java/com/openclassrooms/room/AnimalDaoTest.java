package com.openclassrooms.room;

import java.util.ArrayList;
import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.room.data.database.PETiSoinDatabase;
import com.openclassrooms.room.data.entity.Animal;
import com.openclassrooms.room.data.entity.Animal.Race;
import com.openclassrooms.room.data.entity.Animal.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public final class AnimalDaoTest
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
  public void testShouldInsertAnimalIntoDatabaseSuccessfully()
  {
    final Animal animal = new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    );

    database.animalDao().addAnimal(animal);

    final Animal result = database.animalDao().getAnimalById(1);

    assertEquals(animal.id, result.id);
  }

  @Test
  public void testShouldUpdateAnimalIntoDatabaseSuccessfully()
  {
    final Animal animal = new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    );

    database.animalDao().addAnimal(animal);

    final Animal updatedAnimal = new Animal(
        animal.id,
        animal.type,
        Race.PERSIAN,
        animal.weight,
        animal.height,
        animal.color
    );

    database.animalDao().addAnimal(updatedAnimal);

    final Animal result = database.animalDao().getAnimalById(1);
    assertEquals(updatedAnimal.id, result.id);
  }

  @Test
  public void testShouldDeleteAnimalFromDatabaseSuccessfully()
  {
    final Animal animal = new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    );

    database.animalDao().addAnimal(animal);
    database.animalDao().deleteAnimal(animal);

    final Animal result = database.animalDao().getAnimalById(1);
    assertNull(result);
  }

  @Test
  public void testGetAllAnimalsShouldReturnEmptyList()
      throws InterruptedException
  {
    final List<Animal> animals = LiveDataTestUtil.getOrAwaitValue(database.animalDao().getAllAnimals());
    assertTrue(animals.isEmpty());
  }

  @Test
  public void testGetAllAnimalsShouldReturnNonEmptyList()
      throws InterruptedException
  {
    final List<Animal> animals = new ArrayList<>();
    animals.add(new Animal(
        1,
        Type.CAT,
        Race.PERSIAN,
        12.0,
        120,
        "black"
    ));

    animals.add(new Animal(
        2,
        Type.DOG,
        Race.GOLDEN_RETRIEVER,
        10.8,
        100,
        "black"
    ));

    for (final Animal animal : animals)
    {
      database.animalDao().addAnimal(animal);
    }

    final List<Animal> result = LiveDataTestUtil.getOrAwaitValue(database.animalDao().getAllAnimals());
    assertEquals(animals.size(), result.size());
  }

}
