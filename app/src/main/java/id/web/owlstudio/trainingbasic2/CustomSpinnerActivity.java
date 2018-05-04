package id.web.owlstudio.trainingbasic2;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomSpinnerActivity extends AppCompatActivity {

    String[] namabuah = {"Jambu Air", "Alpukat", "Apel", "Durian", "Strawberry", "Manggis", "Ceri"};
    int[] gambarbuah = {R.drawable.jambuair, R.drawable.alpukat, R.drawable.apel,
            R.drawable.durian, R.drawable.strawberry, R.drawable.manggis, R.drawable.ceri};
    int[] suarabuah = {R.raw.jambuair, R.raw.alpukat, R.raw.apel,
            R.raw.durian, R.raw.strawberry, R.raw.manggis, R.raw.ceri};

    @BindView(R.id.spinnercustom)
    Spinner spinnercustom;
    @BindView(R.id.txttext)
    TextView txttext;
    @BindView(R.id.imgbuah)
    ImageView imgbuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_spinner);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(CustomSpinnerActivity.this, android.R.layout.simple_spinner_item, namabuah);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnercustom.setAdapter(adapter);

        // Spinner on click select item
        spinnercustom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txttext.setText(namabuah[position]);
                imgbuah.setImageResource(gambarbuah[position]);

                MediaPlayer player = new MediaPlayer();
                // int filesuara = getIntent().getIntExtra("sb", 0);
                Uri lokasi = Uri.parse("android.resource://" + getPackageName() + "/" + suarabuah[position]);

                // menjalankan audio
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try{
                    player.setDataSource(CustomSpinnerActivity.this, lokasi);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
