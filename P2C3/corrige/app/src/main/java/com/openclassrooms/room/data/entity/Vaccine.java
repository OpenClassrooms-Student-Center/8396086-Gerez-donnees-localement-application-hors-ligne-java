package com.openclassrooms.room.data.entity;

import java.util.Date;

public final class Vaccine
{

  public final long id;

  public final String name;

  public final Date injectionDate;

  public final long animalId;

  public Vaccine(long id, String name, Date injectionDate, long animalId)
  {
    this.id = id;
    this.name = name;
    this.injectionDate = injectionDate;
    this.animalId = animalId;
  }

}
