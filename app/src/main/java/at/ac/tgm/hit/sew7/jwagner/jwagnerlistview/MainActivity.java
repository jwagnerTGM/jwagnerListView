package at.ac.tgm.hit.sew7.jwagner.jwagnerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jasmin Wagner
 * @version 2021-10-05
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiereAnzeigen();
    }

    private void tiereAnzeigen() {
        ListView listview = findViewById(R.id.listView);
        List<Tier> tierliste = new ArrayList<>();

        Tier baer = new Tier("Braunbär","baer","Säugetiere","Bären","Wald","wald");
        tierliste.add(baer);
        Tier hai = new Tier("Weißer Hai","hai","Fische","Haie","Meer","meer");
        tierliste.add(hai);
        Tier elefant = new Tier("Afrikanischer Elefant","elefant","Säugetiere","Elefanten","Savanne","savanne");
        tierliste.add(elefant);
        Tier seepferdchen = new Tier("Seepferdchen","seepferdchen","Fische","Seepferdchen","Meer","meer");
        tierliste.add(seepferdchen);
        Tier fuchs = new Tier("Rotfuchs","fuchs","Säugetiere","Füchse","Wald","wald");
        tierliste.add(fuchs);
        Tier giraffe = new Tier("Massai-Giraffe","giraffe","Säugetiere","Giraffen","Savanne","savanne");
        tierliste.add(giraffe);

        TierAdapter tieradapter = new TierAdapter(tierliste,this);
        listview.setAdapter(tieradapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Tier tier = (Tier)listview.getItemAtPosition(position);
                Intent i = new Intent(MainActivity.this,TierDetailActivity.class); //Info eine neue Activity zu starten
                i.putExtra("tier", tier.asBundle());
                startActivity(i);
            }
        });
    }
}