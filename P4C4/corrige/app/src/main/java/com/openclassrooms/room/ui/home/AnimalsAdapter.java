package com.openclassrooms.room.ui.home;

import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.openclassrooms.room.data.entity.Animal;
import com.openclassrooms.room.databinding.ItemAnimalBinding;
import com.openclassrooms.room.ui.home.AnimalsAdapter.AnimalViewHolder;

public final class AnimalsAdapter
    extends Adapter<AnimalViewHolder>
{

  public interface OnAnimalClickListener
  {

    void onAnimalClick(Animal animal);

  }

  public static final class AnimalViewHolder
      extends ViewHolder
  {

    private final TextView id;

    private final TextView type;

    private final TextView race;

    public AnimalViewHolder(@NonNull ItemAnimalBinding binding)
    {
      super(binding.getRoot());

      this.id = binding.id;
      this.type = binding.type;
      this.race = binding.race;
    }

    public void bind(@NonNull Animal animal, @NonNull OnAnimalClickListener listener)
    {
      id.setText(String.valueOf(animal.id));
      type.setText(animal.type.name());
      race.setText(animal.race.name());

      itemView.setOnClickListener(v -> listener.onAnimalClick(animal));
    }

  }

  private final OnAnimalClickListener listener;

  @NonNull
  private List<Animal> animals;

  public AnimalsAdapter(@NonNull List<Animal> animals, @NonNull OnAnimalClickListener listener)
  {
    this.animals = animals;
    this.listener = listener;
  }

  @NonNull
  @Override
  public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
  {
    final ItemAnimalBinding binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    return new AnimalViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position)
  {
    holder.bind(animals.get(position), listener);
  }

  @Override
  public int getItemCount()
  {
    return animals.size();
  }

  public void update(List<Animal> animals)
  {
    this.animals = animals;
    notifyDataSetChanged();
  }

}

