package com.example.subramanyam.reciep;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.subramanyam.reciep.widget.UpdateBakingService;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ingredients.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ingredients#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ingredients extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private OnFragmentInteractionListener mListener;

    public ingredients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ingredients.
     */
    // TODO: Rename and change types and number of parameters
    public static ingredients newInstance(String param1, String param2) {
        ingredients fragment = new ingredients();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_ingredients, container, false);



        RecyclerView recyclerView;





        recyclerView=(RecyclerView) view.findViewById(R.id.ingrediants);
        ingrediantsRecycler ingrediantsRecycler;



        ingrediantsRecycler=new ingrediantsRecycler(getActivity());
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(ingrediantsRecycler);


        final ArrayList<String> recipeIngrediantForWidgets=new ArrayList<>();
         for(int i=0;i<RecipList.ingredientsItems.size();i++)
         {
             String ingrediantName=RecipList.ingredientsItems.get(i).getIngredient();
             float quantity=RecipList.ingredientsItems.get(i).getQuantity();
             String measure=RecipList.ingredientsItems.get(i).getMeasure();

             recipeIngrediantForWidgets.add(ingrediantName + "\n " +quantity + "\n" +measure);
         }
        UpdateBakingService.startBakingService(this.getContext(),recipeIngrediantForWidgets);

       return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {

        } else {

        }
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
