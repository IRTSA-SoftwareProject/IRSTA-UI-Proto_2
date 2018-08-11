package com.example.casper.irsta_ui_proto_2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GalleryActivity extends AppCompatActivity {

    private MenuItem mSelect;
    private MenuItem mDelete;
    private MenuItem mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_scan:
                        Intent iMain = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(iMain);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                return false;
            }
        });
    }

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
