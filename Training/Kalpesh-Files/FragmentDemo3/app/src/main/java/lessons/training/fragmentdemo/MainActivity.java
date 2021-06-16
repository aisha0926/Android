package lessons.training.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnReplacemnt;

    /**
     * Two ways to associate a fragment with activity
     *  1 Use <fragment></fragment> in activity_main -- statically load
     *  2 Dynamically load: FragmentManager and FragmentTransaction
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 //       setContentView(R.layout.activity_main);
        setContentView(R.layout.dynamic);

        btnReplacemnt = findViewById(R.id.btnReplace);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // where -- container
        // which frag
        fragmentTransaction.add(R.id.container, new StockInformation_Fragment());
        fragmentTransaction.commit();

    }

    public  void replaceFragment(View view){
        // where -- container
        // which frag
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.container, new WeatherInformation());
        fragmentTransaction.commit();
    }

    public  void replaceFragmentWithAnother(View view){
        // where -- container
        // which frag
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.container, new StockInformation_Fragment());
        fragmentTransaction.commit();


    }
}