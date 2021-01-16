package com.meezu.softuser.ui.aboutUs

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.meezu.softuser.R

class AboutUsFragment : Fragment() {

//    private lateinit var aboutUsViewModel: AboutUsViewModel
    private lateinit var webView: WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        aboutUsViewModel =
//            ViewModelProvider(this).get(AboutUsViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_about_us, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        aboutUsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root

        val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        webView = view.findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true;
        webView.webViewClient
        webView.loadUrl("https://softwarica.edu.np/")

        return view

    }
}