package meh.kitastest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private static final String PREFS_NAME = "prefs";
    private static final String PREF_LIGHT_THEME = "dark_theme";
    boolean useLightTheme;
    SharedPreferences preferences;
    Button money_button, options_button, graph_button, news_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //onCreate is used to start an activity

    //  CODE FOR GETTING THE THEME
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        useLightTheme = preferences.getBoolean(PREF_LIGHT_THEME, false);
        enableTheme(useLightTheme);

        super.onCreate(savedInstanceState);        //super is used to call the parent class constructor
        setContentView(R.layout.main_menu);    //setContentView is used to set the xml

        money_button = (Button) findViewById(R.id.moneyBut);
        options_button = (Button) findViewById(R.id.optionsBut);
        graph_button = (Button) findViewById(R.id.graphBut);
        news_button = (Button) findViewById(R.id.newsBut);

        money_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  MoneyActivity.class));
            }
        });
        options_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  OptionsActivity.class));
            }
        });
        graph_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  GraphActivity.class));
            }
        });
        news_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  NewsActivity.class));
            }
        });
    }
    public boolean usabilityLightTheme() {
        return useLightTheme;
    }

    public void toggleTheme(boolean lightTheme) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(PREF_LIGHT_THEME, lightTheme);
        editor.apply();

        Intent theme = getIntent();
        finish();

        startActivity(theme);
    }
    public void enableTheme(boolean useLightTheme){
        if(useLightTheme) setTheme(R.style.LightAppTheme);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    @Override
    public void onRestart(){
        super.onRestart();
        useLightTheme = preferences.getBoolean(PREF_LIGHT_THEME, false);
        enableTheme(useLightTheme);
        setContentView(R.layout.main_menu);


        money_button = (Button) findViewById(R.id.moneyBut);
        options_button = (Button) findViewById(R.id.optionsBut);
        graph_button = (Button) findViewById(R.id.graphBut);

        money_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  MoneyActivity.class));
            }
        });
        options_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  OptionsActivity.class));
            }
        });
        graph_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  GraphActivity.class));
            }
        });
        news_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,  NewsActivity.class));
            }
        });
        finish();
        startActivity(getIntent());
    }
}
