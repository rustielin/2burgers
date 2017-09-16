package Activities;

import android.support.v4.app.Fragment;

import Fragments.SignInFragment;


/**
 * Created by rustie on 9/15/17.
 */

public class SignInActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new SignInFragment();
    }
}
