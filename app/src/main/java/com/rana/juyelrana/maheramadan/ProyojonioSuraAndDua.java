package com.rana.juyelrana.maheramadan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProyojonioSuraAndDua extends AppCompatActivity {

    ListView suraListView;
    ArrayAdapter<String> suraAdapter;

    String[] suraAndDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proyojonio_sura_and_dua);

        suraListView = (ListView) findViewById(R.id.proyojonio_sura_list);
        suraAndDua = getResources().getStringArray(R.array.sura_list);
        suraAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_view2,
                R.id.txtAreaView, suraAndDua);

        suraListView.setAdapter(suraAdapter);

        suraListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(),Sura_Adiat.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),Sura_Al_Fill.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),Sura_all_Humajah.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),Ikhlas.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),Sura_ZilZal.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),SuraAlQadar.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(),Sura_All_Kafirun.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(),Sura_al_Kariah.class));
                        break;

                    case 8:
                        startActivity(new Intent(getApplicationContext(),Sura_Al_Kawsar.class));
                        break;
                    case 9:
                        startActivity(new Intent(getApplicationContext(),Sura_Al_Quraiys.class));
                        break;
                    case 10:
                        startActivity(new Intent(getApplicationContext(),SylhetBivag.class));
                        break;
                    case 11:
                        startActivity(new Intent(getApplicationContext(),OtherDistricts.class));
                        break;
                }

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("প্রয়োজনীয় সুরা ও দোয়া");
    }

}
