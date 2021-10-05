package at.ac.tgm.hit.sew7.jwagner.jwagnerlistview;

import android.os.Bundle;

/**
 * @author Jasmin Wagner
 * @version 2021-10-05
 *
 * Klasse für ein Tier Objekt
 */

public class Tier {
    //Attribute
    private String tiername;
    private String tierbild;
    private String tierkategorie;
    private String tierfamilie;
    private String tierzuhause;
    private String tierzuhausebild;

    //Konstruktor mit einem Bundle
    public Tier(Bundle b) {
        this.tiername = b.getString("Tiername");
        this.tierbild = b.getString("Tierbild");
        this.tierzuhause = b.getString("Zuhause");
        this.tierfamilie = b.getString("Familie");
        this.tierkategorie = b.getString("Kategorie");
        this.tierzuhausebild = b.getString("Zuhausebild");
    }

    //Konstruktor mit den Attributen
    public Tier(String tiername, String tierbild, String tierkategorie, String tierfamilie, String tierzuhause, String tierzuhausebild) {
        this.tiername = tiername;
        this.tierbild = tierbild;
        this.tierkategorie = tierkategorie;
        this.tierfamilie = tierfamilie;
        this.tierzuhause = tierzuhause;
        this.tierzuhausebild = tierzuhausebild;
    }

    //setter & getter
    public String getTiername() {
        return tiername;
    }

    public void setTiername(String tiername) {
        this.tiername = tiername;
    }

    public String getTierbild() {
        return tierbild;
    }

    public void setTierbild(String tierbild) {
        this.tierbild = tierbild;
    }

    public String getTierkategorie() {
        return tierkategorie;
    }

    public void setTierkategorie(String tierkategorie) {
        this.tierkategorie = tierkategorie;
    }

    public String getTierfamilie() {
        return tierfamilie;
    }

    public void setTierfamilie(String tierfamilie) {
        this.tierfamilie = tierfamilie;
    }

    public String getTierzuhause() {
        return tierzuhause;
    }

    public void setTierzuhause(String tierzuhause) {
        this.tierzuhause = tierzuhause;
    }

    public String getTierzuhausebild() {
        return tierzuhausebild;
    }

    public void setTierzuhausebild(String tierzuhausebild) {
        this.tierzuhausebild = tierzuhausebild;
    }

    //überschriebene toString Methode
    @Override
    public String toString() {
        return this.tiername + ", Familie der " + this.tierfamilie + ", gehört zur Kategorie " + this.tierkategorie + ", Zuhause: " + this.tierzuhause;
    }

    //speichert die Daten in einem Bundle
    public Bundle asBundle() {
        Bundle b = new Bundle();
        b.putString("Tiername",tiername);
        b.putString("Familie",tierfamilie);
        b.putString("Kategorie",tierkategorie);
        b.putString("Zuhause",tierzuhause);
        b.putString("Tierbild",tierbild);
        b.putString("Zuhausebild",tierzuhausebild);
        return b;
    }
}