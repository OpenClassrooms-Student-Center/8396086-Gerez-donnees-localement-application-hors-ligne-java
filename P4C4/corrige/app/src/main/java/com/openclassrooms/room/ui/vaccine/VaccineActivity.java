package com.openclassrooms.room.ui.vaccine;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.room.R;
import com.openclassrooms.room.data.entity.Animal;
import com.openclassrooms.room.ui.home.AnimalsAdapter.OnAnimalClickListener;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class VaccineActivity
    extends AppCompatActivity
    implements OnAnimalClickListener
{

  public static final String ANIMAL_ID = "animalId";

  private VaccinesViewModel viewModel;

  private final VaccineAdapter adapter = new VaccineAdapter(new ArrayList<>());

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    EdgeToEdge.enable(this);

    setContentView(R.layout.activity_main);

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    viewModel = new ViewModelProvider(this).get(VaccinesViewModel.class);

    ((RecyclerView) findViewById(R.id.main)).setAdapter(adapter);

    observeVaccines();
  }

  @Override
  public void onAnimalClick(Animal animal)
  {
    final Intent intent = new Intent(this, VaccineActivity.class);
  }

  private void observeVaccines()
  {
    viewModel.getVaccines().observe(this, adapter::update);
  }

}