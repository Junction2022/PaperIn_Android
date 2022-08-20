package com.jammin.myapplication.core.component

import android.annotation.SuppressLint
import android.util.Xml
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PDFWebView(
    url: String,
    layoutParams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.FILL_PARENT
    )
) {
    val mUrl = "http://docs.google.com/gview?embedded=true&url=$url"

    AndroidView(factory = {
        WebView(it).apply {
            this.layoutParams = layoutParams
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            with(settings) {
                setSupportZoom(true)
                javaScriptEnabled = true
                defaultTextEncodingName = Xml.Encoding.UTF_8.name
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = true
            }
            loadUrl(mUrl)
        }
    }, update = {
        it.loadUrl(mUrl)
    })
}

@Preview
@Composable
fun PreviewPDF() {
    PDFWebView(url = "http://www.e-ffyc.re.kr/xml/03711/03711.pdf")
}