MAYMONA LOCAL ANDROID PROJECT — BUILD WITHOUT ANDROID STUDIO

The HTML page and image assets are bundled inside the Android app.
The app opens locally from app/src/main/assets/index.html.
Google search results still require an internet connection.

BUILD APK WITHOUT ANDROID STUDIO (GitHub Actions):
1. Create a new GitHub repository.
2. Upload the CONTENTS of this project folder to the repository root
   (including the hidden .github folder).
3. Open the repository's Actions tab.
4. Select "Build Maymona APK" and click "Run workflow".
   A push to main/master also triggers a build automatically.
5. When the run finishes, open it and download the "Maymona-APK"
   artifact from the Artifacts section.
6. Extract the downloaded artifact ZIP; it contains app-debug.apk.
7. Transfer app-debug.apk to your Android phone and install it.

No Android Studio is needed on your computer. GitHub's cloud runner builds it.
The first build may take a few minutes.

App label: Maymona
Minimum Android: 6.0 (API 23)
