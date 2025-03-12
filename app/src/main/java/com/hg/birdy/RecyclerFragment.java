package com.hg.birdy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager ;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RecyclerFragment extends Fragment implements RecyclerViewInterface {

    BirdData birdData ;
    int dataType = 0 ;
    String[] birdnames = {"Red winged blackbird", "Koleas", "Pueo","White Rumped Shama"} ;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    public RecyclerFragment (int type) {
        this.dataType = type ;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_recycler, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        birdData = new BirdData(getContext()) ;
        birdData.readData(dataType);

        recyclerView.setAdapter(new List_Adapter((ArrayList) birdData.birdNames,
                (ArrayList) birdData.birdNames2, (ArrayList) birdData.imageName, this));
        return view;
    }

    @Override
    public void onItemClick(int position) {

        ZoomFragment zoomFragment = new ZoomFragment(position, birdData) ;
        FragmentManager fm = getParentFragmentManager() ;
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentContainerView2, zoomFragment);
        transaction.addToBackStack("RecyclerFragment");
        transaction.commit();



    }


}