package a.sample.tambola;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random;
    TransparentText ranromNumber;
    TextView textView;
    TextView textViewList;
    FloatingActionButton imageButton;
    GridLayoutManager gridLayoutManager;
    HorizontalScrollView randomListParent;

    NumberGridAdapter adapter;

    ArrayList<Integer> mainArray;
    ArrayList<Integer> value;
    HashMap<Integer, Boolean> hashMap;
    TextToSpeech tts;

    boolean speechStatus = false;
    int k = 0, a = 0;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1925328674455685/5260081451");
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


        ranromNumber = (TransparentText) findViewById(R.id.random_number);
        textView = (TextView) findViewById(R.id.random_number2);
        textViewList = (TextView) findViewById(R.id.random_list);
        imageButton = (FloatingActionButton) findViewById(R.id.fab);
        randomListParent = (HorizontalScrollView) findViewById(R.id.random_list_parent);
        random = new Random();

        resetValues();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        assert mRecyclerView != null;
        mRecyclerView.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 6);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        registerForContextMenu(mRecyclerView);
        adapter = new NumberGridAdapter(mainArray, hashMap);
        mRecyclerView.setAdapter(adapter);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ranromNumber.setVisibility(View.VISIBLE);
                imageButton.setClickable(false);

                if (value.size() > a) {
                    k = 0;
                    imageButton.setImageResource(R.drawable.ic_media_play_dark);
                    timedRandomNumber();
                } else {
                    textView.setVisibility(View.INVISIBLE);
                    ranromNumber.setText(" Done!!! ");
                    imageButton.setImageResource(R.drawable.quantum_ic_replay_white_24);
                    resetValues();
                    adapter.reFill(hashMap);
                }
            }
        });

        tts=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onInit(int status) {

                if(status == TextToSpeech.SUCCESS){
                    int result=tts.setLanguage(Locale.US);
                    if(result==TextToSpeech.LANG_MISSING_DATA ||
                            result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("error", "This Language is not supported");
                    }
                    else{
                        speechStatus = true;
                    }
                }
                else
                    Log.e("error", "Initilization Failed!");
            }
        });

    }

    void resetValues() {

        a=0;
        value = new ArrayList<>();
        mainArray = new ArrayList<>();
        hashMap = new HashMap<>();
        textViewList.setText("");

        for (int i = 1; i <= 89; i++) {
            mainArray.add(i);
            hashMap.put(i, false);
        }

        value.addAll(mainArray);

        Collections.shuffle(value);


    }

    public void timedRandomNumber() {

        imageButton.setClickable(true);

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {

                ranromNumber.setText("");
                ranromNumber.setText(String.valueOf(random.nextInt(89)));

                textView.setText("");
                textView.setText(String.valueOf(random.nextInt(89)));

                if (k == 20) {
                    setOriginalValue();
                    adapter.reFill(hashMap);
                    adapter.notifyDataSetChanged();
                } else {
                    k++;
                    timedRandomNumber();
                }

            }
        }, 150);

    }

    @Override
    protected void onDestroy() {

        //Close the Text to Speech Library
        if(tts != null) {

            tts.stop();
            tts.shutdown();
            Log.d("TAG", "TTS Destroyed");
        }
        super.onDestroy();
    }
    
    public void setOriginalValue() {

        String temp = textViewList.getText()+String.valueOf(value.get(a)+"  ");
        textViewList.setText(temp);
        Log.d("TAG", textViewList.getText().toString()+"");
        randomListParent.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
        hashMap.put(value.get(a), true);
        textView.setText(String.valueOf(value.get(a)));
        ranromNumber.setVisibility(View.INVISIBLE);

        if (speechStatus)
        {
            try {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak(textView.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


        ++a;

        if ( a%10 == 0 ) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.reSet:
                new MaterialDialog.Builder(this)
                        .title("Are you sure ")
                        .content(" You want to restart the game!!!! ")
                        .positiveText(" Yes ")
                        .negativeText(" No ")
                        .autoDismiss(true)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                resetValues();
                                adapter.reFill(hashMap);
                                textView.setText("START");
                            }
                        })
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                            }
                        })
                        .show();


                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

        new MaterialDialog.Builder(this)
                .title("Are you sure ")
                .content(" You want to QUIT the game!!!! ")
                .positiveText(" Yes ")
                .negativeText(" No ")
                .autoDismiss(true)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if(tts != null) {
                            tts.stop();
                            tts.shutdown();
                            Log.d("TAG", "TTS Destroyed");
                        }
                        MainActivity.super.onBackPressed();
                        finish();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                    }
                })
                .show();
    }

}
