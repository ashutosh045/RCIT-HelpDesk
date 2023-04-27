package com.example.rcit_helpdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class CseActivity extends AppCompatActivity {

    ViewPagerCommonAdapter adapter;
    TabLayout tabLayoutCse;
    ViewPager viewPagerCse;
    Toolbar toolbar;
    public String Department = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);

        Intent intent  = getIntent();
        Department = intent.getStringExtra("source");

        //naming toolbar
        toolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);

            if(getSupportActionBar()!=null){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle("  ");
            }


        tabLayoutCse = findViewById(R.id.tabLayoutCse);
        viewPagerCse = findViewById(R.id.viewPagerCse);

        //setting fragment layout with tab layout.
        adapter = new ViewPagerCommonAdapter(getSupportFragmentManager());
        viewPagerCse.setAdapter(adapter);

        tabLayoutCse.setupWithViewPager(viewPagerCse);

    }

//    public void onStart(){
//        super.onStart();
//
//        Intent intent  = getIntent();
//        System.out.println(intent.getStringExtra("source"));
//        switch (intent.getStringExtra("source")){
//            case "cse":
//                break;
//            case "civil":
//                showCivilActivity();
//                break;
//            case "electrical":
//                showElectricalActivity();
//                break;
//            case "electronics":
//                showElectronicsActivity();
//                break;
//            case "mechanical":
//                showMechanicalActivity();
//                break;
//        }
//
//    }


    public void showCseActivity(){
        Toast.makeText(this, "Cse Here!", Toast.LENGTH_SHORT).show();
    }

    public void showCivilActivity(){
        Toast.makeText(this, "Civil Here!", Toast.LENGTH_SHORT).show();
    }

    public void showElectricalActivity(){
        Toast.makeText(this, "Electrical Here!", Toast.LENGTH_SHORT).show();
    }

    public void showElectronicsActivity(){
        Toast.makeText(this, "Electronics Here!", Toast.LENGTH_SHORT).show();
    }
    public void showMechanicalActivity(){
        Toast.makeText(this, "Mechanical Here!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}