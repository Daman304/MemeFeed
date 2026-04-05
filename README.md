# MemeFeed 🚀

A sleek, infinite-scrolling Android application that delivers a continuous feed of the best memes directly from Reddit. Built natively for Android using Java and modern MVVM architecture.

## ✨ Features
* **Infinite Scroll:** Keep scrolling, keep laughing. The feed automatically fetches and loads more memes as you approach the bottom of the list.
* **Pull-to-Refresh:** Swipe down to instantly wipe the feed and grab a fresh batch of content.
* **Deep Linking:** Tap on any meme to instantly open the original post natively in your Reddit app (or default web browser).
* **Dark Mode UI:** A clean, eye-friendly dark theme with a custom sticky navigation bar designed for premium meme viewing.

## 🛠️ Tech Stack & Architecture
This project was built to practice and implement modern Android development standards:
* **Architecture:** MVVM (Model-View-ViewModel) for a clean, scalable separation of concerns.
* **Networking:** [Retrofit2](https://square.github.io/retrofit/) for handling asynchronous REST API calls.
* **Image Loading:** [Glide](https://github.com/bumptech/glide) for smooth, memory-efficient image rendering and caching.
* **UI Components:** `RecyclerView`, `SwipeRefreshLayout`, `ConstraintLayout`, `MaterialCardView`.
* **Data Management:** `LiveData` for observing data changes and **Data Binding**.

## 📡 API Reference
Powered by the open-source [Meme API](https://github.com/D3vd/Meme_Api) which scrapes live posts from Reddit.
* Endpoint used: `https://meme-api.com/gimme/{count}`

## 🚀 How to Run Locally
1. Clone this repository to your local machine.
2. Open the project in **Android Studio**.
3. Let Gradle sync and build the project.
4. Hit the Play button to run it on your emulator or physical Android device. No API key required!
