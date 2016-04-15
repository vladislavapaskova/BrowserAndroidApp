package com.example.vladislavapaskova.buttonbrowser10;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by vladislavapaskova on 4/15/16.
 */
public class Browser extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
