package com.example.giannis.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.giannis.testapplication.POJO.Lottery;
import com.example.giannis.testapplication.rest.LotteryAPI;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button button;
    private TextView drawDate;
    static final String TAG = "LootyPool";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
//        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int myNumber=0;
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item =(MenuItem) menu.findItem(R.id.lifeId);
        item.setTitle(String.valueOf(myNumber));
        return true;
    }

    public void clickButton(View view){
        button = (Button) findViewById(R.id.button);
        drawDate = (TextView)findViewById(R.id.drawDate);

        LotteryAPI.Factory.getIstance().getLottery().enqueue(new Callback<List<Lottery>>() {
            @Override
            public void onResponse(Response<List<Lottery>> response, Retrofit retrofit) {
                Log.e(TAG, response.body()+"");
                for (Lottery lt : response.body()) {
                    Log.e(TAG, lt.getDraw_date());
                    Log.e(TAG, lt.getMega_ball());
                    if (lt.getMultiplier() != null) Log.e(TAG, lt.getMultiplier());
                    Log.e(TAG, lt.getWinning_numbers());
                }
                Log.d(TAG, "getting Draw Date");
//                Log.d(TAG, "Draw Date is: " + response.body().getDrawDate());
//                String DRAW_DATE = response.body().getDrawDate();
                drawDate.setText("DRAW_DATE");
                Log.d(TAG, "done setting Draw Date");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Failed",  t.getMessage());
                Log.d(TAG, "At onFailure - Something Failed!!");
                Log.d(TAG, "error is: " + t.getCause());
            }
        });
    }

}
