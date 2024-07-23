package com.openclassrooms.room.ui.vaccine;

import java.util.List;
import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.room.data.entity.Vaccine;
import com.openclassrooms.room.data.repository.VaccinesRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public final class VaccinesViewModel
    extends ViewModel
{

  private final VaccinesRepository vaccinesRepository;

  private final SavedStateHandle savedStateHandle;

  @Inject
  public VaccinesViewModel(VaccinesRepository vaccinesRepository, SavedStateHandle savedStateHandle)
  {
    this.vaccinesRepository = vaccinesRepository;
    this.savedStateHandle = savedStateHandle;
  }

  public LiveData<List<Vaccine>> getVaccines()
  {
    final long animalId = savedStateHandle.get(VaccineActivity.ANIMAL_ID);
    return vaccinesRepository.getAllVaccines(animalId);
  }

}
