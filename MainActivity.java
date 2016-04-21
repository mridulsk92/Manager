package com.example.mridul_xpetize.manager2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView loc, insp, sup, worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize
        loc = (TextView) findViewById(R.id.textView_loc);
        insp = (TextView) findViewById(R.id.textView_insp);
        sup = (TextView) findViewById(R.id.textView_super);
        worker = (TextView)findViewById(R.id.textView_worker);

        //onClick of worker text
        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, QualityActivity.class);
                i.putExtra("Quality Code",3);
                startActivity(i);
            }
        });

        //onClick of location text
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, QualityActivity.class);
                i.putExtra("Quality Code",0);
                startActivity(i);
            }
        });

        //onClick of inspector
        insp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, QualityActivity.class);
                i.putExtra("Quality Code",2);
                startActivity(i);
            }
        });

        //onClick of Supervisor
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, QualityActivity.class);
                i.putExtra("Quality Code",1);
                startActivity(i);
            }
        });
    }
}
