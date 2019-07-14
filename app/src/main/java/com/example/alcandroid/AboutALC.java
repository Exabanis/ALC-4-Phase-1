package com.example.alcandroid;

import android.net.http.SslError;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webView = findViewById(R.id.webView);

        String url = "https://andela.com/alc/";

        webView.setWebViewClient(new Browser());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.loadUrl(url);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private class Browser extends WebViewClient {
        //to allow links inside the app to work
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            webView.loadUrl(url);
            return true;
        }

        //to allow app to continue on ssl error, handshake failed
        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError error){
            handler.proceed();
        }
    }

}
