package com.rana.juyelrana.maheramadan;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //For Third tab
    private TextView txtFirstCount, txtTotalCount;
    int count = 0, totalCount = 0;
    //
    //For First Tab
    TextView txtDate, txtMonth, txtDayName;
    String todaydate;
    int month;
    String dayName;
    private List<String> divisions;
    private Spinner spinner;
    //

    private TextView txtSeheri, txtIftar, txtRomjanCount;

    private Button btnTotalCalender;

    private String bivag;

    private int my_bivag;

    private String fulldate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSeheri = (TextView) findViewById(R.id.txt_seherir_somoi);
        txtIftar = (TextView) findViewById(R.id.txt_iftarer_somoi);
        txtRomjanCount = (TextView) findViewById(R.id.txt_set_romjan);
        btnTotalCalender = (Button) findViewById(R.id.btn_total_calender);


        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.first_tab);
        spec.setIndicator("আজ");

        //First tab layout component initialization
        final LinearLayout firstLinearLayout = (LinearLayout) findViewById(R.id.first_tab);
        txtDate = (TextView) firstLinearLayout.findViewById(R.id.txt_date);
        txtMonth = (TextView) firstLinearLayout.findViewById(R.id.txt_month);
        txtDayName = (TextView) firstLinearLayout.findViewById(R.id.txt_day);


        //settings for spinner
        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);


        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            private String item;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                item = parent.getItemAtPosition(position).toString();

                bivag = "" + item;

                //For See total calender
                btnTotalCalender.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (item.equals("ঢাকা")) {
                            startActivity(new Intent(getApplicationContext(), DhakaBivag.class));

                        } else if (item.equals("রাজশাহী")) {
                            startActivity(new Intent(getApplicationContext(), Rajshahi.class));

                        } else if (item.equals("সিলেট")) {
                            startActivity(new Intent(getApplicationContext(), SylhetBivag.class));
                        } else if (item.equals("বরিশাল")) {
                            startActivity(new Intent(getApplicationContext(), BarisalBivag.class));
                        } else if (item.equals("খুলনা")) {
                            startActivity(new Intent(getApplicationContext(), Kulna_Bivag.class));
                        } else if (item.equals("রংপুর")) {
                            startActivity(new Intent(getApplicationContext(), Rangpur_Bivag.class));
                        } else if (item.equals("চট্রগ্রাম")) {
                            startActivity(new Intent(getApplicationContext(), ChittagongBivag.class));
                        }
                    }
                });


                //Set Seheri and Iftar time for Dhaka Bivag
                if (item.equals("ঢাকা")) {

                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("3:48 am");

                    } else if (fulldate.equals("085")) {
                        txtRomjanCount.setText("০২ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("3:48 am");

                    } else if (fulldate.equals("095")) {
                        txtRomjanCount.setText("০৩ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("3:49 am");

                    } else if (fulldate.equals("105")) {
                        txtRomjanCount.setText("০৪ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("3:49 am");

                    } else if (fulldate.equals("115")) {
                        txtRomjanCount.setText("০৫ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("3:49 am");

                    } else if (fulldate.equals("125")) {
                        txtRomjanCount.setText("০৬ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("6:50 pm");

                    } else if (fulldate.equals("135")) {
                        txtRomjanCount.setText("০৭ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("6:50 pm");

                    } else if (fulldate.equals("145")) {
                        txtRomjanCount.setText("০৮ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:50 pm");

                    } else if (fulldate.equals("155")) {
                        txtRomjanCount.setText("০৯ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("165")) {
                        txtRomjanCount.setText("১০ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("175")) {
                        txtRomjanCount.setText("১১ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("185")) {
                        txtRomjanCount.setText("১২ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("195")) {
                        txtRomjanCount.setText("১৩ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("205")) {
                        txtRomjanCount.setText("১৪ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("215")) {
                        txtRomjanCount.setText("১৫ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("225")) {
                        txtRomjanCount.setText("১৬ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("235")) {
                        txtRomjanCount.setText("১৭ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("245")) {
                        txtRomjanCount.setText("১৮ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("255")) {
                        txtRomjanCount.setText("১৯ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("265")) {
                        txtRomjanCount.setText("২০ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("275")) {
                        txtRomjanCount.setText("২১ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("285")) {
                        txtRomjanCount.setText("২২ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("295")) {
                        txtRomjanCount.setText("২৩ রমজান");
                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("305")) {
                        txtRomjanCount.setText("২৪ রমজান");
                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("016")) {
                        txtRomjanCount.setText("২৫ রমজান");
                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("026")) {
                        txtRomjanCount.setText("২৬ রমজান");
                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("036")) {
                        txtRomjanCount.setText("২৭ রমজান");
                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("046")) {
                        txtRomjanCount.setText("২৮ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("056")) {
                        txtRomjanCount.setText("২৯ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("066")) {
                        txtRomjanCount.setText("৩০ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:54 pm");

                    } else {
                        txtRomjanCount.setText("00 রমজান");
                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }

                } else if (item.equals("রাজশাহী")) {  //Set Seheri and Iftar time for Rajshahi bivag

                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("3:55 am");

                    } else if (fulldate.equals("085")) {
                        txtRomjanCount.setText("০২ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("3:55 am");

                    } else if (fulldate.equals("095")) {
                        txtRomjanCount.setText("০৩ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("3:56 am");

                    } else if (fulldate.equals("105")) {
                        txtRomjanCount.setText("০৪ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("3:56 am");

                    } else if (fulldate.equals("115")) {
                        txtRomjanCount.setText("০৫ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("3:56 am");

                    } else if (fulldate.equals("125")) {
                        txtRomjanCount.setText("০৬ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("135")) {
                        txtRomjanCount.setText("০৭ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("145")) {
                        txtRomjanCount.setText("০৮ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("155")) {
                        txtRomjanCount.setText("০৯ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("165")) {
                        txtRomjanCount.setText("১০ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("175")) {
                        txtRomjanCount.setText("১১ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("185")) {
                        txtRomjanCount.setText("১২ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("195")) {
                        txtRomjanCount.setText("১৩ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("205")) {
                        txtRomjanCount.setText("১৪ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("215")) {
                        txtRomjanCount.setText("১৫ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("225")) {
                        txtRomjanCount.setText("১৬ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("235")) {
                        txtRomjanCount.setText("১৭ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("245")) {
                        txtRomjanCount.setText("১৮ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("255")) {
                        txtRomjanCount.setText("১৯ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("265")) {
                        txtRomjanCount.setText("২০ রমজান");
                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("275")) {
                        txtRomjanCount.setText("২১ রমজান");
                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("285")) {
                        txtRomjanCount.setText("২২ রমজান");
                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("295")) {
                        txtRomjanCount.setText("২৩ রমজান");
                        txtSeheri.setText("3:49 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("305")) {
                        txtRomjanCount.setText("২৪ রমজান");
                        txtSeheri.setText("3:49 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("016")) {
                        txtRomjanCount.setText("২৫ রমজান");
                        txtSeheri.setText("3:49 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("026")) {
                        txtRomjanCount.setText("২৬ রমজান");
                        txtSeheri.setText("3:50 am");
                        txtIftar.setText("7:01 pm");

                    } else if (fulldate.equals("036")) {
                        txtRomjanCount.setText("২৭ রমজান");
                        txtSeheri.setText("3:50 am");
                        txtIftar.setText("7:01 pm");

                    } else if (fulldate.equals("046")) {
                        txtRomjanCount.setText("২৮ রমজান");
                        txtSeheri.setText("3:51 am");
                        txtIftar.setText("7:01 pm");

                    } else if (fulldate.equals("056")) {
                        txtRomjanCount.setText("২৯ রমজান");
                        txtSeheri.setText("3:51 am");
                        txtIftar.setText("7:01 pm");

                    } else if (fulldate.equals("066")) {
                        txtRomjanCount.setText("৩০ রমজান");
                        txtSeheri.setText("3:52 am");
                        txtIftar.setText("7:01 pm");

                    } else {
                        txtRomjanCount.setText("00 রমজান");
                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }

                } else if (item.equals("সিলেট")) {  //Set Seheri and Iftar time for Rajshahi bivag

                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("3:42 am");

                    } else if (fulldate.equals("085")) {
                        txtRomjanCount.setText("০২ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("3:42 am");

                    } else if (fulldate.equals("095")) {
                        txtRomjanCount.setText("০৩ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("3:43 am");

                    } else if (fulldate.equals("105")) {
                        txtRomjanCount.setText("০৪ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("3:43 am");

                    } else if (fulldate.equals("115")) {
                        txtRomjanCount.setText("০৫ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("3:43 am");

                    } else if (fulldate.equals("125")) {
                        txtRomjanCount.setText("০৬ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("6:44 pm");

                    } else if (fulldate.equals("135")) {
                        txtRomjanCount.setText("০৭ রমজান");
                        txtSeheri.setText("3:32 am");
                        txtIftar.setText("6:44 pm");

                    } else if (fulldate.equals("145")) {
                        txtRomjanCount.setText("০৮ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:44 pm");

                    } else if (fulldate.equals("155")) {
                        txtRomjanCount.setText("০৯ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("165")) {
                        txtRomjanCount.setText("১০ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("175")) {
                        txtRomjanCount.setText("১১ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("185")) {
                        txtRomjanCount.setText("১২ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("195")) {
                        txtRomjanCount.setText("১৩ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("205")) {
                        txtRomjanCount.setText("১৪ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("215")) {
                        txtRomjanCount.setText("১৫ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("225")) {
                        txtRomjanCount.setText("১৬ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("235")) {
                        txtRomjanCount.setText("১৭ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("245")) {
                        txtRomjanCount.setText("১৮ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("255")) {
                        txtRomjanCount.setText("১৯ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("265")) {
                        txtRomjanCount.setText("২০ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("275")) {
                        txtRomjanCount.setText("২১ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("285")) {
                        txtRomjanCount.setText("২২ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("295")) {
                        txtRomjanCount.setText("২৩ রমজান");
                        txtSeheri.setText("3:36 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("305")) {
                        txtRomjanCount.setText("২৪ রমজান");
                        txtSeheri.setText("3:36 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("016")) {
                        txtRomjanCount.setText("২৫ রমজান");
                        txtSeheri.setText("3:36 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("026")) {
                        txtRomjanCount.setText("২৬ রমজান");
                        txtSeheri.setText("3:37 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("036")) {
                        txtRomjanCount.setText("২৭ রমজান");
                        txtSeheri.setText("3:37 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("046")) {
                        txtRomjanCount.setText("২৮ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("056")) {
                        txtRomjanCount.setText("২৯ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("066")) {
                        txtRomjanCount.setText("৩০ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:48 pm");

                    } else {
                        txtRomjanCount.setText("00 রমজান");
                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }

                } else if (item.equals("বরিশাল")) {  //Set Seheri and Iftar time for Barishal bivag

                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("3:49 am");

                    } else if (fulldate.equals("085")) {
                        txtRomjanCount.setText("০২ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("3:49 am");

                    } else if (fulldate.equals("095")) {
                        txtRomjanCount.setText("০৩ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("3:50 am");

                    } else if (fulldate.equals("105")) {
                        txtRomjanCount.setText("০৪ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("3:50 am");

                    } else if (fulldate.equals("115")) {
                        txtRomjanCount.setText("০৫ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("3:50 am");

                    } else if (fulldate.equals("125")) {
                        txtRomjanCount.setText("০৬ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("135")) {
                        txtRomjanCount.setText("০৭ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("145")) {
                        txtRomjanCount.setText("০৮ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:51 pm");

                    } else if (fulldate.equals("155")) {
                        txtRomjanCount.setText("০৯ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("165")) {
                        txtRomjanCount.setText("১০ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("175")) {
                        txtRomjanCount.setText("১১ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("185")) {
                        txtRomjanCount.setText("১২ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:52 pm");

                    } else if (fulldate.equals("195")) {
                        txtRomjanCount.setText("১৩ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("205")) {
                        txtRomjanCount.setText("১৪ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("215")) {
                        txtRomjanCount.setText("১৫ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("225")) {
                        txtRomjanCount.setText("১৬ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("235")) {
                        txtRomjanCount.setText("১৭ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("245")) {
                        txtRomjanCount.setText("১৮ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("255")) {
                        txtRomjanCount.setText("১৯ রমজান");
                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("265")) {
                        txtRomjanCount.setText("২০ রমজান");
                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("275")) {
                        txtRomjanCount.setText("২১ রমজান");
                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("285")) {
                        txtRomjanCount.setText("২২ রমজান");
                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("295")) {
                        txtRomjanCount.setText("২৩ রমজান");
                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("305")) {
                        txtRomjanCount.setText("২৪ রমজান");
                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("016")) {
                        txtRomjanCount.setText("২৫ রমজান");
                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("026")) {
                        txtRomjanCount.setText("২৬ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("036")) {
                        txtRomjanCount.setText("২৭ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("046")) {
                        txtRomjanCount.setText("২৮ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("056")) {
                        txtRomjanCount.setText("২৯ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("066")) {
                        txtRomjanCount.setText("৩০ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:55 pm");

                    } else {
                        txtRomjanCount.setText("00 রমজান");
                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }
                } else if (item.equals("খুলনা")) {


                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("3:51 am");

                    } else if (fulldate.equals("085")) {

                        txtRomjanCount.setText("০২ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("3:51 am");

                    } else if (fulldate.equals("095")) {

                        txtRomjanCount.setText("০৩ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("3:52 am");

                    } else if (fulldate.equals("105")) {

                        txtRomjanCount.setText("০৪ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("3:52 am");

                    } else if (fulldate.equals("115")) {

                        txtRomjanCount.setText("০৫ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("3:52 am");

                    } else if (fulldate.equals("125")) {

                        txtRomjanCount.setText("০৬ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("135")) {

                        txtRomjanCount.setText("০৭ রমজান");

                        txtSeheri.setText("3:41 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("145")) {

                        txtRomjanCount.setText("০৮ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:53 pm");

                    } else if (fulldate.equals("155")) {


                        txtRomjanCount.setText("০৯ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("165")) {

                        txtRomjanCount.setText("১০ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("175")) {

                        txtRomjanCount.setText("১১ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("185")) {

                        txtRomjanCount.setText("১২ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:54 pm");

                    } else if (fulldate.equals("195")) {

                        txtRomjanCount.setText("১৩ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("205")) {

                        txtRomjanCount.setText("১৪ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("215")) {

                        txtRomjanCount.setText("১৫ রমজান");

                        txtSeheri.setText("3:42 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("225")) {

                        txtRomjanCount.setText("১৬ রমজান");

                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:55 pm");

                    } else if (fulldate.equals("235")) {

                        txtRomjanCount.setText("১৭ রমজান");

                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("245")) {

                        txtRomjanCount.setText("১৮ রমজান");

                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("255")) {

                        txtRomjanCount.setText("১৯ রমজান");

                        txtSeheri.setText("3:43 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("265")) {

                        txtRomjanCount.setText("২০ রমজান");

                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("275")) {

                        txtRomjanCount.setText("২১ রমজান");

                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("285")) {

                        txtRomjanCount.setText("২২ রমজান");

                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("295")) {

                        txtRomjanCount.setText("২৩ রমজান");

                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("305")) {

                        txtRomjanCount.setText("২৪ রমজান");

                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("016")) {

                        txtRomjanCount.setText("২৫ রমজান");

                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("026")) {

                        txtRomjanCount.setText("২৬ রমজান");

                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("036")) {

                        txtRomjanCount.setText("২৭ রমজান");

                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("046")) {

                        txtRomjanCount.setText("২৮ রমজান");

                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("056")) {

                        txtRomjanCount.setText("২৯ রমজান");

                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("066")) {

                        txtRomjanCount.setText("৩০ রমজান");

                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("6:57 pm");

                    } else {

                        txtRomjanCount.setText("০০ রমজান");

                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }

                } else if (item.equals("রংপুর")) {  //Set Seheri and Iftar time for Rangpur bivag

                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("3:54 am");

                    } else if (fulldate.equals("085")) {
                        txtRomjanCount.setText("০২ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("3:54 am");

                    } else if (fulldate.equals("095")) {
                        txtRomjanCount.setText("০৩ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("3:55 am");

                    } else if (fulldate.equals("105")) {
                        txtRomjanCount.setText("০৪ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("3:55 am");

                    } else if (fulldate.equals("115")) {
                        txtRomjanCount.setText("০৫ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("3:55 am");

                    } else if (fulldate.equals("125")) {
                        txtRomjanCount.setText("০৬ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("135")) {
                        txtRomjanCount.setText("০৭ রমজান");
                        txtSeheri.setText("3:44 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("145")) {
                        txtRomjanCount.setText("০৮ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:56 pm");

                    } else if (fulldate.equals("155")) {
                        txtRomjanCount.setText("০৯ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("165")) {
                        txtRomjanCount.setText("১০ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("175")) {
                        txtRomjanCount.setText("১১ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("185")) {
                        txtRomjanCount.setText("১২ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:57 pm");

                    } else if (fulldate.equals("195")) {
                        txtRomjanCount.setText("১৩ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("205")) {
                        txtRomjanCount.setText("১৪ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("215")) {
                        txtRomjanCount.setText("১৫ রমজান");
                        txtSeheri.setText("3:45 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("225")) {
                        txtRomjanCount.setText("১৬ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:58 pm");

                    } else if (fulldate.equals("235")) {
                        txtRomjanCount.setText("১৭ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("245")) {
                        txtRomjanCount.setText("১৮ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("255")) {
                        txtRomjanCount.setText("১৯ রমজান");
                        txtSeheri.setText("3:46 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("265")) {
                        txtRomjanCount.setText("২০ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("275")) {
                        txtRomjanCount.setText("২১ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("285")) {
                        txtRomjanCount.setText("২২ রমজান");
                        txtSeheri.setText("3:47 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("295")) {
                        txtRomjanCount.setText("২৩ রমজান");
                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("305")) {
                        txtRomjanCount.setText("২৪ রমজান");
                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("016")) {
                        txtRomjanCount.setText("২৫ রমজান");
                        txtSeheri.setText("3:48 am");
                        txtIftar.setText("6:59 pm");

                    } else if (fulldate.equals("026")) {
                        txtRomjanCount.setText("২৬ রমজান");
                        txtSeheri.setText("3:49 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("036")) {
                        txtRomjanCount.setText("২৭ রমজান");
                        txtSeheri.setText("3:49 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("046")) {
                        txtRomjanCount.setText("২৮ রমজান");
                        txtSeheri.setText("3:50 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("056")) {
                        txtRomjanCount.setText("২৯ রমজান");
                        txtSeheri.setText("3:50 am");
                        txtIftar.setText("7:00 pm");

                    } else if (fulldate.equals("066")) {
                        txtRomjanCount.setText("৩০ রমজান");
                        txtSeheri.setText("3:51 am");
                        txtIftar.setText("7:00 pm");

                    } else {
                        txtRomjanCount.setText("00 রমজান");
                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }

                } else if (item.equals("চট্রগ্রাম")) {  //Set Seheri and Iftar time for Chittagong bivag

                    if (fulldate.equals("075")) {

                        txtRomjanCount.setText("০১ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("3:43 am");

                    } else if (fulldate.equals("085")) {
                        txtRomjanCount.setText("০২ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("3:43 am");

                    } else if (fulldate.equals("095")) {
                        txtRomjanCount.setText("০৩ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("3:44 am");

                    } else if (fulldate.equals("105")) {
                        txtRomjanCount.setText("০৪ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("3:44 am");

                    } else if (fulldate.equals("115")) {
                        txtRomjanCount.setText("০৫ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("3:44 am");

                    } else if (fulldate.equals("125")) {
                        txtRomjanCount.setText("০৬ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("135")) {
                        txtRomjanCount.setText("০৭ রমজান");
                        txtSeheri.setText("3:33 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("145")) {
                        txtRomjanCount.setText("০৮ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:45 pm");

                    } else if (fulldate.equals("155")) {
                        txtRomjanCount.setText("০৯ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("165")) {
                        txtRomjanCount.setText("১০ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("175")) {
                        txtRomjanCount.setText("১১ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("185")) {
                        txtRomjanCount.setText("১২ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:46 pm");

                    } else if (fulldate.equals("195")) {
                        txtRomjanCount.setText("১৩ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("205")) {
                        txtRomjanCount.setText("১৪ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("215")) {
                        txtRomjanCount.setText("১৫ রমজান");
                        txtSeheri.setText("3:34 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("225")) {
                        txtRomjanCount.setText("১৬ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:47 pm");

                    } else if (fulldate.equals("235")) {
                        txtRomjanCount.setText("১৭ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("245")) {
                        txtRomjanCount.setText("১৮ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("255")) {
                        txtRomjanCount.setText("১৯ রমজান");
                        txtSeheri.setText("3:35 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("265")) {
                        txtRomjanCount.setText("২০ রমজান");
                        txtSeheri.setText("3:36 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("275")) {
                        txtRomjanCount.setText("২১ রমজান");
                        txtSeheri.setText("3:36 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("285")) {
                        txtRomjanCount.setText("২২ রমজান");
                        txtSeheri.setText("3:36 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("295")) {
                        txtRomjanCount.setText("২৩ রমজান");
                        txtSeheri.setText("3:37 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("305")) {
                        txtRomjanCount.setText("২৪ রমজান");
                        txtSeheri.setText("3:37 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("016")) {
                        txtRomjanCount.setText("২৫ রমজান");
                        txtSeheri.setText("3:37 am");
                        txtIftar.setText("6:48 pm");

                    } else if (fulldate.equals("026")) {
                        txtRomjanCount.setText("২৬ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("6:49 pm");

                    } else if (fulldate.equals("036")) {
                        txtRomjanCount.setText("২৭ রমজান");
                        txtSeheri.setText("3:38 am");
                        txtIftar.setText("6:49 pm");

                    } else if (fulldate.equals("046")) {
                        txtRomjanCount.setText("২৮ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:49 pm");

                    } else if (fulldate.equals("056")) {
                        txtRomjanCount.setText("২৯ রমজান");
                        txtSeheri.setText("3:39 am");
                        txtIftar.setText("6:49 pm");

                    } else if (fulldate.equals("066")) {
                        txtRomjanCount.setText("৩০ রমজান");
                        txtSeheri.setText("3:40 am");
                        txtIftar.setText("6:49 pm");

                    } else {
                        txtRomjanCount.setText("00 রমজান");
                        txtSeheri.setText("0:00");
                        txtIftar.setText("0:00");

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Spinner Drop down elements
        divisions = new ArrayList<String>();
        divisions.add("ঢাকা");
        divisions.add("রাজশাহী");
        divisions.add("সিলেট");
        divisions.add("বরিশাল");
        divisions.add("খুলনা");
        divisions.add("রংপুর");
        divisions.add("চট্রগ্রাম");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, divisions);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        //Get current date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        todaydate = dateFormat.format(calendar.getTime());

        //Get Current Month
        month = calendar.get(Calendar.MONTH);

        //juyel
        fulldate = "" + todaydate + "" + month;

        //Get Current Day Name
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        Date date = new Date();
        dayName = format.format(date);

        //Set Current Date
        txtDate.setText("" + todaydate);

        //Set Current Month
        switch (month) {
            case 0:
                txtMonth.setText("জানুয়ারি");
                break;
            case 1:
                txtMonth.setText("ফেব্রুয়ারী");
                break;
            case 2:
                txtMonth.setText("মার্চ");
                break;
            case 3:
                txtMonth.setText("এপ্রিল");
                break;
            case 4:
                txtMonth.setText("মে");
                break;
            case 5:
                txtMonth.setText("জুন");
                break;
            case 6:
                txtMonth.setText("জুলাই");
                break;
            case 7:
                txtMonth.setText("আগস্ট");
                break;
            case 8:
                txtMonth.setText("সেপ্টেম্বর");
                break;
            case 9:
                txtMonth.setText("অক্টোবর");
                break;
            case 10:
                txtMonth.setText("নভেম্বর");
                break;
            case 11:
                txtMonth.setText("ডিসেম্বর");
                break;
        }

        //txtDayName.setText(dayName);


        //Set Current Day Name
        if (dayName.equals("Saturday")) {
            txtDayName.setText("শনিবার");
        } else if (dayName.equals("Sunday")) {
            txtDayName.setText("রবিবার");
        } else if (dayName.equals("Monday")) {
            txtDayName.setText("সোমবার");
        } else if (dayName.equals("Tuesday")) {
            txtDayName.setText("মঙ্গলবার");
        } else if (dayName.equals("Wednesday")) {
            txtDayName.setText("বুধবার");
        } else if (dayName.equals("Thursday")) {
            txtDayName.setText("বৃহঃস্পতিবার");
        } else if (dayName.equals("Friday")) {
            txtDayName.setText("শুক্রবার");
        }


        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.second_tab);
        spec.setIndicator("নামাযের সময়");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView tvMonthNamajSomoi = (TextView) findViewById(R.id.txt_month_in_second_tab);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        if (month == 0) {

            tvMonthNamajSomoi.setText("জানুয়ারি");
            imageView.setImageResource(R.drawable.january);

        } else if (month == 1) {
            tvMonthNamajSomoi.setText("ফেব্রুয়ারী");
            imageView.setImageResource(R.drawable.february);

        } else if (month == 2) {
            tvMonthNamajSomoi.setText("মার্চ");
            imageView.setImageResource(R.drawable.march);

        } else if (month == 3) {
            tvMonthNamajSomoi.setText("এপ্রিল");
            imageView.setImageResource(R.drawable.april);

        } else if (month == 4) {
            tvMonthNamajSomoi.setText("মে");
            imageView.setImageResource(R.drawable.may);

        } else if (month == 5) {
            tvMonthNamajSomoi.setText("জুন");
            imageView.setImageResource(R.drawable.june);

        } else if (month == 6) {
            tvMonthNamajSomoi.setText("জুলাই");
            imageView.setImageResource(R.drawable.july);

        } else if (month == 7) {
            tvMonthNamajSomoi.setText("আগস্ট");
            imageView.setImageResource(R.drawable.august);

        } else if (month == 8) {
            tvMonthNamajSomoi.setText("সেপ্টেম্বর");
            imageView.setImageResource(R.drawable.september);

        } else if (month == 9) {
            tvMonthNamajSomoi.setText("অক্টোবর");
            imageView.setImageResource(R.drawable.october);

        } else if (month == 10) {
            tvMonthNamajSomoi.setText("নভেম্বর");
            imageView.setImageResource(R.drawable.november);

        } else if (month == 11) {
            tvMonthNamajSomoi.setText("ডিসেম্বর");
            imageView.setImageResource(R.drawable.december);

        }


        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.third_tab);
        spec.setIndicator("তসবিহ");

        //third_tab_layout component initialization
        final LinearLayout thirdtabLinearLayout = (LinearLayout) findViewById(R.id.third_tab);

        txtFirstCount = (TextView) thirdtabLinearLayout.findViewById(R.id.txtCount);

        txtTotalCount = (TextView) thirdtabLinearLayout.findViewById(R.id.txt_total_count);

        Button btnCount = (Button) thirdtabLinearLayout.findViewById(R.id.btnCount);
        ImageButton btnReset = (ImageButton) thirdtabLinearLayout.findViewById(R.id.btnReset);

        //Set OnClickListener
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                totalCount++;
                txtFirstCount.setText("" + count);
                txtTotalCount.setText("" + totalCount);
                if (count == 33) {
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(500);
                    count = 0;
                }
            }
        });

        //Set OnClickListener
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                count = 0;
                totalCount = 0;
                txtFirstCount.setText("" + count);
                txtTotalCount.setText("" + totalCount);

            }
        });
        host.addTab(spec);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
                i.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm");
                i.putExtra(AlarmClock.EXTRA_HOUR, 11);
                i.putExtra(AlarmClock.EXTRA_MINUTES, 20);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.seheri_and_iftar) {

            startActivity(new Intent(getApplicationContext(), SeheriAndIftarerDoa.class));

        } else if (id == R.id.total_calender) {


            startActivity(new Intent(getApplicationContext(), TotalCalender.class));


        } else if (id == R.id.bises_amol) {

            startActivity(new Intent(getApplicationContext(), RamjanerTirishTiAmol.class));

        } else if (id == R.id.about_ramadan) {

        } else if (id == R.id.proyojonio_sura) {

            startActivity(new Intent(getApplicationContext(), ProyojonioSuraAndDua.class));

        } else if (id == R.id.share) {

        } else if (id == R.id.exit) {

        } else if (id == R.id.developer) {
            Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
