package com.amal.viewqwest.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.amal.viewqwest.R;
import com.amal.viewqwest.adapters.DetailsAdapter;
import com.amal.viewqwest.databinding.ActivityDetailsBinding;
import com.amal.viewqwest.model.Users;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private List<String> userImgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Users selectedUser = (Users) getIntent().getSerializableExtra("SELECTED_USER");
        userImgList = selectedUser.getImageList();

        ActivityDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        binding.setUser(selectedUser);

        setupRecycler();
    }

    private void setupRecycler() {
        final DetailsAdapter deAdap = new DetailsAdapter(this, userImgList);

        RecyclerView recyclerView = findViewById(R.id.recycler_images);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        if (isOdd(userImgList.size())) {
            layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    switch (deAdap.getItemViewType(position)) {
                        case 1:
                            return 2;
                        default:
                            return 1;
                    }
                }
            });
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(deAdap);
    }

    private boolean isOdd(int val) {
        return (val % 2) != 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
