package com.example.rcit_helpdesk;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SlideViewHolder>{

    private List<SlideItem> slideItemList;
    private ViewPager2 viewPager2;

    SliderAdapter(List<SlideItem> slideItemList, ViewPager2 viewPager2) {
        this.slideItemList = slideItemList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SlideViewHolder holder, int position) {
        holder.setImage(slideItemList.get(position));
        if(position == slideItemList.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slideItemList.size();
    }

    class SlideViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

         SlideViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageContainer);

        }
        void setImage(SlideItem slideItem){

            imageView.setImageResource(slideItem.getImage());

        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideItemList.addAll(slideItemList);
            notifyDataSetChanged();
        }
    };

}
