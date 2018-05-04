package id.web.owlstudio.trainingbasic2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomListViewActivity extends AppCompatActivity {

    String[] namabuah = {"Jambu Air", "Alpukat", "Apel", "Durian", "Strawberry", "Manggis", "Ceri"};
    int[] gambarbuah = {R.drawable.jambuair, R.drawable.alpukat, R.drawable.apel,
            R.drawable.durian, R.drawable.strawberry, R.drawable.manggis, R.drawable.ceri};
    int[] detailbuah = {R.string.jambuair, R.string.alpukat, R.string.apel,
            R.string.durian, R.string.strawberry, R.string.manggis, R.string.ceri};
    int[] suarabuah = {R.raw.jambuair, R.raw.alpukat, R.raw.apel,
            R.raw.durian, R.raw.strawberry, R.raw.manggis, R.raw.ceri};
    int[] linkbuah = {R.string.linkJambuair, R.string.linkAlpukat, R.string.linkApel,
            R.string.linkDurian, R.string.linkStrawberry, R.string.linkManggis, R.string.linkCeri};

    @BindView(R.id.listbuah)
    ListView listbuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        ButterKnife.bind(this);

        // call adapter menghubungkan data dengan view (listview)
        AdapterCustomList adapter = new AdapterCustomList(CustomListViewActivity.this, namabuah, gambarbuah);

        // isi view sesuai dengan adapter
        listbuah.setAdapter(adapter);

        // action click
        listbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pindahclass = new Intent(CustomListViewActivity.this, DetailBuahActivity.class);
                pindahclass.putExtra("nb", namabuah[position]);
                pindahclass.putExtra("gb", gambarbuah[position]);
                pindahclass.putExtra("db", detailbuah[position]);
                pindahclass.putExtra("sb", suarabuah[position]);
                pindahclass.putExtra("lb", linkbuah[position]);
                startActivity(pindahclass);
            }
        });
    }
}
