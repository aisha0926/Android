package lessons.training.fragmentdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class WeatherInformation extends Fragment {
    /**
     * Ways to pass data
     *  1 Bundle argruments
     *  2 Interface
     *  3 Shared Viewmodel
     */
    private Button increment;
TextView tvInformation;
private int counter=0;
    public WeatherInformation() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_information, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * ViewBinding
         */
        increment= view.findViewById(R.id.btnIncremeent);
        tvInformation = view.findViewById(R.id.tvCounter);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvInformation.setText("value "  + counter++);
            }
        });
    }
}