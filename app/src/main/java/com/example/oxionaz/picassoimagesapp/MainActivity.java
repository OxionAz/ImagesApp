package com.example.oxionaz.picassoimagesapp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private static List<String> imagesList = new ArrayList<>(10);

    static {
        for (int i = 65; i > 35; i--){
            imagesList.add("http://www.kartinki24.ru/uploads/gallery/comthumb/19/kartinki24_ru_animals_2"+i+".jpg");
        }
    }

    @ViewById
    RecyclerView images_list;

    @AfterViews
    void ready(){
        ImageAdapter imageAdapter = new ImageAdapter(this, imagesList);
        if (images_list != null){
            images_list.setLayoutManager(new GridLayoutManager(this, 3));
            images_list.setAdapter(imageAdapter);
        }
    }
}
