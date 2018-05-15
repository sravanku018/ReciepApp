package com.example.subramanyam.reciep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class VideoDesM extends AppCompatActivity {
 public String video;
 public String Des;
String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_des_m);
      video=getIntent().getStringExtra("videoUrl");

      Des=getIntent().getStringExtra("description");
      image=getIntent().getStringExtra("image");
        Log.i("Video",video);




 Bundle bundle=new Bundle();
 bundle.putString("videos",video);
 bundle.putString("description",Des);
 bundle.putString("image",image);
        VideoDes videoDes=new VideoDes();
 videoDes.setArguments(bundle);
        init(videoDes);

    }

    public void init(android.support.v4.app.Fragment fragment)
    {
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.videoL,fragment);
        fragmentTransaction.commit();
    }
}
