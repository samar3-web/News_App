package com.samar.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.samar.newsapp.models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHoler> {

    private Context context;
    private List<NewsHeadlines> headlines ;

    private selectListener listener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, selectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false);
        return new CustomViewHoler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHoler holder, int position) {

        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage() != null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
    public static class CustomViewHoler extends RecyclerView.ViewHolder {

        TextView text_title, text_source;
        ImageView img_headline;
        CardView cardView;

        public CustomViewHoler(@NonNull View itemView) {
            super(itemView);

            text_title = itemView.findViewById(R.id.titleNews);
            text_source = itemView.findViewById(R.id.sourceNews);
            img_headline = itemView.findViewById(R.id.imageNews);
            cardView = itemView.findViewById(R.id.main_container);
        }
    }

}
