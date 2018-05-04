package id.web.owlstudio.trainingbasic2;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Wiki extends AppCompatActivity {
    WebView wiki;
    int inWiki;
    ProgressBar pg;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);
        wiki = (WebView)findViewById(R.id.wiki);
        pg = (ProgressBar)findViewById(R.id.progressBar);
        inWiki = getIntent().getIntExtra("lb",0);


        wiki.getSettings().setJavaScriptEnabled(true);
        wiki.setWebViewClient(new WebViewClient());
        wiki.getSettings().setDomStorageEnabled(true);
        wiki.getSettings().setLoadWithOverviewMode(true);
        wiki.getSettings().setUseWideViewPort(true);
        wiki.getSettings().setSupportMultipleWindows(true);
        wiki.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wiki.setHorizontalScrollBarEnabled(false);
        wiki.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wiki.getSettings().setAllowFileAccessFromFileURLs(true);
        wiki.getSettings().setAllowUniversalAccessFromFileURLs(true);
        wiki.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pg.setVisibility(View.VISIBLE);
                pg.setProgress(newProgress);
                if (newProgress == 100){
                    pg.setVisibility(View.GONE);
                }
            }
        });
        pg.setVisibility(View.VISIBLE);
        wiki.loadUrl(getResources().getString(inWiki));

    }



}
