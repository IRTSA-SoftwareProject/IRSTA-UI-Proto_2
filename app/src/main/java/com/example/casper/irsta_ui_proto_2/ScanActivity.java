package com.example.casper.irsta_ui_proto_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class ScanActivity extends AppCompatActivity {

    private ImageView mScanImage;
    private MenuItem mSettings;
    private MenuItem mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initialiseUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        mSettings = menu.findItem(R.id.settings);
        mSave = menu.findItem(R.id.save);
        mSettings.setVisible(false);
        mSave.setVisible(true);
        return true;
    }

    private void initialiseUI() {
        mScanImage = findViewById(R.id.scanImage);
    }
}