package com.openclassrooms.room.ui.home;

import java.util.ArrayList;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.room.R;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity
    extends AppCompatActivity
{

  private HomeViewModel viewModel;

  private final AnimalsAdapter adapter = new AnimalsAdapter(new ArrayList<>());

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

    viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

    ((RecyclerView) findViewById(R.id.main)).setAdapter(adapter);

    observeAnimals();
  }

  private void observeAnimals()
  {
    viewModel.getAnimals().observe(this, adapter::update);
  }

}