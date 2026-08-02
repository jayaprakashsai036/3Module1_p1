# Fix: Cannot add extension with name 'kotlin'

The project is using Android Gradle Plugin (AGP) version 9.3.1. Starting from AGP 9.0, built-in support for Kotlin is included and enabled by default. Manually applying the `org.jetbrains.kotlin.android` plugin causes a naming conflict in the Gradle extension container, as both AGP and the Kotlin plugin try to register the `kotlin` extension.

## User Review Required

> [!IMPORTANT]
> This change migrates the project to AGP 9.0's built-in Kotlin support. This is a significant change in how Kotlin is handled in Android projects.

## Proposed Changes

### [app] (file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/build.gradle.kts)

#### [MODIFY] [build.gradle.kts](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/build.gradle.kts)
- Remove `id("org.jetbrains.kotlin.android")` from the `plugins` block.
- Remove the `kotlinOptions` block, as `jvmTarget` now defaults to `android.compileOptions.targetCompatibility` (which is already set to 21).

## Verification Plan

### Automated Tests
- Run Gradle sync to verify the error is resolved.
- Run `./gradlew assembleDebug` to ensure Kotlin source files are still compiled correctly.

### Manual Verification
- Check that the project structure in Android Studio correctly recognizes Kotlin files.
