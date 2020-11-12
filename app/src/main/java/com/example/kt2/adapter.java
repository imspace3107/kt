package com.example.kt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class adapter extends ArrayAdapter<product> {
    private Context context;
    private int resource;
    public adapter(Context context, int resource, ArrayList<product> objects){
        super(context,resource,objects);
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView =layoutInflater.inflate(resource,parent,false);
        TextView textView=convertView.findViewById(R.id.ten);
        ImageView imageView=convertView.findViewById(R.id.hinh);
        textView.setText(getItem(position).getTen());
        imageView.setImageResource(getItem(position).getHinh());
        return convertView;
    }
}
