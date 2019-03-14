package com.example.wekaradwan.blood.UI;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wekaradwan.blood.Model.PeopleEntity;
import com.example.wekaradwan.blood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weka radwan on 2/24/2019.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleHolder> {

    private List<PeopleEntity> peopleEntities = new ArrayList<>();
    @NonNull
    @Override
    public PeopleAdapter.PeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item,parent,false);
        return new PeopleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.PeopleHolder holder, int position) {
        PeopleEntity currentPeople = peopleEntities.get(position);
        holder.textViewName.setText(currentPeople.getPeopleName());
        holder.textViewLocation.setText(currentPeople.getPeopleAddress());
        holder.textViewAge.setText(String.valueOf(currentPeople.getPeopleAge()));

    }

    @Override
    public int getItemCount() {
        return peopleEntities.size();
    }


    public void setPeopleEntities(List<PeopleEntity> peopleEntities){
        this.peopleEntities = peopleEntities;
        notifyDataSetChanged();
    }


    class PeopleHolder extends RecyclerView.ViewHolder{

//        private ImageView imageViewCall;
        private TextView textViewName;
        private TextView textViewLocation;
        private TextView textViewAge;


        public PeopleHolder(View itemView) {
            super(itemView);

//            imageViewCall = itemView.findViewById(R.id.imgvCall);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewLocation = itemView.findViewById(R.id.tvLoaction);
            textViewAge = itemView.findViewById(R.id.tvAge);
        }
    }
}
