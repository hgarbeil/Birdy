package com.hg.birdy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class List_Adapter extends RecyclerView.Adapter<List_Adapter.MyViewHolder> {

    private ArrayList birdnames, birdnames2, imagenames ;
    private final RecyclerViewInterface recyclerViewInterface ;


//    public List_Adapter(String[] birdnames) {
//        this.birdnames = birdnames;
//    }

    public List_Adapter(ArrayList name, ArrayList name2, ArrayList imageNames, RecyclerViewInterface recyclerViewInterface) {
        this.birdnames = name ;
        this.birdnames2 = name2 ;
        this.imagenames = imageNames ;
        this.recyclerViewInterface = recyclerViewInterface ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adapter,parent,false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String bname = imagenames.get(position).toString().replace(".jpg","") ;
        holder.textView.setText(birdnames.get(position).toString()) ;
        int idval = getDrawableId(bname) ;
        if (idval > 0)
            holder.imageView.setImageResource(idval);
        holder.textName2.setText(birdnames2.get(position).toString());

    }



    @Override
    public int getItemCount() {
        int nbirds = birdnames.size() ;
        return birdnames.size();
    }

    public int getDrawableId(String name){
        try {
            Field fld = R.drawable.class.getField(name);
            return fld.getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView, textName2 ;
        ImageView imageView ;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView) ;
            textName2 = itemView.findViewById(R.id.tv_name2) ;
            imageView  = itemView.findViewById(R.id.imageView) ;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition() ;
                        recyclerViewInterface.onItemClick(pos);

                    }

                }
            });
        }
    }
}
