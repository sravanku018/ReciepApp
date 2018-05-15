package com.example.subramanyam.reciep;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;


public class VideoDes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;

    public VideoDes() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        StepsItem stepsItem=null;

        // / Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_video_des, container, false);

        VideoView  videoView=view.findViewById(R.id.videoView2);


        String video= this.getArguments().getString("videos");
        Log.i("videos",video);


        videoView.setVideoURI(Uri.parse(video));
        videoView.getDuration();
        videoView.setMediaController(new MediaController(getContext()));
        videoView.start();
        videoView.getDuration();

        String image=this.getArguments().getString("image");
        ImageView imageView=new ImageView(this.getContext());
        if(image!=null&& image.isEmpty())
        {
           imageView.setImageResource(R.drawable.ic_launcher_background);


        }else {
            Picasso.with(getContext()).load(image).into(imageView);
        }






        TextView textView=view.findViewById(R.id.itemDescription);

        String description=this.getArguments().getString("description");
        textView.setText(description);



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
