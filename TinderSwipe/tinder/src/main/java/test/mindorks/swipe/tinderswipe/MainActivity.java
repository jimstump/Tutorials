package test.mindorks.swipe.tinderswipe;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    static List<String> accepted;
    static List<String> declined;

    public static void acceptCoupon(String url){
        accepted.add(url);
    }

    public static void declineCoupon(String url){
        declined.add(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragment("tinder");
    }

    protected void changeFragment(String fragment) {
        switch (fragment) {
            case "tinder":

                FragmentManager mFragmentManager = getSupportFragmentManager();
                FragmentTransaction mFragmentTransaction =  mFragmentManager.beginTransaction();

                Fragment frag = TinderFragment.newInstance();

                mFragmentTransaction.replace(R.id.root_container, frag, "tinder");
                mFragmentTransaction.addToBackStack("tinder");
                mFragmentTransaction.commit();
                break;
        }
    }

}
