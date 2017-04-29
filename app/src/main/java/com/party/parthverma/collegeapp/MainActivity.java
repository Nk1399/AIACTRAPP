package com.party.parthverma.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivityContact(View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    public void gotoActivityClubs(View view) {
        Intent intent = new Intent(this, Clubs.class);
        startActivity(intent);
    }

    public void goToActivityAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void goToActivityFaculty(View view) {
        Intent intent = new Intent(this, Faculties.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}
