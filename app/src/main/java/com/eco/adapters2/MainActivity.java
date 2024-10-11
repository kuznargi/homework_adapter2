package com.eco.adapters2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView main_list;
    ArrayList<Integer> icons;
    ArrayList<String> titles;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        main_list = findViewById(R.id.main_list);
        titles = new ArrayList<>();
        titles.add("Canada");
        titles.add("Kazakhstan");
        titles.add("Germany");
        titles.add("United-Kingdom");

        icons = new ArrayList<>();
        icons.add(R.drawable.canada);
        icons.add(R.drawable.kz);
        icons.add(R.drawable.germany);
        icons.add(R.drawable.uk);
        customAdapter = new CustomAdapter(this, titles, icons);
        main_list.setAdapter(customAdapter);

                main_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        titles.remove(position);
                        icons.remove(position);
                        customAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Элемент удалён", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }


    }


