package com.careerinfoway;

import android.os.Bundle;

import com.careerinfoway.fr.Page1;
import com.careerinfoway.fr.Page2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.careerinfoway.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements Page1.SendMessage {
/*public class MainActivity extends AppCompatActivity {*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void sendData(String message) {

        String tag = "android:switcher:" + R.id.view_pager + ":" + 1;
        Page2 f = (Page2) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);

    }

    /*
    public void sendData(String message) {

        String tag = "android:switcher:" + R.id.view_pager + ":" + 1;
        Page2 f = (Page2) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);

    }
    */
}