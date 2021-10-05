package at.ac.tgm.hit.sew7.jwagner.jwagnerlistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * @author Jasmin Wagner
 * @version 2021-10-05
 *
 * Adapter Klasse --> Verbindung zwischen View und den Daten
 */

public class TierAdapter extends BaseAdapter {
    private List<Tier> tierliste;
    private LayoutInflater inflator;
    private Context context;

    public TierAdapter(List<Tier> tiere, Context context) {
        this.tierliste = tiere;
        this.inflator = LayoutInflater.from(context); //um später eine View zu erstellen
        this.context = context;
    }

    @Override
    public int getCount() {
        return tierliste.size();
    }

    @Override
    public Object getItem(int position) {
        return tierliste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        //wenn eine alte View wiederverwendet werden kann (scrollen)
        if(convertView==null) { //NEIN, kann nicht wiederverwendet werden
            view = this.inflator.inflate(R.layout.list_item_layout, parent, false);
        } else { //JA, es wurde gescrollt und eine alte View kann wiederverwendet werden
            view = convertView;
        }
        //Views holen und mit Daten befüllen
        Tier tier =this.tierliste.get(position);
        ImageView tierbild = view.findViewById(R.id.ivTierbild);
        ImageView tierzuhausebild = view.findViewById(R.id.ivTierzuhause);
        TextView tiername = view.findViewById(R.id.tvTiername);
        TextView tierkategorie = view.findViewById(R.id.tvTierkategorie);
        tierbild.setImageResource(context.getResources().getIdentifier(tier.getTierbild(),"mipmap",context.getPackageName()));
        tierzuhausebild.setImageResource(context.getResources().getIdentifier(tier.getTierzuhausebild(),"mipmap",context.getPackageName()));
        tiername.setText(tier.getTiername());
        tierkategorie.setText(context.getString(R.string.kategorie,tier.getTierkategorie()));
        if(tier.getTiername().equals("Weißer Hai") || tier.getTiername().equals("Seepferdchen")) {
            view.findViewById(R.id.clListitem).setBackgroundColor(Color.parseColor("#BFEFFF"));
        } else if(tier.getTiername().equals("Afrikanischer Elefant") || tier.getTiername().equals("Massai-Giraffe")) {
            view.findViewById(R.id.clListitem).setBackgroundColor(Color.parseColor("#EEDD82"));
        } else if(tier.getTiername().equals("Braunbär") || tier.getTiername().equals("Rotfuchs")) {
            view.findViewById(R.id.clListitem).setBackgroundColor(Color.parseColor("#7CCD7C"));
        }
        return view;
    }
}
