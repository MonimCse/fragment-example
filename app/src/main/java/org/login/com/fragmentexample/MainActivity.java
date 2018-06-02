package org.login.com.fragmentexample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  HomeFragment.ISendPersonDetails{


    Button mBtnHome;
    Button mBtnDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnHome = findViewById(R.id.btn_home);
        mBtnDetails = findViewById(R.id.btn_details);
        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container,HomeFragment.newInstant(MainActivity.this));
                fragmentTransaction.commit();


            }
        });

        mBtnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container,new DetailsFragment());
                fragmentTransaction.commit();


            }
        });
    }

    @Override
    public void sendPersonDetails(Person person) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container,DetailsFragment.newInstant(person));
        fragmentTransaction.commit();

    }
}
