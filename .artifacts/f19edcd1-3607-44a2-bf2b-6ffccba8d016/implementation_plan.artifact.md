# Implementation Plan - Fix Syntax Errors and File Corruptions

The project currently fails to build due to a syntax error in `MainActivity.kt`, which contains XML content instead of Kotlin code. Additionally, several files have incorrect extensions (`.kt.kt`) and class names containing `.kt`.

## Proposed Changes

### 1. Fix `MainActivity.kt`
Replace the XML content in `MainActivity.kt` with a standard Kotlin `AppCompatActivity` implementation that uses ViewBinding and `MainViewModel`.

#### [MODIFY] [MainActivity.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/com/example/a3modeule1_p1/MainActivity.kt)
- Replace XML with Kotlin code.
- Set package to `project.handson1`.

### 2. Rename and Fix Corrupted Files
Several files have `.kt.kt` extension and internal syntax errors (class/object names with `.kt`).

#### [RENAME] `repository/AIRepository.kt.kt` -> [AIRepository.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/repository/AIRepository.kt)
- Change `class AIRepository.kt` to `class AIRepository`.

#### [RENAME] `utils/Constants.kt.kt` -> [Constants.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/utils/Constants.kt)
- Change `object Constants.kt` to `object Constants`.

#### [RENAME] `network/ApiClient.kt.kt` -> [ApiClient.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/network/ApiClient.kt)

### 3. Update Usages and Imports
Update all files that reference the renamed classes or objects.

#### [MODIFY] [MainViewModel.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/viewmodel/MainViewModel.kt)
- Ensure correct import for `AIRepository`.

#### [MODIFY] [ApiService.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/network/ApiService.kt)
- Update import from `project.handson1.utils.Constants.kt.END_POINT` to `project.handson1.utils.Constants.END_POINT`.

#### [MODIFY] [ApiClient.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/network/ApiClient.kt)
- Import `project.handson1.utils.Constants`.
- Update references from `Constants.kt` to `Constants`.

#### [MODIFY] [AIRepository.kt](file:///C:/Users/jayap/OneDrive/Desktop/3modeule1_p1/app/src/main/java/repository/AIRepository.kt)
- Update references from `ApiClient.kt` to `ApiClient` (if any, although it seems it used `ApiClient` already).

## Verification Plan

### Automated Tests
- Run `./gradlew :app:assembleDebug` to ensure the project builds successfully.

### Manual Verification
- Deploy the app to a device/emulator (if available) and verify that the UI loads and the "Ask AI" functionality works.
