package com.example.subramanyam.reciep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class RecipList extends AppCompatActivity {
    int pos, position;
    String array1, getArray, title;
    public static List<IngredientsItem> ingredientsItems;
    public static List<StepsItem> stepsItems;
    List<Response> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recip_list);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        getArray = getIntent().getStringExtra("arraylist");
        array1 = getIntent().getStringExtra("arraylist2");
        title = getIntent().getStringExtra("title");


        Gson gson = new Gson();


        ingredientsItems = Arrays.asList(gson.fromJson(getArray, IngredientsItem[].class));
        stepsItems = Arrays.asList(gson.fromJson(array1, StepsItem[].class));



        Log.i("fgdggf", String.valueOf(stepsItems));
        Bundle bundle = new Bundle();
        bundle.putSerializable("ingrediantList", (Serializable) ingredientsItems);


        StepDescription stepDescription = new StepDescription();
        ingredients ingredients = new ingredients();
        fragmentTransaction.replace(R.id.stepsList, stepDescription);
        fragmentTransaction.replace(R.id.ingrediantsList, ingredients);
        fragmentTransaction.commit();


    }
}
