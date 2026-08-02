# Fix: Cannot add extension with name 'kotlin'

The project is using Android Gradle Plugin (AGP) version 9.3.1. Starting from AGP 9.0, built-in support for Kotlin is included and enabled by default. This causes a conflict when the `org.jetbrains.kotlin.android` plugin is also explicitly applied, as both try to register the `kotlin` extension.

## Proposed Changes

### [app]

#### [MODIFY] [build.gradle.kts](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/build.gradle.kts)
- Remove `id("org.jetbrains.kotlin.android")` from the `plugins` block.
- Remove the `kotlinOptions` block from the `android` block, as `jvmTarget` now defaults to `targetCompatibility`.

## Verification Plan

### Automated Tests
- Run Gradle Sync to verify the error is resolved.
- Run `./gradlew assembleDebug` to ensure the project still builds correctly with built-in Kotlin support.

### Manual Verification
- None required.
