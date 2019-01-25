package com.developer.s.worklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Dashboard extends AppCompatActivity {
    ViewGroup vg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        vg= (RelativeLayout) findViewById(R.id.approval_group);
        vg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),ApprovalDashboard.class);
                startActivity(i);
            }
        });
    }
}
