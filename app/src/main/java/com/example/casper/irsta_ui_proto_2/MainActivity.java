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

        // Define the Nav view for the menu at bottom of the app
        BottomNavigationView bottomNavView = findViewById(R.id.navBar);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //Change activity when menu item is selected
                    case R.id.nav_gallery:
                        Intent iGallery = new Intent(getApplicationContext(), GalleryActivity.class);
                        startActivity(iGallery);
                        // Animate the transition to new activity
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                }
                return false;
            }
        });

        initialiseUI();
    }

    //function that draws the toolbar menu on the top of the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        mSettings = menu.findItem(R.id.settings);
        mSave = menu.findItem(R.id.save);
        //Show the settings icon from the main toolbar but hide the save icon
        mSettings.setVisible(true);
        mSave.setVisible(false);
        return true;
    }

    private void initialiseUI() {
        mStartScanButton = findViewById(R.id.startScan);
        // Open the scanActivity when button is pressed.
        mStartScanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent iScan = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(iScan);
                // Animate the transition to new activity
                overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
            }
        });
    }
}
