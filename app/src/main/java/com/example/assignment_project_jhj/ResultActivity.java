package com.example.assignment_project_jhj;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        setTheme(androidx.appcompat.R.style.Base_Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");


        Intent intent = getIntent();
        int voteResultArray[] = intent.getIntArrayExtra("VOTE_COUNT");
        String imageNameArray[] = intent.getStringArrayExtra("IMAGE_NAME_ARRAY");

        TextView textViewWinner = (TextView) findViewById(R.id.winner_TextView);
        ImageView imageViewWinner = (ImageView) findViewById(R.id.winner_ImageView);
        Button buttonReturn = (Button) findViewById(R.id.button_Return);

        Integer imageIdArray[] = {
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
                R.drawable.pic9 };
        int maxVoteImageIndex = 0;
        for(int i = 1; i < voteResultArray.length; ++i)
        {
            if(voteResultArray[maxVoteImageIndex] < voteResultArray[i])
            {
                maxVoteImageIndex = i;
            }
        }
        textViewWinner.setText(imageNameArray[maxVoteImageIndex]);
        imageViewWinner.setImageResource(imageIdArray[maxVoteImageIndex]);

        TextView textViewArray[] = new TextView[imageNameArray.length];
        RatingBar ratingBarArray[] = new RatingBar[imageNameArray.length];

        Integer textViewIdArray[] = {
                R.id.top_TextView001,
                R.id.top_TextView002,
                R.id.top_TextView003,
                R.id.middle_TextView004,
                R.id.middle_TextView005,
                R.id.middle_TextView006,
                R.id.bottom_TextView007,
                R.id.bottom_TextView008,
                R.id.bottom_TextView009 };

        Integer ratingBarIdArray[] = {
                R.id.ratingBar001,
                R.id.ratingBar002,
                R.id.ratingBar003,
                R.id.ratingBar004,
                R.id.ratingBar005,
                R.id.ratingBar006,
                R.id.ratingBar007,
                R.id.ratingBar008,
                R.id.ratingBar009 };

        for(int j = 0; j < voteResultArray.length; ++j)
        {
            textViewArray[j] =(TextView) findViewById(textViewIdArray[j]);
            ratingBarArray[j] = (RatingBar) findViewById(ratingBarIdArray[j]);
        }

        for(int k = 0; k < voteResultArray.length; ++k)
        {
            textViewArray[k].setText(imageNameArray[k]);
            ratingBarArray[k].setRating((float) voteResultArray[k]);
        }

        buttonReturn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}
