package com.example.kot.englishsynonyms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Kot Kot on 22.04.2017.
 */

public class Fragment2 extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View myRootView = inflater.inflate(R.layout.fragment2, container, false);

        Button myButtonVariant1 = (Button) myRootView.findViewById(R.id.buttonVariant1);
        Button myButtonVariant2 = (Button) myRootView.findViewById(R.id.buttonVariant2);
        Button myButtonVariant3 = (Button) myRootView.findViewById(R.id.buttonVariant3);
        Button myButtonVariant4 = (Button) myRootView.findViewById(R.id.buttonVariant4);

        myButtonVariant1.setOnClickListener(this);
        myButtonVariant2.setOnClickListener(this);
        myButtonVariant3.setOnClickListener(this);
        myButtonVariant4.setOnClickListener(this);

        return myRootView;


    }

    @Override
    public void onClick(View v) {
        int buttonIndex = translateIdToIndex(v.getId());
        Toast.makeText(getActivity(), String.valueOf(buttonIndex), Toast.LENGTH_SHORT).show();

    }

    int translateIdToIndex(int id){
        int index = -1;
        switch (id){
            case R.id.buttonVariant1:
                index = 1;
                break;
            case R.id.buttonVariant2:
                index = 2;
                break;
            case R.id.buttonVariant3:
                index = 3;
                break;
            case R.id.buttonVariant4:
                index = 4;
                break;

        }
        return index;
    }

    public interface OnSelectedButtonListener{void onButtonSelected(int ButtonIndex);



    }
}
