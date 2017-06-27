package com.example.android.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    TextView tvResult;
    EditText etWaitTime;
    private static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btn);
        button2=(Button)findViewById(R.id.btn2);
        tvResult=(TextView)findViewById(R.id.tv);
        etWaitTime =(EditText)findViewById(R.id.etWaitTime);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // wait 10 secs
                // tvResult.setText("Done");
/*
                TenSecWaitTask myTask=new TenSecWaitTask();
                myTask.execute();
*/

                NSecWaitTask myTask=new NSecWaitTask(tvResult);
                myTask.execute(Integer.valueOf(etWaitTime.getText().toString()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("Other Stuff");
            }
        });
    }

    class TenSecWaitTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            tvResult.setText("Ready");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            long startTime=System.currentTimeMillis();
            Log.d(TAG,"doInBackground: The wait starts");
            while (System.currentTimeMillis()<startTime+5000);

            Log.d(TAG,"doInBackground: The wait is over "+
                    (System.currentTimeMillis()-startTime));
            // to find time in nanoSeconds
/*
            SystemClock.elapsedRealtimeNanos();
*/

/*
            tvResult.setText("DONE");
            this gives error to run it on UI Thread, so we use runOnUIThread method which takes runnable
*/

/*          This is working but we should not do in such a way like if this async task is used by many activities
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvResult.setText("DONE");
                }
            });
*/
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    // New AsyncTask

}