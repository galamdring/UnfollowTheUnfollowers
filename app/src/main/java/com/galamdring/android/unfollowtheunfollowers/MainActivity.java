package com.galamdring.android.unfollowtheunfollowers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements UnfollowerAdapter.UnfollowerOnClickHandler {

    private RecyclerView rv_unfollowers;
    private UnfollowerAdapter unfollowerAdapter;
    private TextView errorMessageDisplay;
    private ProgressBar pb_loading_indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_unfollowers = (RecyclerView) findViewById(R.id.rv_unfollowers);
        errorMessageDisplay = (TextView) findViewById(R.id.tv_error_message_display);
        pb_loading_indicator= (ProgressBar) findViewById(R.id.pb_loading_indicator);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_unfollowers.setLayoutManager(layoutManager);
        rv_unfollowers.setHasFixedSize(true);
        unfollowerAdapter = new UnfollowerAdapter(this);
        rv_unfollowers.setAdapter(unfollowerAdapter);
        loadUnfollowerData();
    }

    private void loadUnfollowerData() {
        String[] unfollowersData = {"Unfollower1","Unfollower2",
                "Unfollower3","Unfollower4","Unfollower5",
                "Unfollower6","Unfollower7","Unfollower8",
                "Unfollower9","Unfollower10","Unfollower11",
                "Unfollower12","Unfollower13","Unfollower14",
                "Unfollower15","Unfollower16"};
        unfollowerAdapter.setData(unfollowersData);
    }

    @Override
    public void onClicked(String unfollowerClicked) {

    }
}
