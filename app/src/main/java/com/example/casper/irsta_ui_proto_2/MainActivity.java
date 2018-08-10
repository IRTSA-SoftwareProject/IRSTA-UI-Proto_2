package com.example.casper.irsta_ui_proto_2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mStartScanButton;
    private MenuItem mSettings;
    private MenuItem mSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_gallery:
                        Intent iGallery = new Intent(getApplicationContext(), GalleryActivity.class);
                        startActivity(iGallery);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                }
                return false;
            }
        });

        initialiseUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        mSettings = menu.findItem(R.id.settings);
        mSave = menu.findItem(R.id.save);
        mSettings.setVisible(true);
        mSave.setVisible(false);
        return true;
    }

    private void initialiseUI() {
        mStartScanButton = findViewById(R.id.startScan);

        mStartScanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent iScan = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(iScan);
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
            }
        });
    }
}
