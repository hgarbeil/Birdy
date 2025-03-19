package com.hg.birdy;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BirdData {

    String[] filenames = {"backyard.txt", "forest.txt", "Sea.txt", "ponds.txt"};
    AssetManager assetManager ;
    Context context ;
    String birdFile ;
    List<String> birdNames = new ArrayList<String>();
    List<String> birdNames2 = new ArrayList<String>();
    List<String> scientificName = new ArrayList<String>();
    List<String> imageName = new ArrayList<String>();
    List<String> imageName2 = new ArrayList<String>();
    List<String> imageName3 = new ArrayList<String>();

    List<String> description =  new ArrayList<String>();
    List<String> website =  new ArrayList<String>();
    List<String> habitat =  new ArrayList<String>();
    List<String> references = new ArrayList<String>();

    public BirdData (Context ctx){
       context = ctx ;
    }

    public void readData (int type){
        String [] fields ;

        String dataFile = filenames[type] ;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(dataFile), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                fields = mLine.split(";") ;
                birdNames.add(fields[0]) ;
                birdNames2.add(fields[1]) ;
                scientificName.add(fields[2]) ;
                description.add(fields[5]) ;
                habitat.add(fields[10]) ;
                String ref = "References : "+ fields[12] +"\nPhotos : "+fields[13]+", "+ fields[14]+", "+fields[15] ;
                references.add (ref) ;
                imageName.add(fields[6].trim()) ;
                imageName2.add(fields[7].trim()) ;
                imageName3.add(fields[8].trim()) ;
                if (fields.length> 11)
                    website.add(fields[11].trim());
                else
                    website.add("") ;

            }
        } catch (IOException e) {
            //log the exception
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }




    }


}
