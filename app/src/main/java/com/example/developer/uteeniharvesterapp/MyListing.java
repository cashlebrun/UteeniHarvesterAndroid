package com.example.developer.uteeniharvesterapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * Created by developer on 18/09/2015.
 */
public class MyListing extends AppCompatActivity {
    public final static String DEBUGTAG = "CSL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_listing);

        //Bundle b = getIntent().getExtras();

        Intent intent = getIntent();

        String email = intent.getStringExtra("EMAIL");
        String password = intent.getStringExtra("PASSWORD");

        TextView textView = (TextView) findViewById(R.id.listing);
        textView.setText("Email: " + email + "\nPassword: " + password);


        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {

                try {
                    networkCall();
                } catch (Exception e) {
                    Log.d("CSL", e.toString());
                }

                return null;
            }


        }.execute();
    }


    private void networkCall() throws Exception {
        URL url = new URL("http://staging.uteeni.com/api/v1/search?q=sushi&page=1");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line = null;

        while ((line = br.readLine()) != null) {
            Log.d("CSL", line);
            TextView textView = (TextView) findViewById(R.id.network_call);
            textView.setText(String.format(line));


        }
    }
}
