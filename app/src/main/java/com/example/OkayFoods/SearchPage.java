package com.example.OkayFoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class SearchPage extends AppCompatActivity {

    String food;
    EditText et;
    TextView tv1, tv2, tv3, tv4, tv5;
    ImageView iv;
    View v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        et = (EditText) findViewById(R.id.editText);

        tv1 = (TextView) findViewById(R.id.textView13);

        tv2 = (TextView) findViewById(R.id.textView16);
        tv3 = (TextView) findViewById(R.id.textView17);
        tv4 = (TextView) findViewById(R.id.textView18);
        tv5 = (TextView) findViewById(R.id.textView19);
        iv = (ImageView) findViewById(R.id.imageView2);
    }

    public void calculateClk(View view) {
        food = et.getText().toString();
        Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show();
        new SearchPage.MyAsyncTask().execute();
    }

    /* #####AsyncTask Subclass################################################################### */
    private class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            String allStrings;
            try {
                URL myUrl = new URL("https://api.edamam.com/api/food-database/v2/parser?ingr=" +
                        food + /*"?fields=item_name%2Citem_id%2Cnf_calories%2Cnf_total_fat" + */
                        "&app_id=f347c83e&app_key=274a7db9ef4c3398e138e7e751a17da2");
                HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
                connection.setConnectTimeout(700);
                connection.connect();

                //Create a new InputStreamReader
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);

                String inputLine;
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                allStrings = stringBuilder.toString();
                publishProgress(allStrings);

            } catch (Exception e) {
            }
            return "";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            try {
                JSONObject j = new JSONObject(values[0]);

                JSONArray parsed = (JSONArray) j.get("parsed");

                JSONObject rec = parsed.getJSONObject(0);

                JSONObject food = rec.getJSONObject("food");

                JSONObject nutrients = food.getJSONObject("nutrients");

                String calories = nutrients.getString("ENERC_KCAL");
                String category = food.getString("category");
                String name = food.getString("label");
                String imageURL = food.getString("image");

                tv2.setText("Nutrition Facts");
                tv3.setText("Name: " + name);
                tv4.setText("Search Type: " + category);
                tv5.setText("Calories: " + calories);
                Picasso.get().load(imageURL).resize(291,222).centerCrop().into(iv);

                v1 = findViewById(R.id.imageView2);
                v1.setVisibility(View.VISIBLE);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
}