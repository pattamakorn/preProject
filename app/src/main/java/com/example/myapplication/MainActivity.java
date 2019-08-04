package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    //mTextMessage.setText("หน้าหลัก");
                    getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new home()).commit();
                    return true;
                case R.id.gps:
                   // mTextMessage.setText("กระดานข่าว");
                    getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new gps()).commit();
                    return true;
                case R.id.transcript:
                    //mTextMessage.setText("แจ้งเตือน");
                    getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new Transcript()).commit();
                    return true;
                case R.id.time:
                    //mTextMessage.setText("ตารางเรียน");
                    getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new timetable()).commit();
                    return true;
                case R.id.checkname:
                    //mTextMessage.setText("เช็คชื่อ");
                    getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new checkname()).commit();
                    return true;
            }
            return false;
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuon, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem itemon) {
        int id = itemon.getItemId();
        switch (id) {
            case R.id.qrcode:
                //Toast.makeText(getApplicationContext(), "GPS", Toast.LENGTH_LONG).show();
                //getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new qrcode()).commit();
                Intent intent = new Intent(MainActivity.this, scandqrcode.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(itemon);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new home()).commit();
    }

}
