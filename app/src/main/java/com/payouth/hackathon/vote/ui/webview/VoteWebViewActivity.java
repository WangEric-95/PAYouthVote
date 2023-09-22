package com.payouth.hackathon.vote.ui.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.lifecycle.ViewModelProviders;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.databinding.ActivityWebViewBinding;

import com.goldze.mvvmhabit.R;
import com.payouth.hackathon.vote.app.AppViewModelFactory;

import me.goldze.mvvmhabit.base.BaseActivity;

public class VoteWebViewActivity extends BaseActivity<ActivityWebViewBinding, WebViewViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_web_view;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        setupWebView();
        String url = getIntent().getStringExtra("url");
        if (!url.startsWith("http")) {
            url = "https://" + url;
        }
        binding.webView.loadUrl(url);

        binding.test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setupWebView() {
            WebSettings webSettings = binding.webView.getSettings();//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
            webSettings.setJavaScriptEnabled(true);
            webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
            webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小//缩放操作
            webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
            webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
            webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件//其他细节操作
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
            webSettings.setAllowFileAccess(true); //设置可以访问文件
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
            webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
            webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
            webSettings.setDatabaseEnabled(true);   //开启 database storage API 功能

        binding.webView.setWebViewClient(new WebViewClient());
    }

    class CustomerWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
    }

    @Override
    public WebViewViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(WebViewViewModel.class);
    }


}