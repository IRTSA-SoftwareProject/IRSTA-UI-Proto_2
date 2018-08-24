package com.example.casper.irsta_ui_proto_2;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.casper.irsta_ui_proto_2.model.Scan;
import com.example.casper.irsta_ui_proto_2.model.ScanAccessObject;
import com.example.casper.irsta_ui_proto_2.model.ScanInterface;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private List<Scan> scans;
    private Context context;
    private ImageView thumbImage;
    private TextView thumbTitle;

    public class ViewHolder extends RecyclerView.ViewHolder{
        //public ImageView thumb;

        public ViewHolder (View view){
            super(view);
            thumbImage = view.findViewById(R.id.imageThumb);
            thumbTitle = view.findViewById(R.id.imageTitle);
        }
    }

    public GalleryAdapter(Context context){
        this.context = context;

        ScanInterface scanAccessObject = new ScanAccessObject(context);

        scans = scanAccessObject.getAllScans();

    }

    @Override
    public int getItemCount(){
        return scans.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        // Code to add image into each view.
        thumbImage.setImageBitmap(scans.get(position).image);
        thumbTitle.setText(scans.get(position).name);

    }
}