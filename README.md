# RetroFitSingleton
Shows how one can use the retrofit library in Android development 

## Dependenies 
- Add following dependencies 
```
    implementation 'com.squareup.retrofit2:retrofit:2.8.1'
    implementation 'com.squareup.retrofit2:converter-gson:2.8.1'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.6.0'
```
- Add following to the `build.gradel`

```
compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
```

## References
- https://app.quicktype.io/ for generating the Data models from Api Json response 
