package com.maadvance.attendance;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.content.pm.PackageManager;
import android.widget.Toast;

public class MainActivity extends Activity {
    private WebView web;
    private static final int PERMISSIONS = 21;
    private PermissionRequest pendingRequest;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        web = new WebView(this);
        setContentView(web);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setAllowFileAccess(true);
        s.setGeolocationEnabled(true);
        web.setWebChromeClient(new WebChromeClient() {
            @Override public void onPermissionRequest(PermissionRequest request) {
                pendingRequest = request;
                requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSIONS);
            }
            @Override public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                boolean granted = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
                callback.invoke(origin, granted, false);
            }
        });
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("file:///android_asset/index.html");
    }

    @Override public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] results) {
        super.onRequestPermissionsResult(requestCode, permissions, results);
        if (requestCode == PERMISSIONS && pendingRequest != null) {
            if (results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED) {
                pendingRequest.grant(pendingRequest.getResources());
            } else {
                pendingRequest.deny();
                Toast.makeText(this, "Camera permission is required for photo capture", Toast.LENGTH_LONG).show();
            }
            pendingRequest = null;
        }
    }

    @Override public void onBackPressed() {
        if (web != null && web.canGoBack()) web.goBack();
        else super.onBackPressed();
    }
}
