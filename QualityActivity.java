package com.example.mridul_xpetize.manager2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class QualityActivity extends AppCompatActivity {

    int quality;
    JSONArray tasks;
    ListView quality_list;

    private static String TAG_NAME = "Name";
    private static String TAG_QUALITY = "quality";
    private static String TAG_INSPECTOR = "insp";
    ArrayList<HashMap<String, String>> dataList;
    private static String TAG_ID = "Id";
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality);

        //Get Intent
        Intent i = getIntent();
        quality = i.getIntExtra("Quality Code", 4);
        Log.d("Quality", String.valueOf(quality));

        //Initialise
        dataList = new ArrayList<HashMap<String, String>>();
        quality_list = (ListView) findViewById(R.id.listView_qual);

        if (quality == 3) {

            new GetWorkers().execute();

        } else if (quality == 1) {

            new GetSupervisors().execute();

        } else if (quality == 2) {

            new GetInspectors().execute();

        } else {

        }
    }

    //AsyncTask to get Inspectors
    private class GetInspectors extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            dataList.clear();
            pDialog = new ProgressDialog(QualityActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            String url = "http://vikray.in/MyService.asmx/ExcProcedure?Para=Proc_GetUserMst&Para=2";
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {

                try {

                    tasks = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < tasks.length(); i++) {
                        JSONObject c = tasks.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_INSPECTOR, name);
                        contact.put(TAG_ID, id);
                        dataList.add(contact);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    QualityActivity.this, dataList,
                    R.layout.layout_inspector, new String[]{TAG_INSPECTOR, TAG_ID}, new int[]{R.id.inspector, R.id.inspector_id
            });

            quality_list.setAdapter(adapter);
        }
    }

    //AsyncTask to get Supervisors
    private class GetSupervisors extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            dataList.clear();
            pDialog = new ProgressDialog(QualityActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            String url = "http://vikray.in/MyService.asmx/ExcProcedure?Para=Proc_GetUserMst&Para=1";
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {

                try {

                    tasks = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < tasks.length(); i++) {

                        JSONObject c = tasks.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_INSPECTOR, name);
                        contact.put(TAG_ID, id);
                        dataList.add(contact);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    QualityActivity.this, dataList,
                    R.layout.layout_inspector, new String[]{TAG_INSPECTOR, TAG_ID}, new int[]{R.id.inspector, R.id.inspector_id
            });

            quality_list.setAdapter(adapter);
        }
    }

    //AsyncTask to get Workers
    private class GetWorkers extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            dataList.clear();
            pDialog = new ProgressDialog(QualityActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            String url = "http://vikray.in/MyService.asmx/ExcProcedure?Para=Proc_GetUserMst&Para=3";
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {

                try {

                    tasks = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < tasks.length(); i++) {
                        JSONObject c = tasks.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_INSPECTOR, name);
                        contact.put(TAG_ID, id);
                        dataList.add(contact);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    QualityActivity.this, dataList,
                    R.layout.layout_inspector, new String[]{TAG_INSPECTOR, TAG_ID}, new int[]{R.id.inspector, R.id.inspector_id
            });

            quality_list.setAdapter(adapter);
        }
    }
}
