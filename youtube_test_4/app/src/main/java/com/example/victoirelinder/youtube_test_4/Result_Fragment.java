package com.example.victoirelinder.youtube_test_4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.gson.Gson;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.victoirelinder.youtube_test_4.Item;

/**
 * Created by victoirelinder on 17/03/2018.
 */


public class Result_Fragment extends Fragment implements onResultSelectedListener {
    private RecyclerView recyclerView;
    private ImageView img;
    Video_Fragment video_fragment;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    private static final String YT_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&key=";
    private SearchResult search_result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());  //mplementation which provides similar functionality to ListView.
        recyclerView.setLayoutManager(mLayoutManager);



        final Bundle b = this.getArguments();  ////  bundle can hold all types of values and pass to the new activity.
        Log.v("bundle", b.toString());
        final SearchResult result = b.getParcelable("data");
        setAdapter(result);
        final String input = b.getString("input");


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            { // fct pour descendre et voir plus de choix de video
                if(dy > 0) //scroll
                {
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.v("...", "Last Item Wow !");

                            String pagetoken = result.getNextPageToken();
                            StringRequest request = new StringRequest(YT_URL + Constant.API_KEY +"&maxResults=50" + "&pageToken="+ pagetoken +  "&q=" + input, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    //on parse les donnees pour recuperer des objets java
                                    search_result = new Gson().fromJson(response, SearchResult.class);

                                    FragmentManager fragmentManager = getFragmentManager();
                                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                    //the id passed as parameter is the id of the FrameLayout defined in activity_second.xml.
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("data", search_result);
                                    Result_Fragment result_fragment = new Result_Fragment();
                                    result_fragment.setArguments(bundle);
                                    fragmentTransaction.replace(R.id.contentFrame2,result_fragment, "result").addToBackStack(null);
                                    //the transaction has to be committed for changes to happen.
                                    fragmentTransaction.commit();

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.e("Search", "Error");
                                }
                            });

                            Volley.newRequestQueue(getActivity().getApplicationContext()).add(request);
                        }
                    }
                }
            }
        });

        return v;
    }

    private void setAdapter(SearchResult result) {
        ResultAdapter adapter = new ResultAdapter(getActivity().getApplicationContext(),result);
        adapter.setOnResultSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onResultSelected(Item item) {  // là ou utilisateur clique (choix video)
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //the id passed as parameter is the id of the FrameLayout defined in activity_second.xml.
        Bundle bundle = new Bundle();
        bundle.putSerializable("id", item);
        video_fragment = new Video_Fragment();

        video_fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.contentFrame2,video_fragment,"video").addToBackStack("video");

        fragmentTransaction.commit();

    }



}
