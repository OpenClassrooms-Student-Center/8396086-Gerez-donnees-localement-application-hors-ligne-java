package com.openclassrooms.room.ui.home;

import java.util.List;
import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.room.data.entity.Animal;
import com.openclassrooms.room.data.repository.AnimalsRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public final class HomeViewModel
    extends ViewModel
{

  private final AnimalsRepository animalsRepository;

  @Inject
  public HomeViewModel(AnimalsRepository animalsRepository)
  {
    this.animalsRepository = animalsRepository;
  }

  public LiveData<List<Animal>> getAnimals()
  {
    return animalsRepository.getAllAnimals();
  }

}
