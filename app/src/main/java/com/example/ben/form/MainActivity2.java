package com.example.ben.form;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = MainActivity2.class.getSimpleName();
    TextView message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        message = findViewById(R.id.message);

        StringBuilder msg = new StringBuilder("Thanks for signing up, ");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;
        if (b.containsKey(Constants.KEY_USER)) {
            String user = b.getString(Constants.KEY_USER);
            msg.append(user).append("!");
            Log.i(TAG, "Username: " + user);
        }
        message.setText(msg);
        Log.i(TAG, "onCreate()");
        }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

        @Override
        protected void onRestart() {
            super.onRestart();
            Log.i(TAG, "onRestart()");
        }

        @Override
        protected void onStart() {
            super.onStart();
            Log.i(TAG, "onStart()");
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.i(TAG, "onResume()");
        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.i(TAG, "onPause()");
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.i(TAG, "onStop()");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.i(TAG, "onDestroy()");
        }

}
