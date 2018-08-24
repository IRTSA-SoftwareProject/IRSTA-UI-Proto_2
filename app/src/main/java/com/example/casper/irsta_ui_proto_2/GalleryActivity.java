package com.example.casper.irsta_ui_proto_2;

import android.content.Intent;
import android.media.Image;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.casper.irsta_ui_proto_2.model.Scan;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private MenuItem mSelect;
    private MenuItem mDelete;
    private MenuItem mShare;
    private ArrayList<Scan> images;
    private RecyclerView recyclerView;
    private GalleryAdapter mAdapter;
    private File imgDir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Define the Nav view for the menu at bottom of the app
        BottomNavigationView bottomNavView = findViewById(R.id.navBar);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_scan:
                        Intent iMain = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(iMain);
                        //Animation transition to new activity
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                return false;
            }
        });

        images = new ArrayList<>();
        mAdapter = new GalleryAdapter(getApplicationContext());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(mAdapter);


    }

    //function to draws the toolbar menu and icons on the top of the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_gallery, menu);
        mSelect = menu.findItem(R.id.select);
        mDelete = menu.findItem(R.id.delete);
        mShare =  menu.findItem(R.id.share);
        return true;
    }
}
