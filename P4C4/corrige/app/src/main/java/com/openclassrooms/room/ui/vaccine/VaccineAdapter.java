package com.openclassrooms.room.ui.vaccine;

import java.util.List;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.openclassrooms.room.data.entity.Vaccine;
import com.openclassrooms.room.databinding.ItemVaccineBinding;
import com.openclassrooms.room.ui.vaccine.VaccineAdapter.VaccineViewHolder;

public final class VaccineAdapter
    extends Adapter<VaccineViewHolder>
{

  public static final class VaccineViewHolder
      extends ViewHolder
  {

    private final TextView id;

    private final TextView name;

    public VaccineViewHolder(@NonNull ItemVaccineBinding binding)
    {
      super(binding.getRoot());

      this.id = binding.id;
      this.name = binding.name;
    }

    public void bind(Vaccine vaccine)
    {
      id.setText(String.valueOf(vaccine.id));
      name.setText(vaccine.name);
    }

  }

  @NonNull
  private List<Vaccine> vaccines;

  public VaccineAdapter(@NonNull List<Vaccine> vaccines)
  {
    this.vaccines = vaccines;
  }

  @NonNull
  @Override
  public VaccineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
  {
    final ItemVaccineBinding binding = ItemVaccineBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    return new VaccineViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull VaccineViewHolder holder, int position)
  {
    holder.bind(vaccines.get(position));
  }

  @Override
  public int getItemCount()
  {
    return vaccines.size();
  }

  public void update(List<Vaccine> vaccines)
  {
    this.vaccines = vaccines;
    notifyDataSetChanged();
  }

}

