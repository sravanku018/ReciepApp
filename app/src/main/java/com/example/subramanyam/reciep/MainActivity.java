package com.example.subramanyam.reciep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    static public ArrayList<String> food;
    ArrayList<String> ingre;
    public static List<Response> responseList;
    RecRece recRece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        food = new ArrayList<>();
        try {
            InputStream inputStream = getAssets().open("baking.json");
            String jsonString = readJsonFile(inputStream);
            Gson gson = new Gson();
            responseList = Arrays.asList(gson.fromJson(jsonString, Response[].class));
            Log.i("lists", responseList.toString());

            String list1 = String.valueOf(responseList);


            Bundle bundle = new Bundle();
            bundle.putSerializable("list1", list1);

            Receipe receipe = new Receipe();
            init(receipe);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private String readJsonFile(InputStream inputStream) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte bufferByte[] = new byte[1024];
        int length;
        try {
            while ((length = inputStream.read(bufferByte)) != -1) {
                outputStream.write(bufferByte, 0, length);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }


    public void init(android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FrameL, fragment);
        fragmentTransaction.commit();
    }


}