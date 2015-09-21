package com.example.developer.uteeniharvesterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String DEBUGTAG = "CSL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSignInListener();
    }

    private void addSignInListener() {

        Button signIn = (Button) findViewById(R.id.bt_signin);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText inputEmail = (EditText) findViewById(R.id.et_email);
                String email = inputEmail.getText().toString();

                EditText inputPassword = (EditText) findViewById(R.id.et_password);
                String password = inputPassword.getText().toString();
                // How can I encrypt?
                // Do I need to use UsernamePasswordCredentials?

                Log.d(DEBUGTAG, "Your email is " + email + ". Your password is " + password + ".");

                goToMyListings(email, password);

            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToMyListings(String email, String password){
        Intent apiIntent = new Intent(this, MyListing.class);

        apiIntent.putExtra("EMAIL", email);
        apiIntent.putExtra("PASSWORD", password);

        startActivity(apiIntent);

    }
}

