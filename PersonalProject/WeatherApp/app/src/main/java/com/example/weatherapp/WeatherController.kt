package com.example.weatherapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WeatherController : AppCompatActivity() {
//    const var WEATHER_URL
// Constants:
val WEATHER_URL: String? = "http://api.openweathermap.org/data/2.5/weather"

    // App ID to use OpenWeather data
    val APP_ID = "e72____PLEASE_REPLACE_ME_____13"

    // Time between location updates (5000 milliseconds or 5 seconds)
    val MIN_TIME: Long = 5000

    // Distance between location updates (1000m or 1km)
    val MIN_DISTANCE = 1000f

    // TODO: Set LOCATION_PROVIDER here:

    // TODO: Set LOCATION_PROVIDER here:
    // Member Variables:
    var mCityLabel: TextView? = null
    var mWeatherImage: ImageView? = null
    var mTemperatureLabel: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_controller_layout)


        // Linking the elements in the layout to Java code

        // Linking the elements in the layout to Java code
        mCityLabel = findViewById(R.id.locationTV) as TextView
        mWeatherImage = findViewById(R.id.weatherSymbolIV) as ImageView
        mTemperatureLabel = findViewById(R.id.tempTV) as TextView
        val changeCityButton = findViewById(R.id.changeCityButton) as ImageButton
    }
}