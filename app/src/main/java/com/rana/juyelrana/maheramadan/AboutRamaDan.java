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

public class AboutRamaDan extends AppCompatActivity {

    ListView aboutListView;
    ArrayAdapter<String> aboutAdapter;

    String[] aboutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_rama_dan);

        aboutListView = (ListView) findViewById(R.id.about_list);
        aboutList = getResources().getStringArray(R.array.romjan_related);
        aboutAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.list_view2,
                R.id.txtAreaView, aboutList);

        aboutListView.setAdapter(aboutAdapter);

        aboutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                switch (position){
//                    case 0:
//                        startActivity(new Intent(getApplicationContext(),DhakaBivag.class));
//                        break;
//                    case 1:
//                        startActivity(new Intent(getApplicationContext(),Rajshahi.class));
//                        break;
//                    case 2:
//                        startActivity(new Intent(getApplicationContext(),ChittagongBivag.class));
//                        break;
//                    case 3:
//                        startActivity(new Intent(getApplicationContext(),BarisalBivag.class));
//                        break;
//                    case 4:
//                        startActivity(new Intent(getApplicationContext(),Kulna_Bivag.class));
//                        break;
//                    case 5:
//                        startActivity(new Intent(getApplicationContext(),Rangpur_Bivag.class));
//                        break;
//                    case 6:
//                        startActivity(new Intent(getApplicationContext(),SylhetBivag.class));
//                        break;
//                    case 7:
//                        startActivity(new Intent(getApplicationContext(),OtherDistricts.class));
//                        break;
//                }
//
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
    }

}
