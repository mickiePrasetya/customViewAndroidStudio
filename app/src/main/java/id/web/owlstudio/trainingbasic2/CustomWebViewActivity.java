package id.web.owlstudio.trainingbasic2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomWebViewActivity extends AppCompatActivity {

    @BindView(R.id.web)
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_web_view);
        ButterKnife.bind(this);

        web.loadUrl("file:///android_asset/materialamatip.html");
    }
}
