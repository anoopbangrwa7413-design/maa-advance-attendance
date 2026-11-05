MAA ADVANCE ATTENDANCE - ANDROID STUDIO PROJECT

यह Android Studio source project है; यह compiled APK नहीं है।

APK बनाने के लिए:
1. Android Studio (latest stable) install करें।
2. इस ZIP को extract करें।
3. Android Studio में extracted MaaAdvanceAttendance folder को Open करें।
4. Gradle Sync पूरा होने दें और Android SDK Platform 35 install करें यदि पूछा जाए।
5. Build > Build Bundle(s) / APK(s) > Build APK(s) चुनें।
6. Build सफल होने पर app/build/outputs/apk/debug/app-debug.apk बनेगी।
7. APK को Android phone में भेजकर install करें। फोन में इस source/installer के लिए "Install unknown apps" अनुमति देनी पड़ सकती है।

Admin demo email: Anoopbangrwa7413@gmail.com
Geofence: 200 metres (Admin screen में hospital के सही coordinates भरें)।
Shift: 24-hour rotational options.

महत्वपूर्ण सीमाएँ:
- इस project में पहले वाली demo web app शामिल है।
- यह production-grade face recognition/liveness नहीं करता; camera से photo capture मात्र है।
- Data केवल उसी फोन के browser/WebView local storage में रहता है; central cloud sync नहीं है।
- GPS/camera behaviour Android WebView/device के अनुसार अलग हो सकता है। वास्तविक अस्पताल deployment से पहले device testing जरूरी है।
- Production उपयोग से पहले secure backend, centralized database, biometric verification, authentication, audit trail, privacy/consent, backups और security testing जोड़ें।
