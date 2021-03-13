package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// Importing stuff for API
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchPage extends AppCompatActivity {

    // Setting global variables for text, queue, and request URL
    final TextView textView = (TextView) findViewById(R.id.text);
    RequestQueue queue = Volley.newRequestQueue(this);
    final String URL_PREFIX ="https://api.edamam.com/api/food-database/v2/parser?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
    }

    public class AddFoodItems extends AppCompatActivity {
        // creating que queue object
        private RequestQueue queue;
    }

    public StringRequest search(View view) {

        Intent intent = new Intent(this, SearchResults.class);
        EditText searchInput = (EditText) findViewById(R.id.foodSearch);
        String searchParam = searchInput.getText().toString();
        searchParam = searchParam.replaceAll("\\s", "");
        final String INGR = "ingr=";
        final String APP_ID = "&app_id=f347c83e";
        final String APP_KEY = "&app_key=274a7db9ef4c3398e138e7e751a17da2";
        // Additional parameters to be added
        String url = URL_PREFIX + searchParam + APP_ID + APP_KEY;

        return new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    // 3rd param - method onResponse lays the code procedure of success return
                    // SUCCESS
                    @Override
                    public void onResponse(String response) {
                        // try/catch block for returned JSON data
                        // see API's documentation for returned format
                        try {
                            JSONObject result = new JSONObject(response).getJSONObject("list");
                            int maxItems = result.getInt("end");
                            JSONArray resultList = result.getJSONArray("item");
                            if (resultList.length() > 0) {
                                Toast.makeText(getApplicationContext(),"API call success",Toast.LENGTH_LONG).show();
                            }

                            // catch for the JSON parsing error
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),
                                    e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    } // public void onResponse(String response)
                }, // Response.Listener<String>()
                new Response.ErrorListener() {
                    // 4th param - method onErrorResponse lays the code procedure of error return
                    // ERROR
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // display a simple message on the screen
                        Toast.makeText(getApplicationContext(), "Food source is not responding (Edamam API)", Toast.LENGTH_LONG).show();
                    }
                });

    }

    public void homePage(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goalsPage(View view) {

        Intent intent = new Intent(this, GoalsPage.class);
        startActivity(intent);
    }

    public void searchPage(View view) {
        Toast.makeText(getApplicationContext(),"You are on the search page!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Add code to cancel all API calls on view termination
        queue.cancelAll(this);
    }
}