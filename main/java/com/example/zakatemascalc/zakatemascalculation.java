package com.example.zakatemascalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class zakatemascalculation extends AppCompatActivity {

    android.widget.Button brecalczakat;

    TextView tjjenisemas, tguruf, trmjumlahnilai, trmemaszakat, trmjumlahzakat, tmssg, tmssg2;
    Intent intent;
    ImageView itickimage;
    String sjenis, sberat, sharga, srmjumlahnilai, srmemaszakat, srmjumlahzakat;
    double doublermjumlahnilai, doublermemaszakat, doublermjumlahzakat;
    double doubleberat, doublecurrentharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakatemascalculation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intent=getIntent();

        tjjenisemas=findViewById(R.id.jjenisemas);
        tguruf=findViewById(R.id.guruf);
        trmjumlahnilai=findViewById(R.id.rmjumlahnilai);
        trmemaszakat=findViewById(R.id.rmemaszakat);
        trmjumlahzakat=findViewById(R.id.rmjumlahzakat);
        tmssg=findViewById(R.id.mssg);
        tmssg2=findViewById(R.id.mssg2);
        itickimage=findViewById(R.id.tickimage);
        brecalczakat=findViewById(R.id.recalczakat);

        sberat=intent.getStringExtra("berat");
        sharga=intent.getStringExtra("harga");
        sjenis=intent.getStringExtra("jenis");

        doubleberat=Double.parseDouble(sberat);
        doublecurrentharga=Double.parseDouble(sharga);

        doublermjumlahnilai=doubleberat*doublecurrentharga;

        if (sjenis.equals("Simpan")){
            doublermemaszakat=(doubleberat-85)*doublecurrentharga;
            tguruf.setText("85g");
        }
        else if (sjenis.equals("Pakai")){
            doublermemaszakat=(doubleberat-200)*doublecurrentharga;
            tguruf.setText("200g");
        }

        if(doublermemaszakat<=0){
            doublermjumlahzakat=0.025*doublermemaszakat;
            tmssg.setText("Emas tidak wajib dizakatkan");
            tmssg2.setText("Berat emas kurang daripada nilai uruf");
            itickimage.setImageResource(R.drawable.wrong);
        }
        else{
            doublermjumlahzakat=0.025*doublermemaszakat;
        }

        srmjumlahnilai=Double.toString(doublermjumlahnilai);
        srmemaszakat=Double.toString(doublermemaszakat);
        srmjumlahzakat=Double.toString(doublermjumlahzakat);

        tjjenisemas.setText(sjenis);
        trmjumlahnilai.setText("RM " + srmjumlahnilai);
        trmemaszakat.setText("RM " + srmemaszakat);
        trmjumlahzakat.setText("RM " + srmjumlahzakat);

        brecalczakat=findViewById(R.id.recalczakat);

        brecalczakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(zakatemascalculation.this,MainActivity.class);
                startActivity(intent);
                finish();
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
            Intent intent=new Intent(zakatemascalculation.this,about.class);
            startActivity(intent);
        }
        else if (item_id==R.id.calc){
            Intent intent=new Intent(zakatemascalculation.this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}