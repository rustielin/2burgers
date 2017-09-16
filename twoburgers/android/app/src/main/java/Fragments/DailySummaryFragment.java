package Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.rustie.twoburgers.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import Activities.MainActivity;
import Activities.NewPurchaseActivity;
import Adapters.CouldveAdapter;
import Classes.Couldve;
import Singletons.Utils;

/**
 * Created by rustie on 9/16/17.
 */

public class DailySummaryFragment extends Fragment {


    String url = "andy's butt";


    public static final String TAG = "DailySummary";

    View v;


    private Context context;

    private TextView mUsername;
    private TextView mEmail;
    private ImageView mProfPic;

    private SwipeRefreshLayout mSwipeRefreshLayout;


    private RequestQueue mRequestQueue;
    private JsonObjectRequest mJsonObjectRequest;
    private HashMap mParams;
    private JSONObject mJsonObject;

    ArrayList<Couldve> couldves;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = getActivity().getLayoutInflater().inflate(R.layout.content_main, null);


        final ListView listview = (ListView) v.findViewById(R.id.summary_list);
        couldves = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            couldves.add(new Couldve(i, "Joe"));
        }

        CouldveAdapter couldveAdapter = new CouldveAdapter(couldves, getContext());

        listview.setAdapter(couldveAdapter);


        ViewGroup headerViewBun = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.couldve_header, listview, false);
        ViewGroup headerViewBun2 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.couldve_footer, listview, false);


        listview.addFooterView(headerViewBun2);
        listview.addHeaderView(headerViewBun);


        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }

        setRepeatingAsyncTask();

        return v;
    }

    public void makeRequest() {
        // Request a JSON response
        mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, mJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "Response: " + response.toString());
                String combination = "";
                try {
                    combination += mJsonObject.getString("combination");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // set the display

                JSONArray array;

                // try to get everything
                try {
                    array  = response.getJSONArray("combinations");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject row = array.getJSONObject(i);
                        String str = row.getString("combination");
                        couldves.add(new Couldve(0, str));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error: " + error.getMessage());
                    }
                });
        mRequestQueue.add(mJsonObjectRequest);
    }

    public void refreshContent() {
        // make request
//        makeRequest();

        Log.d("Refresh", "REFRESH");

        mSwipeRefreshLayout.setRefreshing(false);
    }


    private void setRepeatingAsyncTask() {

        final Handler handler = new Handler();
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            makeRequest();
                        } catch (Exception e) {
                            // error, do something
                        }
                    }
                });
            }
        };

        timer.schedule(task, 0, 60*1000);  // interval of one minute

    }
}
