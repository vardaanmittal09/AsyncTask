package com.example.android.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by lenovo on 6/26/2017.
 */

 class NSecWaitTask extends AsyncTask<Integer,Float,String> {

    private TextView tvChange;

    public NSecWaitTask(TextView tvChange) {
        this.tvChange = tvChange;
    }

    @Override
    protected void onPreExecute() {
        tvChange.setText("Ready");
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(Integer... params) {
        for (int i = 0; i < (params[0]) * 2; i++) {
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() < startTime + 500) ;

            publishProgress(((float) i) / 2);
        }


        return "BOOM";
    }

    @Override
    protected void onProgressUpdate(Float... values) {
        tvChange.setText(String.valueOf(values[0]));
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        tvChange.setText(s);
        super.onPostExecute(s);
    }


}
