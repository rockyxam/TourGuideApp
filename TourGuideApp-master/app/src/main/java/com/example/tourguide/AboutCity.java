package com.example.tourguide;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class AboutCity extends Fragment {

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {

        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.

        }
    };
    public AboutCity(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Jalal-Abad",
                "Jalal-Abad (also spelled Dzhalal-Abad) is the administrative and economic centre of Jalal-Abad Region" +
                        " in southwestern Kyrgyzstan. Its area is 88 square kilometres (34 sq mi)," +
                        " and its resident population was 97,172 in 2009 and is officially estimated at 109,200 in January 2019." +
                        " It is situated at the north-eastern end of the Fergana valley along the Kögart River valley," +
                        " in the foothills of the Babash Ata mountains, very close to Uzbekistan border.",
                "Jalal-Abad",
                R.drawable.aboutcity1,
                "40.932294,-287.002562" ));
        WordAdapter adapter = new WordAdapter(getActivity(), words);
        ListView listView = (ListView) rootView.findViewById(R.id.list);


        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                TextView titleName = view.findViewById(R.id.place_name);
                RelativeLayout descriptionLayout= view.findViewById(R.id.expandable);
                if (word.isOpen) {
                    descriptionLayout.setVisibility(View.GONE);


                    word.isOpen = false;

                }else if (!word.isOpen) {
                    descriptionLayout.setVisibility(View.VISIBLE);

                    word.isOpen = true;
                }








            }
        });


        return rootView;
    }


}


