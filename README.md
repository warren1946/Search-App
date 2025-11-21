# StackOverflow Search App

This app is built with **Jetpack Compose**, **Hilt**, **Room**, and **Clean Architecture** that lets users search StackOverflow questions, view details and answers, and keep a local history of answered questions for offline reference.

---

## Features

### Core

- **Search StackOverflow** questions by keyword.
- **Detail screen** showing question body, tags, author info, and answers.
- **Modern UI** built with Jetpack Compose and Material3.
- **Navigation Drawer** for easy access to History section and exiting the app.
- **Unit Tests** added to ensure code works.

### Newly Added

- **History Feature**
    - Persists answered questions and their answers locally using Room.
    - Caps storage at **10 questions** (oldest automatically removed).
    - **History Screen** lists previously answered questions.
    - **History Detail Screen** shows question + answers from local DB (no network call).
    - Reuses existing UI components (`InformationHeader`, `TagsRow`, `AuthorSection`, `AnswerItem`) for consistency.

## Architecture

- **Domain Layer**
    - Models: `Question`, `Answer`, `Author`
    - Mappers: `EntityExtensionFunctions`
- **Data Layer**
    - Local: Room (`QuestionEntity`, `AnswerEntity`, `HistoryDao`, `AppDatabase`)
    - Remote: Retrofit (`StackOverflowApi`)
    - Repository: `StackOverflowRepository`, `HistoryRepository`
- **Presentation Layer**
    - ViewModels: `SearchViewModel`, `DetailViewModel`, `HistoryViewModel`, `HistoryDetailViewModel`
    - UI: Compose screens (`SearchScreen`, `DetailScreen`, `HistoryScreen`, `HistoryDetailScreen`)
    - Shared components: `DetailTopAppBar`, `TagsRow`, `AuthorSection`, etc.

## Side Note

- **Code** working copy is in the master/develop branch
- I created a workflow to automatically run tests on pull requests to any branch.
- 
---
