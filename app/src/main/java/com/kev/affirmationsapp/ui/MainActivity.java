package com.kev.affirmationsapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kev.affirmationsapp.R;
import com.kev.affirmationsapp.ui.data.FetchData;
import com.thekhaeng.pushdownanim.PushDown;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class MainActivity extends AppCompatActivity {

    Button fetchButton;
public static     TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchButton = findViewById(R.id.button);
        data = findViewById(R.id.affirmationTv);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FetchData process = new FetchData();
                process.execute();

            }
        });

//        //push down animations https://android-arsenal.com/details/1/6821
//
//        PushDownAnim.setPushDownAnimTo(fetchButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Fetching Message", Toast.LENGTH_SHORT).show();
//                FetchData process = new FetchData();
//                process.execute();
//
//            }
//        });
//
//    }
    }
}