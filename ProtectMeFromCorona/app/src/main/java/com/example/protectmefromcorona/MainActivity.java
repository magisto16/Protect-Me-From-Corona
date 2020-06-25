package com.example.protectmefromcorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView health_card, news_card, what_card, help_card;

    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define Cards
        health_card = (CardView) findViewById(R.id.health);
        news_card = (CardView) findViewById(R.id.news);
        what_card = (CardView) findViewById(R.id.what);
        help_card = (CardView) findViewById(R.id.help);

        //Add onClickListener
        health_card.setOnClickListener(this);
        news_card.setOnClickListener(this);
        what_card.setOnClickListener(this);
        help_card.setOnClickListener(this);

        btnLogout = findViewById(R.id.Logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intToMain);
            }
        });
    }



    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.health :
                i = new Intent(this, health.class);
                startActivity(i);
                break;
            case R.id.news :
                i = new Intent(this, news.class);
                startActivity(i);
                break;
            case R.id.what :
                i = new Intent(this, what.class);
                startActivity(i);
                break;
            case R.id.help :
                i = new Intent(this, help.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }
}
