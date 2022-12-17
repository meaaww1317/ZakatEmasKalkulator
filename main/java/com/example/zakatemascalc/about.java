package com.example.zakatemascalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

    public class about extends AppCompatActivity implements View.OnClickListener {

        //grid view
        public CardView gridYoutube, gridGithub, gridProfile, gridSetting;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.about);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            //card view grid * add from here*
            gridYoutube = (CardView) findViewById(R.id.grid1);
            gridYoutube.setOnClickListener(this);

            gridGithub = (CardView) findViewById(R.id.grid2);
            gridGithub.setOnClickListener(this);

            gridProfile = (CardView) findViewById(R.id.grid3);
            gridProfile.setOnClickListener(this);

            gridSetting = (CardView) findViewById(R.id.grid4);
            gridSetting.setOnClickListener(this);

        } // sec col

        //card view
        @Override
        public void onClick(View v) {
            Intent i;

            switch (v.getId()) {

                case R.id.grid1:
                    i = new Intent(about.this, Youtube.class);
                    startActivity(i);
                    break;

                case R.id.grid2:
                    i = new Intent(about.this, Github.class);
                    startActivity(i);
                    break;

                case R.id.grid3:
                    i = new Intent(about.this, UserProfile.class);
                    startActivity(i);
                    break;

                case R.id.grid4:
                    i = new Intent(about.this, Setting.class);
                    startActivity(i);
                    break;
            }
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
                Intent intent=new Intent(about.this,about.class);
                startActivity(intent);
            }
            else if (item_id==R.id.calc){
                Intent intent=new Intent(about.this,MainActivity.class);
                startActivity(intent);
            }
            return true;
        }

    } // last col