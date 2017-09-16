package Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rustie.twoburgers.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

import Classes.Couldve;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by rustie on 9/16/17.
 */

public class CouldveAdapter extends ArrayAdapter<Couldve> {

    private List<Couldve> mDataset;
    private Context mContext;
    private View v;

    public final String TAG = "CouldveAdapter";

    private int[] colors = {
            Color.parseColor("#00D318"),
            Color.parseColor("#884600"),
            Color.parseColor("#FF0000")
    };


    public class ViewHolder {

        public ViewHolder(View v) {

            mNumber = (TextView) v.findViewById(R.id.number);
            mThing = (TextView) v.findViewById(R.id.thing);
            mCardView = (CardView) v.findViewById(R.id.card_view);

        }

        private TextView mNumber;
        private TextView mThing;
        private CardView mCardView;

    }

    public CouldveAdapter(List<Couldve> mDataset, Context context) {
        super(context, R.layout.couldve_item, mDataset);
        this.mDataset = mDataset;
        this.mContext = context;
    }



    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Couldve getItem(int i) {
        return mDataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        Couldve couldve = getItem(i);

//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        v = inflater.inflate(R.layout.couldve_item, viewGroup, false);

        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.couldve_item, viewGroup, false);


        ViewHolder viewHolder = new ViewHolder(v);


        viewHolder.mNumber.setText("" + couldve.getNum());
        viewHolder.mThing.setText(couldve.getItem());

        Random random = new Random();
        int c = random.nextInt(3);
        viewHolder.mCardView.setBackgroundColor(colors[c]);
        return v;
    }
}
