package com.maymona.local;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.*;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.net.Uri;

public class MainActivity extends Activity {
    private WebView webView;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(247,233,255));
        getWindow().setNavigationBarColor(Color.rgb(247,233,255));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        webView = new WebView(this);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1,-1));
        setContentView(webView);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setLoadsImagesAutomatically(true);
        webView.addJavascriptInterface(new SearchBridge(), "AndroidBridge");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/index.html");
    }
    private class SearchBridge {
        @JavascriptInterface public void search(String query) {
            runOnUiThread(() -> webView.loadUrl("https://www.google.com/search?q=" + Uri.encode(query)));
        }
    }
    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
    @Override protected void onDestroy() {
        if (webView != null) { webView.destroy(); webView = null; }
        super.onDestroy();
    }
}