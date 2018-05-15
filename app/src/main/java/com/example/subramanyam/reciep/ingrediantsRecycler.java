package com.example.subramanyam.reciep;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ingrediantsRecycler extends RecyclerView.Adapter<ingrediantsRecycler.ViewHolder> {

   private Context mContext;
    private int ids;
    List<IngredientsItem> responses;

    ingrediantsRecycler(Context context)
    {
        this.mContext=context;





    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingrediantsdetails,parent,false);
        ButterKnife.bind(this,parent);
        return new ViewHolder(view) {
        };
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

holder.textView3.setText(RecipList.ingredientsItems.get(position).getIngredient() + "\n" + RecipList.ingredientsItems.get(position).getMeasure()
+ "\n" + RecipList.ingredientsItems.get(position).getQuantity());



    }



    @Override
    public int getItemCount() {
        return RecipList.ingredientsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.ingrediantDetails) TextView textView3;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);




        }
    }
}
