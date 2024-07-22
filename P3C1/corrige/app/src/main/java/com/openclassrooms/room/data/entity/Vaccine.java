package com.openclassrooms.room.data.entity;

import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "vaccine",
    foreignKeys = @ForeignKey(
        entity = Animal.class,
        parentColumns = "id",
        childColumns = "animalId"
    )
)
public final class Vaccine
{

  @PrimaryKey(autoGenerate = true)
  public final long id;

  @ColumnInfo(name = "name")
  public final String name;

  @ColumnInfo(name = "injectionDate")
  public final Date injectionDate;

  @ColumnInfo(name = "animalId")
  public final long animalId;

  public Vaccine(long id, String name, Date injectionDate, long animalId)
  {
    this.id = id;
    this.name = name;
    this.injectionDate = injectionDate;
    this.animalId = animalId;
  }

}
