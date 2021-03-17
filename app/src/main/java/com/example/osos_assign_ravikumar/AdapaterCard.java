package com.example.osos_assign_ravikumar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapaterCard extends RecyclerView.Adapter<AdapaterCard.ViewHolder> {
    MainActivity mainActivity;
    List<ModelCard> modelCardList;
   // AdapaterCard adapaterCard;

    public AdapaterCard(MainActivity mainActivity, List<ModelCard> modelCardList) {
        this.mainActivity = mainActivity;
        this.modelCardList = modelCardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_name.setText(modelCardList.get(position).getName());
        holder.text_username.setText(modelCardList.get(position).getUsername());
        holder.text_email.setText(modelCardList.get(position).getEmail());
        try{
            holder.text_street.setText(modelCardList.get(position).getAddress().getStreet());
            holder.text_city.setText(modelCardList.get(position).getAddress().getCity());
            holder.text_zipcode.setText(modelCardList.get(position).getAddress().getZipcode());

        }catch (Exception e)
        {

        }


    }

    @Override
    public int getItemCount() {
        return modelCardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_name;
        TextView text_username;
        TextView text_email;
        TextView text_street;
        TextView text_city;
        TextView text_zipcode;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name=itemView.findViewById(R.id.name_1);
            text_username=itemView.findViewById(R.id.username_1);
            text_email=itemView.findViewById(R.id.email);
            text_street=itemView.findViewById(R.id.street_1);
            text_city=itemView.findViewById(R.id.city_1);
            text_zipcode=itemView.findViewById(R.id.zipcode_1);
        }

    }
}
