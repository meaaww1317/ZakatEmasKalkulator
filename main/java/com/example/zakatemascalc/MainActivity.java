package com.example.zakatemascalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.widget.Button bcalczakat, bclear;

    EditText tcurrentberat;
    EditText tcurrentharga;
    RelativeLayout rpakai, rsimpan;

    SharedPreferences sharedPref;

    String typeofemas="0";
    String berat;
    String currentharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bcalczakat=findViewById(R.id.calczakat);
        bclear=findViewById(R.id.clear);

        tcurrentberat=findViewById(R.id.currentberat);
        tcurrentharga=findViewById(R.id.currentharga);
        rpakai=findViewById(R.id.pakai);
        rsimpan=findViewById(R.id.simpan);

        sharedPref = this.getSharedPreferences("dberat", Context.MODE_PRIVATE);
        sharedPref = this.getSharedPreferences("dharga", Context.MODE_PRIVATE);

        //load data
        berat=sharedPref.getString("dberat","0");
        currentharga=sharedPref.getString("dharga","0");

        rpakai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rpakai.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pakaisimpanfocus));
                rsimpan.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pakaisimpannotfoc));
                typeofemas="Pakai";
            }
        });

        rsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rsimpan.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pakaisimpanfocus));
                rpakai.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pakaisimpannotfoc));
                typeofemas="Simpan";
            }
        });

        bcalczakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                berat=tcurrentberat.getText().toString();
                currentharga=tcurrentharga.getText().toString();

                if (typeofemas.equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Sila pilih jenis emas dahulu", Toast.LENGTH_SHORT).show();
                }

                else if (berat.length()<=0)
                {
                    Toast.makeText(getApplicationContext(), "Sila masukkan berat emas dahulu", Toast.LENGTH_SHORT).show();
                }

                else if (currentharga.length()<=0)
                {
                    Toast.makeText(getApplicationContext(), "Sila masukkan harga emas dahulu", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent=new Intent(MainActivity.this,zakatemascalculation.class);
                    intent.putExtra("jenis",typeofemas);
                    intent.putExtra("berat",berat);
                    intent.putExtra("harga",currentharga);
                    startActivity(intent);

                    //save data
                    SharedPreferences.Editor editor=sharedPref.edit();
                    editor.putString("dberat", berat);
                    editor.putString("dharga", currentharga);
                    editor.apply();

                }

            }

        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tcurrentberat.setText(" ");
                tcurrentharga.setText(" ");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();

        if (item_id==R.id.kami){
            Intent intent=new Intent(MainActivity.this,about.class);
            startActivity(intent);
        }
        else if (item_id==R.id.calc){
            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}