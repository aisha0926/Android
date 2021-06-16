package lessons.training.facebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * 1 Create the object of the class
     * 2 Initialize the object (onCreate = first executed method)
     *   2.1 Refer or bind to relevant ID  (check setContentView)
     * 3 Write logic = you can start using the attributes and methods of the class
      */
    Button mlogin, mNext;
    TextView mValue;
    private int counter= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            System.out.println("onCreate");

            //Logging
            Log.i("Lifecyle ", "OnCreate");

            setContentView(R.layout.activity_main);


            mlogin = findViewById(R.id.btnLogin);
            mValue = findViewById(R.id.tvCounter);
            mNext = findViewById(R.id.btnNext);






            //First way
            mlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mValue.setText("Value is" + counter++);
                }
            });




            //this will result in crash
            // login= findViewById(R.id.btnWelcome);
        }catch (Exception e){
            Log.e("Err", e.getLocalizedMessage());
        }
    }

    //Second way: clicks
    public void gotoNextScreen(View view){
        /**
         *
         * Navigate to other activity: Intents
         */

      // onPause();
        //onStop()
        String name= "Jack";
        Intent intent= new Intent(MainActivity.this, Welcome.class); // Explicit Intents: fully qualified classname is known
        intent.putExtra("NAME", "Welcome " +name);
       // intent.putExtra("AGE", 12);
        startActivity(intent);

        // call onDestroy(): do not want the activity to be added to the backstack
        finish();

        /**
         * Ways to transfer data
         * 1 Bundle class
         * 2 Serailizable
         * 3 Parcelable (recommended)
         */
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecyle ", "onStart");
//
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecyle ", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecyle ", "onPause");
    }




    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecyle ", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecyle ", "onDestroy");
    }

}