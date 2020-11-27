package com.kev.affirmationsapp.ui.data;

import android.os.AsyncTask;
import android.util.Log;
import android.util.LogPrinter;

import com.kev.affirmationsapp.ui.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public class FetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
     @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://www.affirmations.dev/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null){
                line=bufferedReader.readLine();
                data = data + line;
            }

            JSONObject responseJSonObe;

            try {
                JSONObject json = new JSONObject( URLDecoder.decode( data, "UTF-8" ) );

                data = json.getString("affirmation");
            } catch (JSONException e) {
                e.printStackTrace();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //ui thread

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.data);
    }
}
