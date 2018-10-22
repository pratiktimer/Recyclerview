package prateektimer.com.recyclerview;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    public static ImageView i;
    RecyclerView.LayoutManager mlayoutmanager;
    RecyclerView.Adapter adapter;
    private RecyclerView mrecyclerview;
    private Integer img[] = {
            R.drawable.ic_mood_bad_black_24dp,
            R.drawable.ic_mood_black_24dp,
            R.drawable.ic_sentiment_dissatisfied_black_24dp,
            R.drawable.ic_sentiment_neutral_black_24dp,
            R.drawable.ic_sentiment_satisfied_black_24dp,
            R.drawable.ic_sentiment_very_dissatisfied_black_24dp,
            R.drawable.ic_sentiment_very_satisfied_black_24dp
    };
    final List<Integer> images = new ArrayList(Arrays.asList(img));
    private String textemotion[] = {
            "Mood Bad",
            " Mood  ",
            "Dissatisfied",
            "Neutral",
            "Sentiment Satisfied",
            "Very Dissatisfied",
            "Very Dissatisfied"
    };
    // Intilize an array list from array
    final List<String> textemt = new ArrayList(Arrays.asList(textemotion));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = findViewById(R.id.add);
        i.setOnClickListener(this);
        mrecyclerview = findViewById(R.id.my_recycler_view);
        mrecyclerview.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mrecyclerview.setLayoutManager(mlayoutmanager);

        adapter = new MyAdapter(this, images, textemt);
        mrecyclerview.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                images.addAll(Arrays.asList(img));
                textemt.addAll(Arrays.asList(textemotion));
                adapter = new MyAdapter(this, images, textemt);


                adapter.notifyDataSetChanged();
                mrecyclerview.setAdapter(adapter);
                int count = adapter.getItemCount();
                if (count > 0) {
                    MainActivity.i.setVisibility(ImageView.GONE);
                }
                break;
        }
    }
}
