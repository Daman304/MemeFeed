package com.project.memefeed;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.project.memefeed.databinding.ActivityMainBinding;
import com.project.memefeed.models.Meme;
import com.project.memefeed.view.MemeAdapter;
import com.project.memefeed.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Meme> memes;
    private boolean isLoading = false;
    private RecyclerView recyclerView;
    private MemeAdapter memeAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        displayMemesInRecyclerView();
        getMemes();
        swipeRefreshLayout=binding.swipeRefreshLayout;
        swipeRefreshLayout.setColorSchemeColors(R.color.white);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                memes.clear();
                memeAdapter.notifyDataSetChanged();
                getMemes();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void getMemes(){
        viewModel.getAllMemes().observe(this, new Observer<List<Meme>>() {
            @Override
            public void onChanged(List<Meme> memesFromLiveData) {
                if (memesFromLiveData != null) {
                    memes.addAll(memesFromLiveData);
                    memeAdapter.notifyDataSetChanged();
                    isLoading = false;
                    binding.swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
    }
    private void displayMemesInRecyclerView() {
        recyclerView=binding.memeRecyclerView;
        memes = new ArrayList<>();
        memeAdapter=new MemeAdapter(this,memes);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(memeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.memeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        int visibleItemCount = layoutManager.getChildCount();
                        int totalItemCount = layoutManager.getItemCount();
                        int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                        if (!isLoading) {
                            if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                                isLoading = true;
                                viewModel.getAllMemes();
                            }
                        }
                    }
                }
            }
        });
        memeAdapter.notifyDataSetChanged();
    }

}