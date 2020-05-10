package com.example.tourguide;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class PlacesToSee extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Baichechekei",
                "There sells the most delicious ice cream" +
                " that I have eaten in my entire life, you car serch from whole word such ice cream but " +
                "unfortunatelly you catn't, because this " +
                "ice cream only in Baichechekei", "Jalal-Abad, Baichechekei", R.drawable.baichechekei,
                "40.938617,-287.005790",
                "996551664466" ));
        WordAdapter adapter = new WordAdapter(getActivity(), words);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                TextView titleName = view.findViewById(R.id.place_name);
                RelativeLayout descriptionLayout= view.findViewById(R.id.expandable);
                TextView callText= view.findViewById(R.id.call_textView);
                ImageView callImage= view.findViewById(R.id.call_imageView);
                if (word.isOpen) {
                    descriptionLayout.setVisibility(View.GONE);


                    word.isOpen = false;

                }else if (!word.isOpen) {
                    descriptionLayout.setVisibility(View.VISIBLE);
                    callText.setVisibility(View.VISIBLE);
                    callImage.setVisibility(View.VISIBLE);


                    word.isOpen = true;
                }








            }
        });


        return rootView;
    }
}