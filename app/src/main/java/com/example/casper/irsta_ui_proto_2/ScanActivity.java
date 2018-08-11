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
        //Enable the back arrow on the top toolbar to go back to the previous activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    initialiseUI();
    }

    //function that draws the toolbar menu on the top of the app
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        mSettings = menu.findItem(R.id.settings);
        mSave = menu.findItem(R.id.save);
        //hide the settings icon and show the save icon
        mSettings.setVisible(false);
        mSave.setVisible(true);

        return true;
    }
    // function to handle what happens with a toolbar icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //Call the openSaveDialog when the save icon is selected
        if (id == R.id.save){
            openSaveDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    //Function that calls SaveDialog in order to create a popup dialog
    public void openSaveDialog() {
        SaveDialog saveDialog = new SaveDialog();
        saveDialog.show(getSupportFragmentManager(), "Save Dialog");
    }

    private void initialiseUI() {
        mScanImage = findViewById(R.id.scanImage);
        //Define resource that is shown in PhotoView
        mScanImage.setImageResource(R.drawable.phase);
    }
}