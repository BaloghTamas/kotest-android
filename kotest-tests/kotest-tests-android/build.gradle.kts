import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    
    lintOptions {
        tasks.lint.get().enabled = false
    }
    
    defaultConfig {
        applicationId = "io.kotlintest.androidtests"
        minSdkVersion(21)
        targetSdkVersion(28)
    
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.all(closureOf<Test> {
            useJUnitPlatform()
            testLogging.showStackTraces = true
        } as groovy.lang.Closure<Test>)
    }
    
    packagingOptions {
        exclude("META-INF/LICENSE.md")
        exclude("META-INF/LICENSE-notice.md")
    }
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.71")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0")
    
    // Android
    implementation("androidx.core:core-ktx:1.2.0-rc01")
    
    // Test
    implementation(project(":kotest-extensions:kotest-extensions-robolectric"))
    testImplementation("org.robolectric:robolectric:4.3")
    testImplementation(Libs.Kotest.JunitRunner)
    
    // AndroidTest
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    androidTestImplementation("androidx.test:core:1.2.0")
    androidTestImplementation("androidx.test:core-ktx:1.2.0")
}
