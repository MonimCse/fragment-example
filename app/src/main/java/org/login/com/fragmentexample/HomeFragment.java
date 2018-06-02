package org.login.com.fragmentexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class HomeFragment extends Fragment {

    EditText mEdtName;
    EditText mEdtAge;
    Button mBtnSubmit;


    static ISendPersonDetails mISendPersonDetails;

    @SuppressLint("ValidFragment")
    private  HomeFragment() {

    }

    public static HomeFragment newInstant(ISendPersonDetails iSendPersonDetails) {
        HomeFragment homeFragment = new HomeFragment();
        mISendPersonDetails = iSendPersonDetails;
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        init(view);
        return view;
    }

    public void init(View view) {
        mEdtName = view.findViewById(R.id.edt_name);
        mEdtAge = view.findViewById(R.id.edt_age);
        mBtnSubmit = view.findViewById(R.id.btn_submit);



        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setName(mEdtName.getText().toString());
                person.setAge(Integer.parseInt(mEdtAge.getText().toString()));
                mISendPersonDetails.sendPersonDetails(person);
            }
        });
    }

    interface ISendPersonDetails{
        void sendPersonDetails(Person person);
    }

}
