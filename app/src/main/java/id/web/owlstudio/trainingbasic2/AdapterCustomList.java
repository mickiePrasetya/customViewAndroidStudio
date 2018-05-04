package id.web.owlstudio.trainingbasic2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterCustomList extends BaseAdapter {

    // Deklarasi Variable kosong
    String[] nmbuah;
    int[] gambarbuah;
    Activity act;

    // constructor
    public AdapterCustomList(CustomListViewActivity customListViewActivity, String[] namabuah, int[] gambarbuah) {
        this.nmbuah = namabuah;
        this.gambarbuah = gambarbuah;
        this.act = customListViewActivity;
    }

    @Override
    public int getCount() {
        return nmbuah.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = act.getLayoutInflater();
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.listbuah, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        // isi data sesuai view (Textview dan ImageView )
        holder.namaBuah.setText(nmbuah[position]);
        holder.iconBuah.setImageResource(gambarbuah[position]);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.iconBuah)
        ImageView iconBuah;
        @BindView(R.id.namaBuah)
        TextView namaBuah;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
