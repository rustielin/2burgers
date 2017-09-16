package Activities;

import android.support.v4.app.Fragment;

import Fragments.NewPurchaseFragment;

/**
 * Created by rustie on 9/15/17.
 */

public class NewPurchaseActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new NewPurchaseFragment();
    }
}
