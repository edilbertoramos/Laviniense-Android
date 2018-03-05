package com.laviniense.portal.laviniense

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    var mywebview: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mywebview = findViewById<WebView>(R.id.webview)

        mywebview!!.settings.javaScriptEnabled = true
        mywebview!!.webViewClient = WebViewClient()
        mywebview!!.addJavascriptInterface(MyJavaScriptInterface(), "HTMLOUT")
        mywebview!!.settings.useWideViewPort = false

        updateView(mywebview!!)
    }

    override fun onBackPressed() = if (mywebview!!.canGoBack()) {
        mywebview!!.goBack()
    } else super.onBackPressed()

    private fun updateView(webView: WebView) {
        mywebview!!.loadUrl("http://lavinienseportal.com.br:81/EducaMobile/Account/Login")
    }

    private inner class MyAppWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            return false
        }

        override fun onPageFinished(view: WebView, url: String) {
        }
    }

    internal inner class MyJavaScriptInterface {
        @JavascriptInterface
        fun processHTML(html: String) {
        }
    }
}
