package com.example.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0,0, words );
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView placeView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        placeView.setText(currentWord.getTitleOFinformation());


        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        descriptionTextView.setText(currentWord.getIformation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentWord.getmImageResId());
        TextView onClickLocation = listItemView.findViewById(R.id.onClick_location);
        SpannableString locationSpannable = new SpannableString("Location: " + currentWord.getmLocation());
        locationSpannable.setSpan(new UnderlineSpan(), 10, locationSpannable.length(), 0);
        onClickLocation.setText(locationSpannable);
        onClickLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentWord.getmlocationForParsing()));
                getContext().startActivity(mapIntent);
            }
        });
        if (currentWord.getmPhoneNumber() != null) {
            TextView phoneNumberTextView = listItemView.findViewById(R.id.call_textView);
            final String phoneNumber = currentWord.getmPhoneNumber();
            SpannableString numberSpannable = new SpannableString("+" + phoneNumber.substring(4, 7) + " " + phoneNumber.substring(7, 10) + " " + phoneNumber.substring(10, 13) + " " + phoneNumber.substring(13));
            numberSpannable.setSpan(new UnderlineSpan(), 0, numberSpannable.length(), 0);
            phoneNumberTextView.setText(numberSpannable);
            phoneNumberTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                    getContext().startActivity(callIntent);
                }
            });
        }

        return listItemView;
    }
}
