package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rustie.twoburgers.R;

import Activities.MainActivity;
import Adapters.TabbedAdapter;

/**
 * Created by rustie on 9/16/17.
 */

public class TabFragment extends Fragment {

    View v;

    FragmentManager fragmentManager;

    public TabFragment() {

    }

    public TabFragment(FragmentManager fragmentManager) {
                fragmentManager = fragmentManager;
    }

//    public TabFragment(FragmentManager fm) {
//
//        fragmentManager = fm;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tab_layout, container, false);


        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new TabbedAdapter(fragmentManager,
                getContext()));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return v;


    }
}
