package test.mindorks.swipe.tinderswipe;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;

import test.mindorks.swipe.tinderswipe.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    static List<String> accepted = new ArrayList<>();
    static List<String> declined = new ArrayList<>();

    public static void acceptCoupon(MainActivity activity, String url){
        accepted.add(url);
        if(url.equals("https://s3.amazonaws.com/jcpsyfboltsession2017/JCP+Coupon+6.jpg")){
            activity.changeFragment("wallet");
        }
    }

    public static void declineCoupon(MainActivity activity, String url){
        declined.add(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragment("tinder");
        //changeFragment("wallet");
    }

    protected void changeFragment(String fragment) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction =  mFragmentManager.beginTransaction();
        Fragment frag;

        switch (fragment) {
            case "tinder":
                frag = TinderFragment.newInstance();

                mFragmentTransaction.replace(R.id.root_container, frag, "tinder");
                mFragmentTransaction.addToBackStack("tinder");
                break;

            case "wallet":
                frag = ItemFragment.newInstance();

                mFragmentTransaction.replace(R.id.root_container, frag, "wallet");
                mFragmentTransaction.addToBackStack("wallet");
                break;
        }

        mFragmentTransaction.commit();
    }

    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d("foo", item.toString());
    }

}
