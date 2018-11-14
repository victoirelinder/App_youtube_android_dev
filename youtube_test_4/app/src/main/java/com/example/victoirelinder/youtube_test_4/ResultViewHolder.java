package com.example.victoirelinder.youtube_test_4;

import android.support.v7.widget.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by victoirelinder on 17/03/2018.
 */

//video played with the caption author, name blablabla

public class ResultViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

    private TextView title;
    private TextView author;
    private com.example.victoirelinder.youtube_test_4.onResultSelectedListener onResultSelectedListener;
    public ImageView mImg;

    public ResultViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.Title);
        author = (TextView) itemView.findViewById(R.id.Author);
        mImg = (ImageView) itemView.findViewById(R.id.thumb);
    }

    public void bind(final Item result){   // we display the name of the author and title associated with the choosen video
        title.setText(result.getSnippet().getTitle());
        author.setText(result.getSnippet().channelTitle);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onResultSelectedListener == null) {
                    return;
                }
                onResultSelectedListener.onResultSelected(result);
            }
        });

    }

    public void setOnResultSelectedListener(onResultSelectedListener onResultSelectedListener) {
        this.onResultSelectedListener = onResultSelectedListener;
    }

}
