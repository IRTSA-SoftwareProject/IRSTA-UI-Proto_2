package com.example.casper.irsta_ui_proto_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.github.chrisbanes.photoview.PhotoView;

public class ScanActivity extends AppCompatActivity {

    private PhotoView mScanImage;
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

//        mSave.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
//            @Override
//            public boolean onMenuItemClick(MenuItem mSave) {
//                openDialog();
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.save){
            openDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog() {
        SaveDialog saveDialog = new SaveDialog();
        saveDialog.show(getSupportFragmentManager(), "Save Dialog");
    }

    private void initialiseUI() {
        PhotoView mScanImage = findViewById(R.id.scanImage);
        mScanImage.setImageResource(R.drawable.phase);
    }
}