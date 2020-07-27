package vigya.digipodium.uibasics;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FirstFragment extends Fragment {

    private int number;
    private int textSize=15;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Switch swTheme= view.findViewById(R.id.swTheme);
        final TextInputLayout textInput=view.findViewById(R.id.textInput);
        final TextInputEditText text=view.findViewById(R.id.text);
        RadioGroup rbColor=view.findViewById(R.id.rbColor);
        SeekBar sbCon=view.findViewById(R.id.sbCon);
        FloatingActionButton fbAdd=view.findViewById(R.id.fbAdd);
        SeekBar sbDis=view.findViewById(R.id.sbDis);
        RatingBar rbStar=view.findViewById(R.id.rbStar);
        final CardView cardView=view.findViewById(R.id.cardView);
        final TextView textCard=view.findViewById(R.id.textCard);
        ProgressBar pBar=view.findViewById(R.id.pBar);
        CheckBox cbAgree=view.findViewById(R.id.cbAgree);

        swTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    cardView.setCardBackgroundColor(Color.parseColor("#121212"));
                    textCard.setTextColor(Color.WHITE);
                }
                else{
                    cardView.setCardBackgroundColor(Color.WHITE);
                    textCard.setTextColor(Color.BLACK);
                }
            }
        });

        sbDis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textCard.setTextSize(progress+textSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rbColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbBlue:
                        cardView.setCardBackgroundColor(Color.parseColor("#00328e"));
                        break;
                    case R.id.rbRed:
                        cardView.setCardBackgroundColor(Color.parseColor("#bf1a17"));
                        break;
                    case R.id.rbGreen:
                        cardView.setCardBackgroundColor(Color.parseColor("#428e00"));
                        break;
                }
            }
        });

        sbCon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text.setText(String.valueOf(progress+ textSize));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rbStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textCard.setText("You gave a rating of "+rating);
            }
        });

        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = text.getText().toString();
                textCard.setText("Your Name: "+name);
            }
        });


    }
}