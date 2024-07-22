// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false

  //Ajout des plugins gradle
  alias(libs.plugins.room) apply false
}