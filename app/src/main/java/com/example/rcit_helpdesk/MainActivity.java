package com.example.rcit_helpdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ViewPager2 viewPager2;
    RecyclerViewBranchAdapter recyclerViewBranchAdapter;
    SliderAdapter sliderAdapter;

    ArrayList<branchName> bNameArrList= new ArrayList<>();
    List<SlideItem> slideItemList = new ArrayList<>();
    private Handler slideHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        viewPager2 = findViewById(R.id.imageSliderView);

        //adding images for slide view
        slideItemList.add(new SlideItem(R.drawable.s1));
        slideItemList.add(new SlideItem(R.drawable.s2));
        slideItemList.add(new SlideItem(R.drawable.s3));
        slideItemList.add(new SlideItem(R.drawable.imgview));

        //positioning images for slide using custom adapter
        sliderAdapter = new SliderAdapter(slideItemList,viewPager2);
        viewPager2.setAdapter(sliderAdapter);

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(runnable);
                slideHandler.postDelayed(runnable,2000);
            }
        });


        //naming branches
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bNameArrList.add(new branchName("Computer Science and Engineering"));
        bNameArrList.add(new branchName("Civil Engineering"));
        bNameArrList.add(new branchName("Electrical Engineering"));
        bNameArrList.add(new branchName("Electrical and Electronics Engineering"));
        bNameArrList.add(new branchName("Mechanical Engineering"));

        //positioning branch names on the screen
        recyclerViewBranchAdapter = new RecyclerViewBranchAdapter(this,bNameArrList);
        recyclerView.setAdapter(recyclerViewBranchAdapter);


    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

}