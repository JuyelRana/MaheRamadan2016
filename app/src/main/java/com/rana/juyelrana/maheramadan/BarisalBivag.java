package com.rana.juyelrana.maheramadan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BarisalBivag extends AppCompatActivity {

    private List<Ramadan> ramadanList = new ArrayList<>();
    private RamadanListAdapter ramadanListAdapter;

    private ListView listView;

    //Set all catagory
    int[] image = new int[]{
            R.drawable.rahmat, R.drawable.rahmat, R.drawable.rahmat, R.drawable.rahmat,R.drawable.rahmat, R.drawable.rahmat,R.drawable.rahmat, R.drawable.rahmat,R.drawable.rahmat, R.drawable.rahmat,
            R.drawable.magfirat, R.drawable.magfirat, R.drawable.magfirat, R.drawable.magfirat,R.drawable.magfirat, R.drawable.magfirat,R.drawable.magfirat, R.drawable.magfirat,R.drawable.magfirat, R.drawable.magfirat,
            R.drawable.najat, R.drawable.najat, R.drawable.najat, R.drawable.najat,R.drawable.najat, R.drawable.najat,R.drawable.najat,R.drawable.najat, R.drawable.najat, R.drawable.najat};

    String[] romjan_date = new String[]{
            "০১ রমজান", "০২ রমজান", "০৩ রমজান", "০৪ রমজান", "০৫ রমজান", "০৬ রমজান","০৭ রমজান", "০৮ রমজান", "০৯ রমজান", "১০ রমজান",
            "১১ রমজান", "১২ রমজান", "১৩ রমজান", "১৪ রমজান", "১৫ রমজান", "১৬ রমজান", "১৭ রমজান", "১৮ রমজান", "১৯ রমজান", "২০ রমজান",
            "২১ রমজান", "২২ রমজান","২৩ রমজান", "২৪ রমজান", "২৫ রমজান", "২৬ রমজান","২৭ রমজান", "২৮ রমজান", "২৯ রমজান", "৩০ রমজান"};

    String[] today_date = new String[]{
            "০৭জুন, মঙ্গলবার", "০৮ জুন, বুধবার", "০৯ জুন, বৃহস্পতিবার", "১০ জুন, শুক্রবার", "১১ জুন, শনিবার", "১২ জুন, রবিবার","১৩ জুন, সোমবার", "১৪ জুন, মঙ্গলবার", "১৫জুন, বুধবার", "১৬ জুন,বৃহস্পতিবার",
            "১৭ জুন, শুক্রবার", "১৮ জুন, শনিবার", "১৯ জুলাই, রবিবার", "২০ জুলাই, সোমবার", "২১ জুলাই, মঙ্গলবার", "২২ জুলাই, বুধবার","২৩ জুলাই,বৃহস্পতিবার", "২৪ জুলাই, শুক্রবার", "২৫ জুলাই, শনিবার", "২৬ জুলাই, রবিবার",
            "২৭ জুলাই, সোমবার", "২৮ জুলাই, মঙ্গলবার", "২৯ জুলাই, বুধবার", "৩০ জুলাই, বৃহস্পতিবার", "১ জুলাই, শুক্রবার", "২ জুলাই, শনিবার","৩ জুলাই, রবিবার", "৪ জুলাই, সোমবার", "৫ জুলাই, মঙ্গলবার","৬ জুলাই, বুধবার"};

    String[] seheri_time = new String[]{
            "সেহেরীর শেষ সময়ঃ 3:39 am", "সেহেরীর শেষ সময়ঃ3:39 am", "সেহেরীর শেষ সময়ঃ 3:39 am", "সেহেরীর শেষ সময়ঃ 3:39 am","সেহেরীর শেষ সময়ঃ 3:39 am", "সেহেরীর শেষ সময়ঃ 3:39 am", "সেহেরীর শেষ সময়ঃ 3:39 am", "সেহেরীর শেষ সময়ঃ 3:40 am", "সেহেরীর শেষ সময়ঃ 3:40 am","সেহেরীর শেষ সময়ঃ 3:40 am",
            "সেহেরীর শেষ সময়ঃ 3:40 am", "সেহেরীর শেষ সময়ঃ 3:40 am", "সেহেরীর শেষ সময়ঃ 3:40 am", "সেহেরীর শেষ সময়ঃ 3:40 am","সেহেরীর শেষ সময়ঃ 3:40 am", "সেহেরীর শেষ সময়ঃ 3:41 am", "সেহেরীর শেষ সময়ঃ 3:41 am", "সেহেরীর শেষ সময়ঃ 3:41 am", "সেহেরীর শেষ সময়ঃ 3:41 am","সেহেরীর শেষ সময়ঃ 3:42 am",
            "সেহেরীর শেষ সময়ঃ 3:42 am", "সেহেরীর শেষ সময়ঃ 3:42 am", "সেহেরীর শেষ সময়ঃ 3:43 am", "সেহেরীর শেষ সময়ঃ 3:43 am","সেহেরীর শেষ সময়ঃ 3:43 am", "সেহেরীর শেষ সময়ঃ 3:44 am", "সেহেরীর শেষ সময়ঃ 3:44 am", "সেহেরীর শেষ সময়ঃ 3:45 am", "সেহেরীর শেষ সময়ঃ 3:45 am","সেহেরীর শেষ সময়ঃ 3:46 am"};

    String[] iftar_time = new String[]{
            "ইফতারঃ 6:49 pm", "ইফতারঃ 6:49 pm", "ইফতারঃ 6:50 pm", "ইফতারঃ  6:50 pm","ইফতারঃ  6:50 pm", "ইফতারঃ  6:51 pm", "ইফতারঃ  6:51 pm", "ইফতারঃ  6:51 pm", "ইফতারঃ  6:52 pm","ইফতারঃ 6:52 pm",
            "ইফতারঃ 6:52 pm", "ইফতারঃ 6:52 pm", "ইফতারঃ 6:53 pm", "ইফতারঃ 6:53 pm","ইফতারঃ 6:53 pm", "ইফতারঃ 6:53 pm", "ইফতারঃ 6:54 pm", "ইফতারঃ 6:54 pm", "ইফতারঃ 6:54 pm","ইফতারঃ 6:54 pm",
            "ইফতারঃ 6:54 pm", "ইফতারঃ 6:54 pm", "ইফতারঃ 6:54 pm", "ইফতারঃ 6:54 pm","ইফতারঃ 6:54 pm", "ইফতারঃ 6:55 pm", "ইফতারঃ 6:55 pm", "ইফতারঃ 6:55 pm", "ইফতারঃ 6:55 pm","ইফতারঃ 6:55 pm"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barisal_bivag);

        // Manipulate ListView
        listView = (ListView) findViewById(R.id.barisal_list);
        //Custom ListAdapter
        ramadanListAdapter = new RamadanListAdapter(this,ramadanList);
        //Setting ListView's adapter to the custom list adapter we've created
        listView.setAdapter(ramadanListAdapter);

        for (int i = 0; i < image.length; i++) {

            Ramadan ramadan = new Ramadan();
            ramadan.setImage(image[i]);
            ramadan.setRomjan_date(romjan_date[i]);
            ramadan.setToday_date(today_date[i]);
            ramadan.setSeheri_time(seheri_time[i]);
            ramadan.setIftar_time(iftar_time[i]);

            ramadanList.add(ramadan);

        }

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
