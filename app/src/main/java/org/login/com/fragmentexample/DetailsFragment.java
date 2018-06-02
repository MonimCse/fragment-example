package org.login.com.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {


    TextView mTvDetails;
static  Person mPerson;
    public static DetailsFragment newInstant(Person person) {
        DetailsFragment detailsFragment = new DetailsFragment();
        mPerson = person;
        return detailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        init(view);
        return view;
    }

    public  void init(View view)
    {
        mTvDetails = view.findViewById(R.id.tv_details);
        if(mPerson!=null)
        {
            mTvDetails.setText("Name: "+mPerson.getName()+"\nAge: "+String.valueOf(mPerson.getAge()));

        }
    }

}
