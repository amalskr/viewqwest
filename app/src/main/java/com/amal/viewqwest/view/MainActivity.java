package com.amal.viewqwest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.amal.viewqwest.QwestApp;
import com.amal.viewqwest.R;
import com.amal.viewqwest.adapters.UserAdapter;
import com.amal.viewqwest.presenter.Navigate;

public class MainActivity extends AppCompatActivity {

    private TextView noDataTv;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inits();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (QwestApp.USER_LIST == null) {
            Navigate.navigateScreen(this, new SplashActivity());
            finish();
        }
    }

    private void inits() {
        progressBar = findViewById(R.id.progressBar);
        noDataTv = findViewById(R.id.textViewNoData);
        recyclerView = findViewById(R.id.recycler_user);

        setupRecycler();
    }

    private void setupRecycler() {

        if (QwestApp.USER_LIST.size() > 0) {

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(new UserAdapter(getApplicationContext(), QwestApp.USER_LIST));

            dataVisible();
        } else {
            showError("No Users..!");
        }
    }

    private void showError(String message) {
        noDataTv.setText(message);

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        noDataTv.setVisibility(View.VISIBLE);
    }

    private void dataVisible() {
        noDataTv.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}
