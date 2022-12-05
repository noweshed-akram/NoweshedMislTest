# Glory TV

# Requirements

<img src="https://raw.githubusercontent.com/noweshed-akram/NoweshedMislTest/master/extra/ui.png">

## Splash Screen:

Create a 5-second heart-beat animation for the logo icon circle. After the time is up and the
animation is done navigate to the list page.

## List page:

Create an old-school pagination-based list screen. Five entries per page. You need to handle the
pagination locally because the related API will send all the data in a single call. How much
information you are going to show on the list page is totally your decision. Use your creativity and
make it pretty.

## Details Page:

Show all the data. Use your creativity and make it pretty.

# Dependencies

Added the following dependencies:

```
dependencies {
    
    //navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'

    def retrofit_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    def coroutines_version = "1.6.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    def lifecycle_version = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    def dagger_version = "2.43"
    implementation "com.google.dagger:hilt-android:$dagger_version"
    kapt "com.google.dagger:hilt-compiler:$dagger_version"

    def glider_version = "4.13.1"
    implementation "com.github.bumptech.glide:glide:$glider_version"
    kapt "com.github.bumptech.glide:compiler:$glider_version"

    def paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime:$paging_version")

    //Swipe refresh
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
}
```

# Design Pattern & Code Structure

In this project I followed MVVM (Model — View — ViewModel) with Clean Architecture and Navigation
Component

# Known Issue

list Paging is yet to implement due to my time constant :( Since API will send all the data in a single call we can store data locally and paginate from local source
