package Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.rustie.twoburgers.R;

import org.json.JSONObject;

import java.util.ArrayList;

import Activities.MainActivity;
import Activities.NewPurchaseActivity;
import Adapters.CouldveAdapter;
import Classes.Couldve;
import Singletons.Utils;

/**
 * Created by rustie on 9/16/17.
 */

public class DailySummaryFragment extends Fragment {



    View v;


    private Context context;

    private TextView mUsername;
    private TextView mEmail;
    private ImageView mProfPic;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = getActivity().getLayoutInflater().inflate(R.layout.content_main, null);


        final ListView listview = (ListView) v.findViewById(R.id.summary_list);
        ArrayList<Couldve> couldves = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            couldves.add(new Couldve(i, "Joe"));
        }

        CouldveAdapter couldveAdapter = new CouldveAdapter(couldves, getContext());

        listview.setAdapter(couldveAdapter);


        ViewGroup headerViewBun = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.couldve_header, listview, false);
        ViewGroup headerViewBun2 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.couldve_footer, listview, false);




        listview.addFooterView(headerViewBun2);
        listview.addHeaderView(headerViewBun);

        return v;
    }
}
