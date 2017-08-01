package a.sample.tambola;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Set<Integer> encounteredNumbers;
    Random random;
    TextToSpeech tts;
    boolean speechStatus = false;
    ArrayList<String> arrayListOne;
    ArrayList<String> arrayListTwo;
    ArrayList<String> arrayListThree;
    ArrayList<String> arrayListTotal;

    ArrayList<Integer> randomVal;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;

    Boolean tv1;
    Boolean tv2;
    Boolean tv3;
    Boolean tv4;
    Boolean tv5;
    Boolean tv6;
    Boolean tv7;
    Boolean tv8;
    Boolean tv9;
    Boolean tv10;
    Boolean tv11;
    Boolean tv12;
    Boolean tv13;
    Boolean tv14;
    Boolean tv15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        random = new Random();

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);

        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);

        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView14 = (TextView) findViewById(R.id.textView14);
        textView15 = (TextView) findViewById(R.id.textView15);

        textView1.setOnClickListener(this);

        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        textView9.setOnClickListener(this);
        textView10.setOnClickListener(this);
        textView11.setOnClickListener(this);
        textView12.setOnClickListener(this);
        textView13.setOnClickListener(this);
        textView14.setOnClickListener(this);
        textView15.setOnClickListener(this);

        refresh();

        tts = new TextToSpeech(Main2Activity.this, new TextToSpeech.OnInitListener() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onInit(int status) {
                // TODO Auto-generated method stub
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA ||
                            result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("error", "This Language is not supported");
                    } else {
                        speechStatus = true;
                    }
                } else
                    Log.e("error", "Initilization Failed!");
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.textView1:
                if (tv1) {
                    textView1.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView1.getText().toString());
                    arrayListOne.remove(textView1.getText().toString());
                    checkResults();
                    tv1 = false;
                } else {
                    textView1.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView1.getText().toString());
                    arrayListOne.add(textView1.getText().toString());
                    checkResults();
                    tv1 = true;
                }
                break;
            case R.id.textView2:
                if (tv2) {
                    textView2.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView2.getText().toString());
                    arrayListOne.remove(textView2.getText().toString());
                    checkResults();
                    tv2 = false;
                } else {
                    textView2.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView2.getText().toString());
                    arrayListOne.add(textView2.getText().toString());
                    checkResults();
                    tv2 = true;
                }
                break;
            case R.id.textView3:
                if (tv3) {
                    textView3.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView3.getText().toString());
                    arrayListOne.remove(textView3.getText().toString());
                    checkResults();
                    tv3 = false;
                } else {
                    textView3.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView3.getText().toString());
                    arrayListOne.add(textView3.getText().toString());
                    checkResults();
                    tv3 = true;
                }
                break;
            case R.id.textView4:
                if (tv4) {
                    textView4.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView4.getText().toString());
                    arrayListOne.remove(textView4.getText().toString());
                    checkResults();
                    tv4 = false;
                } else {
                    textView4.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView4.getText().toString());
                    arrayListOne.add(textView4.getText().toString());
                    checkResults();
                    tv4 = true;
                }
                break;
            case R.id.textView5:
                if (tv5) {
                    textView5.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView5.getText().toString());
                    arrayListOne.remove(textView5.getText().toString());
                    checkResults();
                    tv5 = false;
                } else {
                    textView5.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView5.getText().toString());
                    arrayListOne.add(textView5.getText().toString());
                    checkResults();
                    tv5 = true;
                }
                break;

            case R.id.textView6:
                if (tv6) {
                    textView6.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView6.getText().toString());
                    arrayListTwo.remove(textView6.getText().toString());
                    checkResults();
                    tv6 = false;
                } else {
                    textView6.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView6.getText().toString());
                    arrayListTwo.add(textView6.getText().toString());
                    checkResults();
                    tv6 = true;
                }
                break;
            case R.id.textView7:
                if (tv7) {
                    textView7.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView7.getText().toString());
                    arrayListTwo.remove(textView7.getText().toString());
                    checkResults();
                    tv7 = false;
                } else {
                    textView7.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView7.getText().toString());
                    arrayListTwo.add(textView7.getText().toString());
                    checkResults();
                    tv7 = true;
                }
                break;
            case R.id.textView8:
                if (tv8) {
                    textView8.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView8.getText().toString());
                    arrayListTwo.remove(textView8.getText().toString());
                    checkResults();
                    tv8 = false;
                } else {
                    textView8.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView8.getText().toString());
                    arrayListTwo.add(textView8.getText().toString());
                    checkResults();
                    tv8 = true;
                }
                break;
            case R.id.textView9:
                if (tv9) {
                    textView9.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView9.getText().toString());
                    arrayListTwo.remove(textView9.getText().toString());
                    checkResults();
                    tv9 = false;
                } else {
                    textView9.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView9.getText().toString());
                    arrayListTwo.add(textView9.getText().toString());
                    checkResults();
                    tv9 = true;
                }
                break;
            case R.id.textView10:
                if (tv10) {
                    textView10.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView10.getText().toString());
                    arrayListTwo.remove(textView10.getText().toString());
                    checkResults();
                    tv10 = false;
                } else {
                    textView10.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView10.getText().toString());
                    arrayListTwo.add(textView10.getText().toString());
                    checkResults();
                    tv10 = true;
                }
                break;

            case R.id.textView11:
                if (tv11) {
                    textView11.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView11.getText().toString());
                    arrayListThree.remove(textView11.getText().toString());
                    checkResults();
                    tv11 = false;
                } else {
                    textView11.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView11.getText().toString());
                    arrayListThree.add(textView11.getText().toString());
                    checkResults();
                    tv11 = true;
                }
                break;
            case R.id.textView12:
                if (tv12) {
                    textView12.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView12.getText().toString());
                    arrayListThree.remove(textView12.getText().toString());
                    checkResults();
                    tv12 = false;
                } else {
                    textView12.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView12.getText().toString());
                    arrayListThree.add(textView12.getText().toString());
                    checkResults();
                    tv12 = true;
                }
                break;
            case R.id.textView13:
                if (tv13) {
                    textView13.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView13.getText().toString());
                    arrayListThree.remove(textView13.getText().toString());
                    checkResults();
                    tv13 = false;
                } else {
                    textView13.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView13.getText().toString());
                    arrayListThree.add(textView13.getText().toString());
                    checkResults();
                    tv13 = true;
                }
                break;
            case R.id.textView14:
                if (tv14) {
                    textView14.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView14.getText().toString());
                    arrayListThree.remove(textView14.getText().toString());
                    checkResults();
                    tv14 = false;
                } else {
                    textView14.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView14.getText().toString());
                    arrayListThree.add(textView14.getText().toString());
                    checkResults();
                    tv14 = true;
                }
                break;
            case R.id.textView15:
                if (tv15) {
                    textView15.setTextColor(Color.parseColor("#000000"));
                    arrayListTotal.remove(textView15.getText().toString());
                    arrayListThree.remove(textView15.getText().toString());
                    checkResults();
                    tv15 = false;
                } else {
                    textView15.setTextColor(Color.parseColor("#00d2d2"));
                    arrayListTotal.add(textView15.getText().toString());
                    arrayListThree.add(textView15.getText().toString());
                    checkResults();
                    tv15 = true;
                }
                break;
        }
    }

    public void onSetValue(int v, int val) {

        switch (v) {
            case 1:
                textView1.setText(String.valueOf(val));
                textView1.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                textView2.setText(String.valueOf(val));
                textView2.setTextColor(Color.parseColor("#000000"));
                break;
            case 3:
                textView3.setText(String.valueOf(val));
                textView3.setTextColor(Color.parseColor("#000000"));
                break;
            case 4:
                textView4.setText(String.valueOf(val));
                textView4.setTextColor(Color.parseColor("#000000"));
                break;
            case 5:
                textView5.setText(String.valueOf(val));
                textView5.setTextColor(Color.parseColor("#000000"));
                break;

            case 6:
                textView6.setText(String.valueOf(val));
                textView6.setTextColor(Color.parseColor("#000000"));
                break;
            case 7:
                textView7.setText(String.valueOf(val));
                textView7.setTextColor(Color.parseColor("#000000"));
                break;
            case 8:
                textView8.setText(String.valueOf(val));
                textView8.setTextColor(Color.parseColor("#000000"));
                break;
            case 9:
                textView9.setText(String.valueOf(val));
                textView9.setTextColor(Color.parseColor("#000000"));
                break;
            case 10:
                textView10.setText(String.valueOf(val));
                textView10.setTextColor(Color.parseColor("#000000"));
                break;

            case 11:
                textView11.setText(String.valueOf(val));
                textView11.setTextColor(Color.parseColor("#000000"));
                break;
            case 12:
                textView12.setText(String.valueOf(val));
                textView12.setTextColor(Color.parseColor("#000000"));
                break;
            case 13:
                textView13.setText(String.valueOf(val));
                textView13.setTextColor(Color.parseColor("#000000"));
                break;
            case 14:
                textView14.setText(String.valueOf(val));
                textView14.setTextColor(Color.parseColor("#000000"));
                break;
            case 15:
                textView15.setText(String.valueOf(val));
                textView15.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }

    public void onSetValue2() {

        textView1.setText(String.valueOf(randomVal.get(0)));
        textView1.setTextColor(Color.parseColor("#000000"));

        textView2.setText(String.valueOf(randomVal.get(1)));
        textView2.setTextColor(Color.parseColor("#000000"));

        textView3.setText(String.valueOf(randomVal.get(2)));
        textView3.setTextColor(Color.parseColor("#000000"));

        textView4.setText(String.valueOf(randomVal.get(3)));
        textView4.setTextColor(Color.parseColor("#000000"));

        textView5.setText(String.valueOf(randomVal.get(4)));
        textView5.setTextColor(Color.parseColor("#000000"));

        textView6.setText(String.valueOf(randomVal.get(5)));
        textView6.setTextColor(Color.parseColor("#000000"));

        textView7.setText(String.valueOf(randomVal.get(6)));
        textView7.setTextColor(Color.parseColor("#000000"));

        textView8.setText(String.valueOf(randomVal.get(7)));
        textView8.setTextColor(Color.parseColor("#000000"));

        textView9.setText(String.valueOf(randomVal.get(8)));
        textView9.setTextColor(Color.parseColor("#000000"));

        textView10.setText(String.valueOf(randomVal.get(9)));
        textView10.setTextColor(Color.parseColor("#000000"));


        textView11.setText(String.valueOf(randomVal.get(10)));
        textView11.setTextColor(Color.parseColor("#000000"));

        textView12.setText(String.valueOf(randomVal.get(11)));
        textView12.setTextColor(Color.parseColor("#000000"));

        textView13.setText(String.valueOf(randomVal.get(12)));
        textView13.setTextColor(Color.parseColor("#000000"));

        textView14.setText(String.valueOf(randomVal.get(13)));
        textView14.setTextColor(Color.parseColor("#000000"));

        textView15.setText(String.valueOf(randomVal.get(14)));
        textView15.setTextColor(Color.parseColor("#000000"));


    }

    void checkResults() {

        Log.d("TAG", "1- " + arrayListOne.size() + "  2- " + arrayListTwo.size() + "  3- " + arrayListThree.size() + "  _-_ " + arrayListTotal.size());
        if (arrayListTotal.size() == 5) {

            try {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(" Congratulations, First five completed", TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak(" Congratulations, First five completed", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            new MaterialDialog.Builder(this)
                    .title("Congratulations ")
                    .content(" First five completed. You want to continue the game or quite and take the reward!!!! ")
                    .positiveText(" continue ")
                    .negativeText(" quite ")
                    .autoDismiss(true)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            refresh();
                        }
                    })
                    .show();


        } else if (arrayListTotal.size() == 15) {

            try {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak("Housie, you are the winner of the GAME. ", TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak("Housie, you are the winner of the GAME. ", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            new MaterialDialog.Builder(this)
                    .title("Congratulations ")
                    .content(" You are the winner of the GAME. Take the reward!!!! ")
                    .positiveText(" New Game ")
                    .autoDismiss(true)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            refresh();
                        }
                    })
                    .show();

        } else if (arrayListOne.size() == 5) {
            arrayListOne = new ArrayList<>();

            try {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak("Congratulations, First row completed. ", TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak("Congratulations, First row completed. ", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            new MaterialDialog.Builder(this)
                    .title("Congratulations ")
                    .content(" First row completed. You want to continue the game or quite and take the reward!!!! ")
                    .positiveText(" continue ")
                    .negativeText(" quite ")
                    .autoDismiss(true)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            refresh();
                        }
                    })
                    .show();

        } else if (arrayListTwo.size() == 5) {
            arrayListTwo = new ArrayList<>();

            try {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak("Congratulations, Second row completed. ", TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak("Congratulations, Second row completed. ", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            new MaterialDialog.Builder(this)
                    .title("Congratulations ")
                    .content(" Second row completed. You want to continue the game or quite and take the reward!!!! ")
                    .positiveText(" continue ")
                    .negativeText(" quite ")
                    .autoDismiss(true)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            refresh();
                        }
                    })
                    .show();

        } else if (arrayListThree.size() == 5) {
            arrayListThree = new ArrayList<>();

            try {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak("Congratulations, Third row completed. ", TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    tts.speak("Congratulations, Third row completed. ", TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            new MaterialDialog.Builder(this)
                    .title("Congratulations ")
                    .content(" Third row completed. You want to continue the game or quite and take the reward!!!! ")
                    .positiveText(" continue ")
                    .negativeText(" quite ")
                    .autoDismiss(true)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            refresh();
                        }
                    })
                    .show();

        }


    }

    @Override
    protected void onDestroy() {

        //Close the Text to Speech Library
        if (tts != null) {

            tts.stop();
            tts.shutdown();
            Log.d("TAG", "TTS Destroyed");
        }
        super.onDestroy();
    }

    void refresh() {

        tv1 = false;
        tv2 = false;
        tv3 = false;
        tv4 = false;
        tv5 = false;
        tv6 = false;
        tv7 = false;
        tv8 = false;
        tv9 = false;
        tv10 = false;
        tv11 = false;
        tv12 = false;
        tv13 = false;
        tv14 = false;
        tv15 = false;

        arrayListTotal = new ArrayList<>();
        arrayListOne = new ArrayList<>();
        arrayListTwo = new ArrayList<>();
        arrayListThree = new ArrayList<>();
        encounteredNumbers = new HashSet<>();
        randomVal = new ArrayList<>();

        for (int j = 0; encounteredNumbers.size() < 15; ) {
            int i = random.nextInt(89);
            if (i != 0 && !encounteredNumbers.contains(i)) {
                encounteredNumbers.add(i);
                randomVal.add(i);
                View v = new View(Main2Activity.this);
                v.setId(textView1.getId());
                j++;
                //onSetValue(j, i);
            }
        }
        Collections.sort(randomVal);
        onSetValue2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
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
                                refresh();
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
                        if (tts != null) {
                            tts.stop();
                            tts.shutdown();
                            Log.d("TAG", "TTS Destroyed");
                        }
                        Main2Activity.super.onBackPressed();
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
