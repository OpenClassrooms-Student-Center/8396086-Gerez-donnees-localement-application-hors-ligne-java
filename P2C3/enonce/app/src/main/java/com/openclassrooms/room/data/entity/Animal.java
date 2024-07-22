package com.openclassrooms.room.data.entity;

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

  public final long id;

  public final Type type;

  public final Race race;

  public final double weight;

  public final double height;

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
