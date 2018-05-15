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

import java.util.List;

public class RecRece extends RecyclerView.Adapter<RecRece.ViewHolder> {
    public LayoutInflater layoutInflater;
    public Context mContext;
    private int food;
    List<Response> list;



    public RecRece(Context context)

    {
        mContext=context;




    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.receipelist,parent,false);
        return new ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

  holder.textView.setText(MainActivity.responseList.get(position).getName());






        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String array1= String.valueOf(MainActivity.responseList.get(position).getIngredients());
                String array2= String.valueOf(MainActivity.responseList.get(position).getSteps());
                int servings=MainActivity.responseList.get(position).getServings();



                Log.i("sffdfda",MainActivity.responseList.get(position).getName());



                Intent intent=new Intent(mContext,RecipList.class);
                intent.putExtra("arraylist2",array2);


                intent.putExtra("serv",servings);
              intent.putExtra("arraylist",  array1);
              intent.putExtra("title",MainActivity.responseList.get(position).getName());
                mContext.startActivity(intent);







            }
        });



    }



    @Override
    public int getItemCount() {
        return MainActivity.responseList.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textView);

        }
    }

}
