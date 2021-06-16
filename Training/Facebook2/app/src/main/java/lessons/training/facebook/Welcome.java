package lessons.training.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class Welcome extends AppCompatActivity {
Button mWebsite, mCall, mLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeUI();

        Bundle extras = getIntent().getExtras();
          if(extras!=null){
              String name= extras.getString("NAME");
              Log.d("WELCOME", name);
          }
    }

    public void initializeUI(){
        mWebsite = findViewById(R.id.btnWebsite);
        mCall = findViewById(R.id.btnCall);
        mLocation = findViewById(R.id.btnLocate);
    }

    public void launchWebsite(View view){
        //Implicit Intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);

    }

    public void callNumber(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 000000"));
        startActivity(intent);

    }

    public void locationOffice(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 51.50, 0.1278"));
        startActivity(intent);
    }
}