package com.example.zakatemascalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

import android.widget.Switch;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // initiate a Switch
        Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);
        TextView ttajuk = (TextView) findViewById(R.id.tajuk);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

// check current state of a Switch (true or false).
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (simpleSwitch.isChecked()) {
                    simpleSwitch.setText("Malay");
                    ttajuk.setText("Setting");
                } else {
                    simpleSwitch.setText("Bahasa Inggeris");
                    ttajuk.setText("Tetapan");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.kami) {
            Intent intent = new Intent(Setting.this, about.class);
            startActivity(intent);
        } else if (item_id == R.id.calc) {
            Intent intent = new Intent(Setting.this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
