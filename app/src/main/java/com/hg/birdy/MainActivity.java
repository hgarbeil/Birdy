package com.hg.birdy;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity  {

    Button btn_backyard, btn_forest, btn_sea, btn_dbase, btn_ponds ;
    FragmentManager fm ;
    DBFragment dbFragment ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // get button ids
        btn_dbase = findViewById(R.id.btn_dbase) ;
        btn_backyard = findViewById(R.id.btn_byard) ;
        btn_forest =  findViewById(R.id.btn_forest) ;
        btn_sea = findViewById(R.id.btn_sea) ;
        btn_ponds = findViewById(R.id.btn_ponds) ;
        setButtonActive(btn_backyard);
        // Fragment manager
        fm = getSupportFragmentManager() ;


        fm.beginTransaction().add(R.id.fragmentContainerView2, new RecyclerFragment(0)).commit() ;

        btn_dbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace current fragment with the dbase fragment
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, new DBFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                setButtonActive (btn_dbase) ;

            }
        });

        btn_backyard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, new RecyclerFragment(0));
                transaction.addToBackStack(null);
                transaction.commit();
                setButtonActive (btn_backyard) ;

            }
        });
        btn_forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, new RecyclerFragment(1));
                transaction.addToBackStack(null);
                transaction.commit();
                setButtonActive (btn_forest) ;

            }
        });
        btn_sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, new RecyclerFragment(2));
                transaction.addToBackStack(null);
                transaction.commit();
                setButtonActive (btn_sea) ;

            }
        });
        btn_ponds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentContainerView2, new RecyclerFragment(3));
                transaction.addToBackStack(null);
                transaction.commit();
                setButtonActive (btn_ponds) ;

            }
        });
    }

    public void setButtonActive (Button btn){
        btn_forest.setBackgroundColor(Color.rgb(100,170,40)) ;
        btn_backyard.setBackgroundColor(Color.rgb(100,170,40)) ;
        btn_ponds.setBackgroundColor(Color.rgb(100,170,40)) ;
        btn_sea.setBackgroundColor(Color.rgb(100,170,40)) ;
        btn_dbase.setBackgroundColor(Color.rgb(100,170,40)) ;
        try {
            btn.setBackgroundColor(Color.rgb(90,90,60));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }



}