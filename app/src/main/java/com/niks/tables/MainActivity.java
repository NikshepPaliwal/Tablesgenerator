package com.niks.tables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    SeekBar seekBar ;
    TextView table_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        table_no = findViewById(R.id.table_no);
        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(25);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                generateTable(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void generateTable(int i) {
        ArrayList<String> table = new ArrayList<>();
        for(int j=1; j<=10;j++){
            table.add(i+ " X "+ j+ " = " +i*j);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,table);
        listView.setAdapter(arrayAdapter);
        table_no.setText("Multiplication table of "+i);

    }
}