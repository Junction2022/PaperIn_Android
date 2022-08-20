package com.jammin.myapplication.core.component

import android.annotation.SuppressLint
import android.util.Xml
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import com.jammin.myapplication.core.icon.JunctionIcon
import com.jammin.myapplication.core.theme.JunctionColor

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PDFWebView(
    modifier: Modifier = Modifier,
    url: String?,
    layoutParams: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
) {
    val mUrl = "http://docs.google.com/gview?embedded=true&url=$url"

    if (url != null) {
        AndroidView(
            modifier = modifier.fillMaxWidth(),
            factory = {
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
            },
            update = {
                it.loadUrl(mUrl)
            }
        )
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = JunctionColor.Gray100),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = JunctionIcon.File),
                contentDescription = null
            )
        }
    }
}
