package com.hg.birdy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ZoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZoomFragment extends Fragment {

    int position ;
    BirdData birdData ;
    ImageView mainView, imageView_1, imageView_2, imageView_3 ;
    TextView tv_name, tv_name2, tv_name3, tv_desc, tv_website, tv_references, tv_habitat ;

    public ZoomFragment() {
        // Required empty public constructor
    }

    public ZoomFragment (int position, BirdData bdata){
        this.position = position ;
        this.birdData = bdata ;

    }


    // TODO: Rename and change types and number of parameters
    public static ZoomFragment newInstance(String param1, String param2) {
        ZoomFragment fragment = new ZoomFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zoom, container, false);
        mainView = view.findViewById(R.id.imageMain) ;
        // Thumb Nails
        imageView_1 = view.findViewById(R.id.imageTNail1) ;
        imageView_2 = view.findViewById(R.id.imageTNail2) ;
        imageView_3 = view.findViewById(R.id.imageTNail3) ;
        tv_name = view.findViewById(R.id.tv_zoom_name) ;
        tv_name2 = view.findViewById(R.id.tv_zoom_name2) ;
        tv_name3 = view.findViewById(R.id.tv_zoom_sciname) ;
        tv_desc = view.findViewById(R.id.tv_desc1) ;
        tv_website = view.findViewById(R.id.tv_website) ;
        tv_references = view.findViewById(R.id.tv_references) ;
        tv_habitat = view.findViewById(R.id.tv_habitat) ;


        mainView.setImageResource(getDrawableId(birdData.imageName.get(position).toString()));
        imageView_1.setImageResource(getDrawableId(birdData.imageName.get(position).toString()));
        imageView_2.setImageResource(getDrawableId(birdData.imageName2.get(position).toString()));
        imageView_3.setImageResource(getDrawableId(birdData.imageName3.get(position).toString()));
        tv_name.setText(birdData.birdNames.get(position)) ;
        tv_name2.setText(birdData.birdNames2.get(position)) ;
        tv_name3.setText(birdData.scientificName.get(position)) ;
        tv_desc.setText(birdData.description.get(position)) ;
        tv_website.setText(birdData.website.get(position)) ;
        tv_references.setText(birdData.references.get(position)) ;
        tv_habitat.setText(birdData.habitat.get(position));

        imageView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainView.setImageResource(getDrawableId(birdData.imageName.get(position).toString()));
            }
        });
        imageView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainView.setImageResource(getDrawableId(birdData.imageName2.get(position).toString()));
            }
        });
        imageView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainView.setImageResource(getDrawableId(birdData.imageName3.get(position).toString()));
            }
        });

        // website to open for more info
        tv_website.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(birdData.website.get(position)));
                startActivity(intent);
            } });

        //mainView.setImageResource(R.drawable.amakihi);
        return view ;
    }



    public int getDrawableId(String name){
        try {
            String nname = name.replace(".jpg","") ;
            Field fld = R.drawable.class.getField(nname);
            return fld.getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}