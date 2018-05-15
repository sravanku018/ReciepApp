package com.example.subramanyam.reciep;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Receipe extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


   RecRece recRece;






    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_receipe, container, false);
        // Inflate the layout for this fragment

        RecyclerView recyclerView;

        recyclerView=(RecyclerView) view.findViewById(R.id.items);
        ingredients ingredients= new ingredients();










        recRece=new RecRece(getContext());
       RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());

       recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recRece);



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

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


