plugins {
  alias(libs.plugins.android.application)

  //application des plugin gradle
  alias(libs.plugins.room)
}

android {
  namespace = "com.openclassrooms.room"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.openclassrooms.room"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  //Configuration du plugin gradle de room
  room {
    schemaDirectory("$projectDir/schemas")
  }
}

dependencies {

  implementation(libs.appcompat)
  implementation(libs.material)
  implementation(libs.activity)
  implementation(libs.constraintlayout)
  testImplementation(libs.junit)
  androidTestImplementation(libs.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(libs.androidx.core.testing)

  //ajout des dépendances room
  implementation(libs.room.runtime)
  annotationProcessor(libs.room.compiler)
}