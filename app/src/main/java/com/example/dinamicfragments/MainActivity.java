package com.example.dinamicfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button next;
    Button skip;
    int number = R.id.fr1;

    Fragment f1;
    Fragment f2;
    Fragment f3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = findViewById(R.id.next_btn);
        skip = findViewById(R.id.skip_btn);

        f1 = new FirstFragment();
        f2 = new SecondFragment();
        f3 = new ThirdFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, f1).commit();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f3).commit();
            }
        });
//        fragmentTrans.add(R.id.fr1, f1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTrans = getSupportFragmentManager().beginTransaction();
                if (savedInstanceState == null) {
                    switch (number) {
                        case R.id.fr1:
                            number = R.id.fr2;
                            fragmentTrans.replace(R.id.fr1, f2).commit();
                            break;
                        case R.id.fr2:
                            number = R.id.fr3;
                            fragmentTrans.replace(R.id.fr2, f3).commit();
                            break;
                    }
                }
            }
        });

    }
}