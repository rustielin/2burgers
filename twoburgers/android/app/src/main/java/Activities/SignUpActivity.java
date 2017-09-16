package Activities;

import android.support.v4.app.Fragment;

import Fragments.SignUpFragment;

/**
 * Created by rustie on 4/1/17.
 */

public class SignUpActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new SignUpFragment();
    }
}
