package com.example.rcit_helpdesk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewBranchAdapter extends RecyclerView.Adapter<RecyclerViewBranchAdapter.ViewHolder> {

    Context context;
    ArrayList<branchName> branchNameArrayList;
    RecyclerViewBranchAdapter(Context context,ArrayList<branchName> branchNameArrayList){
        this.context = context;
        this.branchNameArrayList = branchNameArrayList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_branch,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    public void onBindViewHolder(ViewHolder holder,int position){
        holder.branchName.setText(branchNameArrayList.get(position).bName);
    }

    public int getItemCount(){

        return branchNameArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView branchName;
        CardView cardView;
        private final Context context;

        public ViewHolder(View itemView){
            super(itemView);
            branchName = itemView.findViewById(R.id.branchTxt);
            cardView = itemView.findViewById(R.id.carView);
            context = itemView.getContext();
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }
            public void onClick(View view){
            final Intent intent;
                switch(getAdapterPosition()){
                    case 0:
                        intent = new Intent(context,CseActivity.class);
                        intent.putExtra("source", "cse");
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context,CseActivity.class);
                        intent.putExtra("source","civil");
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context,CseActivity.class);
                        intent.putExtra("source","electrical");
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context,CseActivity.class);
                        intent.putExtra("source","electronics");
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context,CseActivity.class);
                        intent.putExtra("source","mechanical");
                        context.startActivity(intent);
                        break;
                }


            }


    }

}
