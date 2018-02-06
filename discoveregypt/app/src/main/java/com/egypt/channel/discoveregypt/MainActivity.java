package com.egypt.channel.discoveregypt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView hCard1;
    CardView hCard2;
    CardView hCard3;
    CardView hCard4;
    CardView hCard5;
    CardView hCard6;
    CardView hCard7;
    CardView hCard8;
    CardView hCard9;
    CardView hCard10;

    CardView cCard1;
    CardView cCard2;
    CardView cCard3;
    CardView cCard4;
    CardView cCard5;
    CardView cCard6;

    CardView mCard1;
    CardView mCard2;
    CardView mCard3;
    CardView mCard4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);
        hCard1 = findViewById(R.id.ancient_one);
        hCard2 = findViewById(R.id.ancient_two);
        hCard3 = findViewById(R.id.ancient_three);
        hCard4 = findViewById(R.id.ancient_four);
        hCard5 = findViewById(R.id.ancient_five);
        hCard6 = findViewById(R.id.ancient_six);
        hCard7 = findViewById(R.id.ancient_seven);
        hCard8 = findViewById(R.id.ancient_eight);
        hCard9 = findViewById(R.id.ancient_nine);
        hCard10 = findViewById(R.id.ancient_ten);

        cCard1 = findViewById(R.id.coastal_first_card);
        cCard2 = findViewById(R.id.coastal_second_card);
        cCard3 = findViewById(R.id.coastal_third_card);
        cCard4 = findViewById(R.id.coastal_forth_card);
        cCard5 = findViewById(R.id.coastal_fifth_card);
        cCard6 = findViewById(R.id.coastal_sixth_card);

        hCard1.setOnClickListener(hListener);
        hCard2.setOnClickListener(hListener);
        hCard3.setOnClickListener(hListener);
        hCard4.setOnClickListener(hListener);
        hCard5.setOnClickListener(hListener);
        hCard6.setOnClickListener(hListener);
        hCard7.setOnClickListener(hListener);
        hCard8.setOnClickListener(hListener);
        hCard9.setOnClickListener(hListener);
        hCard10.setOnClickListener(hListener);


        cCard1.setOnClickListener(cListener);
        cCard2.setOnClickListener(cListener);
        cCard3.setOnClickListener(cListener);
        cCard4.setOnClickListener(cListener);
        cCard5.setOnClickListener(cListener);
        cCard6.setOnClickListener(cListener);

        mCard1 = findViewById(R.id.modern_one);
        mCard2 = findViewById(R.id.modern_two);
        mCard3 = findViewById(R.id.modern_three);
        mCard4 = findViewById(R.id.modern_four);

        mCard1.setOnClickListener(mListener);
        mCard2.setOnClickListener(mListener);
        mCard3.setOnClickListener(mListener);
        mCard4.setOnClickListener(mListener);

    }

    View.OnClickListener hListener = v -> {
        int index = 0;
        int id = v.getId();
        switch (id) {
            case R.id.ancient_one:
                break;
            case R.id.ancient_two:
                index = 1;
                break;
            case R.id.ancient_three:
                index = 2;
                break;
            case R.id.ancient_four:
                index = 3;
                break;
            case R.id.ancient_five:
                index = 4;
                break;
            case R.id.ancient_six:
                index = 5;
                break;
            case R.id.ancient_seven:
                index = 6;
                break;
            case R.id.ancient_eight:
                index = 7;
                break;
            case R.id.ancient_nine:
                index = 8;
                break;
            case R.id.ancient_ten:
                index = 9;
                break;
        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("index", index);
        intent.putExtra("Activity","Historical");
        startActivity(intent);
    };

    View.OnClickListener cListener = v -> {
        int index = 0;
        int id = v.getId();
        switch (id) {

            case R.id.coastal_first_card:
                break;
            case R.id.coastal_second_card:
                index = 1;
                break;
            case R.id.coastal_third_card:
                index = 2;
                break;
            case R.id.coastal_forth_card:
                index = 3;
                break;
            case R.id.coastal_fifth_card:
                index = 4;
                break;
            case R.id.coastal_sixth_card:
                index = 5;
                break;

        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("index", index);
        intent.putExtra("Activity","Coastal");
        startActivity(intent);

    }; View.OnClickListener mListener = v -> {
        int index = 0;
        int id = v.getId();
        switch (id) {

            case R.id.modern_one:
                break;
            case R.id.modern_two:
                index = 1;
                break;
            case R.id.modern_three:
                index = 2;
                break;
            case R.id.modern_four:
                index = 3;
                break;
        }

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("index", index);
        intent.putExtra("Activity","Modern");
        startActivity(intent);

    };
}
