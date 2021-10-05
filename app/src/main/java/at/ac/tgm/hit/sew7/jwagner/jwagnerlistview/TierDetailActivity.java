package at.ac.tgm.hit.sew7.jwagner.jwagnerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Jasmin Wagner
 * @version 2021-10-05
 *
 * Klasse für die Unterseite eines Tieres
 */

public class TierDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tier_detail);

        Tier tier = new Tier(getIntent().getBundleExtra("tier"));
        ImageView tierbild = this.findViewById(R.id.ivDetailTierbild);
        ImageView tierzuhausebild = this.findViewById(R.id.ivDetailTierzuhause);
        TextView tiername = this.findViewById(R.id.tvDetailTiername);
        TextView tierfamilie = this.findViewById(R.id.tvDetailTierfamilie);
        TextView tierkategorie = this.findViewById(R.id.tvDetailTierkategorie);
        TextView tierzuhause = this.findViewById(R.id.tvDetailTierzuhause);
        tierbild.setImageResource(this.getResources().getIdentifier(tier.getTierbild(),"mipmap",this.getPackageName()));
        tierzuhausebild.setImageResource(this.getResources().getIdentifier(tier.getTierzuhausebild(),"mipmap",this.getPackageName()));
        tiername.setText(tier.getTiername());
        if(tier.getTiername().equals("Weißer Hai") || tier.getTiername().equals("Seepferdchen")) {
            findViewById(R.id.clDetail).setBackgroundColor(Color.parseColor("#BFEFFF"));
        } else if(tier.getTiername().equals("Afrikanischer Elefant") || tier.getTiername().equals("Massai-Giraffe")) {
            findViewById(R.id.clDetail).setBackgroundColor(Color.parseColor("#EEDD82"));
        } else if(tier.getTiername().equals("Braunbär") || tier.getTiername().equals("Rotfuchs")) {
            findViewById(R.id.clDetail).setBackgroundColor(Color.parseColor("#7CCD7C"));
        }
        tierkategorie.setText(this.getString(R.string.kategorie,tier.getTierkategorie()));
        tierfamilie.setText(this.getString(R.string.familie,tier.getTierfamilie()));
        tierzuhause.setText(this.getString(R.string.zuhause,tier.getTierzuhause()));
    }
}