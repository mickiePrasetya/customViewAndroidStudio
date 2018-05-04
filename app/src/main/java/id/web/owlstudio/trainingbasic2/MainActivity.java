package id.web.owlstudio.trainingbasic2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btncustomlist)
    Button btncustomlist;
    @BindView(R.id.btnwebview)
    Button btnwebview;
    @BindView(R.id.btncustomwebview)
    Button btncustomwebview;
    @BindView(R.id.btncustomspinner)
    Button btncustomspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btncustomlist, R.id.btnwebview, R.id.btncustomwebview, R.id.btncustomspinner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btncustomlist:
                startActivity( new Intent(MainActivity.this, CustomListViewActivity.class) );
                break;
            case R.id.btnwebview:
                startActivity( new Intent(MainActivity.this, WebViewActivity.class) );
                break;
            case R.id.btncustomwebview:
                startActivity( new Intent(MainActivity.this, CustomWebViewActivity.class) );
                break;
            case R.id.btncustomspinner:
                startActivity( new Intent(MainActivity.this, CustomSpinnerActivity.class) );
                break;
        }
    }
}
