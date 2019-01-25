package com.developer.s.worklist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ApprovalDashboard extends AppCompatActivity {
    RecyclerView recyclerview;
    RecyclerView.LayoutManager manager;
    RecyclerView.Adapter adapter;
    RelativeLayout rlayout,hidden_layout;
    Animation animationUp,animationDown,rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("INSIDE oncreate ApprovalDashboard");
        try
        {
            setContentView(R.layout.approvals_dashboard);
            recyclerview=findViewById(R.id.recyclerview);
            rlayout=findViewById(R.id.card_layout);
            hidden_layout=findViewById(R.id.hidden_details_approval);
            manager = new LinearLayoutManager(ApprovalDashboard.this,LinearLayoutManager.VERTICAL,false);
            recyclerview.setLayoutManager(manager);
            adapter = new CardAdapter(ApprovalDashboard.this);
            recyclerview.setAdapter(adapter);
            animationUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
            animationDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
            //rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.)
        }
        catch (Exception e)
        {
            System.out.println("#######################"+e.getMessage());

        }

    }
    public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
        Context context;
        public CardAdapter(Context context)
        {
            this.context=context;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder viewHolder=null;
            try {
                System.out.println("######################INSIDE onCreateViewHolder####################");
                View v = LayoutInflater.from(context).inflate(R.layout.approval_card, parent, false);
                viewHolder = new ViewHolder(v);
                final Button arrow=findViewById(R.id.approval_down_arrow);
                rlayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.print("#######################3INSIDE onClick ##########################");
                        if(hidden_layout.getVisibility()==View.GONE)
                        {
                            hidden_layout.setVisibility(View.VISIBLE);
                            hidden_layout.startAnimation(animationDown);
                            //arrow.startAnimation(this,R.anim.\);
                        }
                        else
                        {
                            hidden_layout.setVisibility(View.GONE);
                            hidden_layout.startAnimation(animationUp);
                            //arrow.setRotation(arrow.getRotation()+180);
                        }
                    }
                });
            }
            catch(Exception e)
            {
                System.out.println("----------------------"+e.getMessage());
            }
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CardAdapter.ViewHolder holder, int position) {



        }
        @Override
        public int getItemCount() {
            return 5;
        }
        public class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(View itemView){
                super(itemView);

            }

        }
    }
}
