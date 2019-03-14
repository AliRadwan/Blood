package com.example.wekaradwan.blood.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wekaradwan.blood.R;

public class MainActivity extends AppCompatActivity {

    Button mButtonA,mButtonB,mButtonO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mButtonA = findViewById(R.id.buttonA);

        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valu = (String) mButtonA.getTag();

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("A",valu);
                startActivity(i);

            }
        });


        mButtonB = findViewById(R.id.buttonB);
        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = (String)mButtonB.getTag();

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("B",value);
                startActivity(i);

            }
        });



    }
}
