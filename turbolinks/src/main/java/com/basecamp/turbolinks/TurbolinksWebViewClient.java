package com.basecamp.turbolinks;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TurbolinksWebViewClient extends WebViewClient {

    private TurbolinksWebViewClientCallback callback;

    public TurbolinksWebViewClient() {
    }

    public void setCallback(TurbolinksWebViewClientCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        callback.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, final String location) {
        super.onPageFinished(view, location);
        callback.onPageFinished(view, location);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String location) {
        return callback.shouldOverrideUrlLoading(view, location);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        callback.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        callback.onReceivedHttpError(view, request, errorResponse);
    }
}
