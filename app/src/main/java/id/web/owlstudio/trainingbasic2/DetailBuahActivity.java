package id.web.owlstudio.trainingbasic2;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBuahActivity extends AppCompatActivity {

    @BindView(R.id.iconBuah)
    ImageView iconBuah;
    @BindView(R.id.descBuah)
    TextView descBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(DetailBuahActivity.this, Wiki.class);
               int datalink = getIntent().getIntExtra("lb", 0);
               i.putExtra("lb", datalink);
               startActivity(i);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getIntent().getStringExtra("nb"));

        MediaPlayer player = new MediaPlayer();
        int filesuara = getIntent().getIntExtra("sb", 0);
        Uri lokasi = Uri.parse("android.resource://" + getPackageName() + "/" + filesuara);

        // menjalankan audio
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            player.setDataSource(DetailBuahActivity.this, lokasi);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        iconBuah.setImageResource(getIntent().getIntExtra("gb", 0));
        descBuah.setText(getIntent().getIntExtra("db", 0));
    }
}
