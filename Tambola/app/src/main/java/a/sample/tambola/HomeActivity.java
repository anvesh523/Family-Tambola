package a.sample.tambola;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.crash.FirebaseCrash;

public class HomeActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
*/
        setContentView(R.layout.activity_home);
        MobileAds.initialize(this, "ca-app-pub-1925328674455685~6237287054");  // ca-app-pub-1925328674455685~6237287054 - Tambola
        // ca-app-pub-3940256099942544/6300978111  - tEST


// TODO: Add the adView to your view hierarchy.
        /*AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-1925328674455685~6237287054");*/


        mAdView = (AdView) findViewById(R.id.adView);
        //mAdView.setAdSize(AdSize.BANNER);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        TransparentText organizer = (TransparentText) findViewById(R.id.organizer);
        TransparentText participator = (TransparentText) findViewById(R.id.participator);
        FloatingActionButton share = (FloatingActionButton) findViewById(R.id.fab_share);

        LinearLayout _org = (LinearLayout) findViewById(R.id._organizer);
        LinearLayout _pat = (LinearLayout) findViewById(R.id._participator);

        organizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        _org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        participator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });

        _pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.invitation_title);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out, A simple tambola game " +   //Hey, Please fill my slam
                        "https://sz477.app.goo.gl/eaFH" + "\n");  //https://z53v8.app.goo.gl/rniX
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, " Choose an app "));

            }
        });

    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

}
