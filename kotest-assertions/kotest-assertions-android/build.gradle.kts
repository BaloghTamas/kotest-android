plugins {
   id("com.android.library")
   kotlin("android")
}

repositories {
   mavenCentral()
   google()
   jcenter()
}


android {
   compileSdkVersion(28)
   defaultConfig {
     minSdkVersion(16)
     targetSdkVersion(28)
   }
   buildTypes {
      getByName("release") {
         isMinifyEnabled = false
      }
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_1_8
      targetCompatibility = JavaVersion.VERSION_1_8
   }

   kotlinOptions {
      jvmTarget = JavaVersion.VERSION_1_8.toString()
   }
}

dependencies {
   implementation(kotlin("stdlib-jdk8", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
   api(Libs.Kotest.Assertions)
   implementation("androidx.core:core-ktx:1.2.0")
}

apply(from = "../../publish-mpp.gradle.kts")
