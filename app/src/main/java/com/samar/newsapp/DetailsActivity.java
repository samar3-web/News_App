package com.samar.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.samar.newsapp.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_time, txt_detail, txt_content;
    ImageView img_news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_deatil_author);
        txt_time = findViewById(R.id.text_deatil_time);
        //txt_detail = findViewById(R.id.text_detail_content);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_deatil_news);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_content.setText(headlines.getDescription());
        txt_time.setText(headlines.getPublishedAt());
        txt_author.setText(headlines.getAuthor());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }
}