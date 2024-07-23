package com.openclassrooms.room.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animal")
final public class Animal
{

  public enum Type
  {
    CAT, DOG, RABBIT
  }

  public enum Race
  {
    PERSIAN, SIEMESE,
    GERMAN_SHEPHERD, GOLDEN_RETRIEVER,
    DWARF_RABBIT, FLEMISH_RABBIT
  }

  @PrimaryKey(autoGenerate = true)
  public final long id;

  @ColumnInfo(name = "type")
  public final Type type;

  @ColumnInfo(name = "race")
  public final Race race;

  @ColumnInfo(name = "weight")
  public final double weight;

  @ColumnInfo(name = "height")
  public final double height;

  @ColumnInfo(name = "color")
  public final String color;

  public Animal(long id, Type type, Race race, double weight, double height, String color)
  {
    this.id = id;
    this.type = type;
    this.race = race;
    this.weight = weight;
    this.height = height;
    this.color = color;
  }

}
