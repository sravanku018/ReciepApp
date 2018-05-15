package com.example.subramanyam.reciep;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StepsRecycler extends RecyclerView.Adapter<StepsRecycler.ViewHolder>{

private Context mContext;

StepsRecycler(Context context)
{
    this.mContext=context;
}


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.steprecycler,parent,false);



        return  new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
holder.stepDes1.setText(RecipList.stepsItems.get(position).getId() +"."+ RecipList.stepsItems.get(position).getShortDescription());

        Log.i("gsfgfg", RecipList.stepsItems.get(position).getVideoURL());
    final String videourl=    RecipList.stepsItems.get(position).getVideoURL();
    final String recDes=RecipList.stepsItems.get(position).getDescription();
    final String image=RecipList.stepsItems.get(position).getThumbnailURL();
      holder.stepDes1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(mContext,VideoDesM.class);
              intent.putExtra("videoUrl",videourl);
              intent.putExtra("description",recDes);
              intent.putExtra("image",image);
              mContext.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return RecipList.stepsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
 TextView stepDes1;


        ViewHolder(View itemView) {
            super(itemView);
            stepDes1=itemView.findViewById(R.id.stepDescription1);

                   }
    }
}
