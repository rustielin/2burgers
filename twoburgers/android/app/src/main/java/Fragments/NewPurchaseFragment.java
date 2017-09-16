package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.rustie.twoburgers.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;

import Activities.MainActivity;

/**
 * Created by rustie on 9/15/17.
 */

public class NewPurchaseFragment extends Fragment {


    public static final String TAG = "NewPurchaseFragment";
    private View v;

    private AppCompatSpinner mSpinner;
    private EditText mPrice;
    private ImageButton mSubmit;
    private TextView mCouldve;

    // request stuff
    private JsonObjectRequest mJsonObjectRequest;
    private RequestQueue mRequestQueue;
    private HashMap mParams;
    private JSONObject mJsonObject;

    private String url = "and's butt";


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
        mSubmit = (ImageButton) v.findViewById(R.id.submit);
        mCouldve = (TextView) v.findViewById(R.id.couldve);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                makeRequest("" + mPrice.getText(), "" + mSpinner.getSelectedItem());

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });




        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }

        return v;
    }

    public void makeRequest(String price, String category) {
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
                mCouldve.setText(combination);


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

    @Override
    public void onStart() {
        super.onStart();
    }
}
