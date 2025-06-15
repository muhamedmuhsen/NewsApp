# News App

A modern Android news application built with Kotlin and Jetpack Compose.

## Features

- Modern UI built with Jetpack Compose
- Material 3 design system
- News article browsing and reading
- Image loading and caching with Coil
- Offline support with Room database
- Dependency injection with Hilt
- Navigation using Jetpack Navigation Compose
- Paging support for efficient list loading
- Network calls with Retrofit
- Data persistence with DataStore Preferences

## Technical Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture Components**:
  - ViewModel
  - LiveData
  - Room Database
  - DataStore Preferences
- **Dependency Injection**: Hilt
- **Networking**: Retrofit
- **Image Loading**: Coil
- **Paging**: Jetpack Paging
- **Navigation**: Jetpack Navigation Compose
- **Build System**: Gradle (Kotlin DSL)

## Requirements

- Android Studio Hedgehog | 2023.1.1 or later
- JDK 11
- Android SDK 26+
- Gradle 8.0+

## Getting Started

1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the app on an emulator or physical device

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.newsapp/
│   │   │       ├── data/         # Data layer (repositories, data sources)
│   │   │       ├── di/           # Dependency injection modules
│   │   │       ├── domain/       # Domain layer (use cases, models)
│   │   │       ├── ui/           # UI layer (screens, components)
│   │   │       └── utils/        # Utility classes
│   │   └── res/                  # Resources
│   └── test/                     # Unit tests
└── build.gradle.kts             # App-level build configuration
```

## Dependencies

The project uses the following major dependencies:

- AndroidX Core KTX
- Jetpack Compose
- Material 3
- Hilt for dependency injection
- Retrofit for networking
- Room for local database
- Coil for image loading
- Jetpack Paging
- Navigation Compose
- DataStore Preferences

## License

[Add your license information here]

## Contributing

[Add contribution guidelines here] 