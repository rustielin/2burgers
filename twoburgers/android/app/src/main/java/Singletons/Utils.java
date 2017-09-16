package Singletons;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Classes.User;


public class Utils {


    public static DatabaseReference getDB() {
        return FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseAuth getUser() {
        return FirebaseAuth.getInstance();
    }



    public static Snackbar colorInfoSnackbar(View view, String message, int textColor, int duration) {

        Snackbar snackbar = Snackbar
                .make(view,
                        message,
                        duration);

        TextView snackText = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        snackText.setTextColor(textColor);

        return snackbar;
    }

}
