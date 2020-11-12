package com.example.kt2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<product> arrayList = new ArrayList<>();
        listView = findViewById(R.id.listView);
        arrayList.add(new product("Nguyen Van A", R.drawable.ima));
        arrayList.add(new product("Nguyen Van B", R.drawable.ima));
        arrayList.add(new product("Le Van C", R.drawable.ima));
        arrayList.add(new product("Tra Quang D", R.drawable.ima));
        arrayList.add(new product("Nguyen Van E", R.drawable.ima));
        arrayList.add(new product("Tran Van F", R.drawable.ima));
        arrayList.add(new product("Truong Van A", R.drawable.ima));
        arrayList.add(new product("Do Van Huy", R.drawable.ima));
        adapter adapter = new adapter(this, R.layout.listview_row, arrayList);
        listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                product products = arrayList.get(position);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("product", products);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), products.getTen(), Toast.LENGTH_LONG).show();
            }
        });
        this.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete ");
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        listView.removeViewAt(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();
                return false;
            }
            ;
        });
    }
}