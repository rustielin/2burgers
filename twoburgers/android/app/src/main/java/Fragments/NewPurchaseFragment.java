package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rustie.twoburgers.R;

/**
 * Created by rustie on 9/15/17.
 */

public class NewPurchaseFragment extends Fragment {

    private View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = getActivity().getLayoutInflater().inflate(R.layout.new_purchase_fragment_layout, null);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
