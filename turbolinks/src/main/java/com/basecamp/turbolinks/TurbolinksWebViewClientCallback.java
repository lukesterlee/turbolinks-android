package com.basecamp.turbolinks;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

public interface TurbolinksWebViewClientCallback {

    void onPageStarted(WebView view, String url, Bitmap favicon);

    void onPageFinished(WebView view, final String location);

    boolean shouldOverrideUrlLoading(WebView view, String location);

    void onReceivedError(WebView view, int errorCode, String description, String failingUrl);

    void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse);
}
