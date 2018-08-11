package com.example.casper.irsta_ui_proto_2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;

public class SaveDialog extends AppCompatDialogFragment {

    //Function that creates a dialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        //Define where to get the layout from for the dialogs view
        View view = inflater.inflate(R.layout.dialog_save, null);

        //set the characteristics of the dialog view
        builder.setView(view)
                .setTitle("Save Scan")
                //Create the cancel button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                //Create the save button
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        save code stuff here =)
                    }
                });
        //Build the dialog in order for it to popup
        return builder.create();
    }
}