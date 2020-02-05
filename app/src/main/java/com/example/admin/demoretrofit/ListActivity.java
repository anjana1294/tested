package com.example.admin.demoretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.demoretrofit.Model.Company;
import com.example.admin.demoretrofit.Model.Response;
import com.example.admin.demoretrofit.adapter.CustomAdapter;
import com.example.admin.demoretrofit.apiService.ApiService;
import com.example.admin.demoretrofit.apiService.RestClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Retrofit;

public class ListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList name = new ArrayList<>(Arrays.asList("person 1", "person 2", "person 3", "person 4", "person 5"));
    ArrayList Username = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    ArrayList email = new ArrayList<>(Arrays.asList("abc@gmail", "xyz@gmail.com", "abc@gmail", "xyz@gmail.com", "abc@gmail"));
    ArrayList street = new ArrayList<>(Arrays.asList("street 1", "street 2", "street 3 ", "street 4", "street 5"));
    ArrayList suite = new ArrayList<>(Arrays.asList("suite 1", "suite 2", "suite 3", "suite 4", "suite 5"));
    ArrayList city = new ArrayList<>(Arrays.asList("city 1", "city 2", "city 3", "city 4", "city 5"));
    ArrayList zipcode = new ArrayList<>(Arrays.asList("16712", "12346", "444422", "435677", "3344555"));
    ArrayList latitude = new ArrayList<>(Arrays.asList("12.0", " 52", "57.8", "423", "43"));
    ArrayList longitude = new ArrayList<>(Arrays.asList("43", "12", "44", "43", "51"));
    ArrayList phone = new ArrayList<>(Arrays.asList("43", "12", "44", "43", "51"));
    ArrayList website = new ArrayList<>(Arrays.asList("43", "12", "44", "43", "51"));
    ArrayList companyName = new ArrayList<>(Arrays.asList("43", "12", "44", "43", "51"));
    ArrayList catchphrase = new ArrayList<>(Arrays.asList("43", "12", "44", "43", "51"));
    ArrayList bs = new ArrayList<>(Arrays.asList("43", "12", "44", "43", "51"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayout);
        getUserList();
    }

    private void getUserList() {

        ApiService service = RestClient.getClient();
        Call<List<Response>> call = service.userData();
        call.enqueue(new Callback<List<Response>>() {
            @Override
            public void onResponse(retrofit.Response<List<Response>> response, Retrofit retrofit) {
                CustomAdapter customAdapter = new CustomAdapter(ListActivity.this, response.body());
                recyclerView.setAdapter(customAdapter);

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("response", t.getStackTrace().toString());
            }
        });

    }
}
