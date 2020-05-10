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


public class Hotels extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Tyan-Shan",
                "Services: Bar, Restaurant, Laundry full cycle, Suitable for children \n" +
                        " Price for 1 day: Econom-1000som, Standart-1500som, Luxury-3000som", "Jalal-Abad, Hotel Tyan-Shan \n" +
                "OPEN 24HOUR" , R.drawable.tyan_shan,
                "40.927138,-287.004042",
                "996772167128" ));
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