plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 30
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
}

dependencies {

//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation("com.google.firebase:firebase-database:20.3.1")
//    implementation("com.google.firebase:firebase-firestore:24.11.1")
//    implementation("com.android.tools.compose:compose-preview-renderer:0.0.1-alpha01")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//
//    implementation ("com.squareup.picasso:picasso:2.71828")
//
////    hung
//
////    firebase
//    implementation("com.google.firebase:firebase-storage:20.3.0")
//    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
//    implementation("com.google.firebase:firebase-auth:22.3.1")
////    implementation("com.google.firebase:firebase-auth")
//    implementation("com.google.android.gms:play-services-auth:21.0.0")
//
////  circleindicator
//    implementation ("me.relex:circleindicator:2.1.6")
//
//    //Retrofit 2
//    implementation ("com.google.code.gson:gson:2.8.5")
//    implementation ("com.squareup.retrofit2:retrofit:2.4.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")
//
//    // Logging
//    implementation ("com.squareup.okhttp3:logging-interceptor:3.9.0")
//
//    //hoi
//    implementation("androidx.paging:paging-runtime:3.0.0")
//    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
////    implementation("com.github.bumptech.glide:glide:4.12.0")
////    implementation("com.google.android.material:material:1.4.0")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-storage")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.android.gms:play-services-auth:21.0.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("me.relex:circleindicator:2.1.6")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.9.0")
    implementation("androidx.paging:paging-runtime:3.0.0")
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")




}



