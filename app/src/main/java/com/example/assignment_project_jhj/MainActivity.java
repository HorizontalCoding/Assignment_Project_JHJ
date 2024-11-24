package com.example.assignment_project_jhj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity
{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        setTheme(androidx.appcompat.R.style.Base_Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 인기 투표");

        final int VOTE_COUNT[] = new int[9];
        final ImageView IMAGEVIEW_ARRAY[] = new ImageView[9];

        Button buttonResult = (Button) findViewById(R.id.button_Result);

        for(int i = 0;  i < VOTE_COUNT.length; ++i)
        {
            VOTE_COUNT[i] = 0;
        }

        final Integer IMAGE_ID_ARRAY[] = {
                        R.id.top_ImageView001,
                        R.id.top_ImageView002,
                        R.id.top_ImageView003,
                        R.id.middle_ImageView004,
                        R.id.middle_ImageView005,
                        R.id.middle_ImageView006,
                        R.id.bottom_ImageView007,
                        R.id.bottom_ImageView008,
                        R.id.bottom_Image_View009 };

        final String IMAGE_NAME_ARRAY[] = {
                "독서하는 소녀",
                "꽃장식 모자 소녀",
                "부채를 든 소녀",
                "이레느깡 단 베르양",
                "잠자는 소녀",
                "테라스의 두 자매",
                "피아노 레슨",
                "피아노 앞의 소녀들",
                "해변에서" };

        for(int j = 0; j < IMAGE_ID_ARRAY.length; ++j)
        {
            final int INDEX;
            INDEX = j;
            IMAGEVIEW_ARRAY[INDEX] = (ImageView) findViewById(IMAGE_ID_ARRAY[INDEX]);
            IMAGEVIEW_ARRAY[INDEX].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    ++VOTE_COUNT[INDEX];

                    Toast.makeText(getApplicationContext(),
                            IMAGE_NAME_ARRAY[INDEX] + ": 총 " + VOTE_COUNT[INDEX] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        buttonResult.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VOTE_COUNT", VOTE_COUNT);
                intent.putExtra("IMAGE_NAME_ARRAY", IMAGE_NAME_ARRAY);
                startActivity(intent);
            }
        });
    }
}
