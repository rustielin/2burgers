package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rustie.twoburgers.R;

import Activities.MainActivity;

/**
 * Created by rustie on 9/15/17.
 */

public class NewPurchaseFragment extends Fragment {

    private View v;

    private AppCompatSpinner mSpinner;
    private EditText mPrice;
    private AppCompatButton mSubmit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = getActivity().getLayoutInflater().inflate(R.layout.new_purchase_fragment_layout, null);

        mSpinner = (AppCompatSpinner) v.findViewById(R.id.category_spinner);
        mPrice = (EditText) v.findViewById(R.id.price);
        mSubmit = (AppCompatButton) v.findViewById(R.id.submit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });



        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
