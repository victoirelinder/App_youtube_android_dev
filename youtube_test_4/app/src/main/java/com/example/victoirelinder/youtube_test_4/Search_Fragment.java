package com.example.victoirelinder.youtube_test_4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by victoirelinder on 17/03/2018.
 */

public class Search_Fragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private Button searchButton;
    private SearchResult search_result;
    private EditText text;
    private String input;
    private static final String YT_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&key=";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        searchButton = (Button) v.findViewById(R.id.button);
        searchButton.setOnClickListener(this);
        text = (EditText) v.findViewById(R.id.text);

        return v;
    }

    @Override
    public void onClick(View v){
        test();

    }

    private void test(){
        searchButton = (Button) this.getView().findViewById(R.id.button);
        input = text.getText().toString();

        StringRequest request = new StringRequest(YT_URL + Constant.API_KEY +"&maxResults=50" + "&q=" + input, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //recupere un objet java parsé
                search_result = new Gson().fromJson(response, SearchResult.class);

                FragmentManager fragmentManager = getFragmentManager(); // scinder  activités en composants encapsulés
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //
                Bundle bundle = new Bundle(); //  bundle can hold all types of values and pass to the new activity.
                bundle.putString("input",input);
                bundle.putParcelable("data", search_result);
                Result_Fragment result_fragment = new Result_Fragment();
                result_fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.contentFrame2,result_fragment).addToBackStack("results");
                fragmentTransaction.commit();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Search", "Error",error);
            }
        });

        Volley.newRequestQueue(getActivity().getApplicationContext()).add(request);
    }

 // volley une bibliothèque permettant de construire facilement des applications réseaux très performantes sur Android.
 //Il supporte la priorisation des requêtes ( pas de galère d'asynctask)
}
