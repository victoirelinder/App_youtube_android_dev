package com.example.victoirelinder.youtube_test_4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class Video_Fragment extends Fragment implements YouTubePlayer.OnInitializedListener{
    YouTubePlayerFragment mYoutubePlayerFragment;
    TextView videotitle;
    TextView description;
    Item item;
    String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Bundle b = this.getArguments();
        Log.v("bundle", b.toString());
        item = (Item) b.getSerializable("id");

        url = item.getId().getVideoId();


        View fragmentYoutubeView = inflater.inflate(R.layout.fragment_videoplayer, container, false);

        videotitle = (TextView)  fragmentYoutubeView.findViewById(R.id.videotitle);
        description = (TextView)  fragmentYoutubeView.findViewById(R.id.description);

        videotitle.setText(item.getSnippet().getTitle());
        description.setText(item.getSnippet().getDescription());


        mYoutubePlayerFragment = new YouTubePlayerFragment();
        mYoutubePlayerFragment.initialize(Constant.API_KEY, this);


        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contentFrame3, mYoutubePlayerFragment);
        fragmentTransaction.commit();
        return fragmentYoutubeView;
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if(!wasRestored){
            player.loadVideo(url);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        if (result.isUserRecoverableError()) {
            result.getErrorDialog(this.getActivity(),1).show();
        } else {
            Toast.makeText(this.getActivity(),
                    "YouTubePlayer.onInitializationFailure(): " + result.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }


}
