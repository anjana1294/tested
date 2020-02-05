package com.example.admin.demoretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.admin.demoretrofit.Model.Company;
import com.example.admin.demoretrofit.Model.Response;
import com.example.admin.demoretrofit.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myView> {
    Context context;
    List<Response> responseList;

    public CustomAdapter(Context context, List<Response> responseList) {
        this.context = context;
        this.responseList = responseList;

    }

    @NonNull
    @Override
    public myView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_recycler, viewGroup, false);
        myView myView = new myView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull myView myView, int i) {
        myView.name.setText(responseList.get(i).name);
        myView.username.setText(responseList.get(i).userName);
        myView.email.setText(responseList.get(i).getEmail());
        myView.street.setText(responseList.get(i).getAddress().getStreet());
        myView.suite.setText(responseList.get(i).getAddress().getSuite());
        myView.city.setText(responseList.get(i).getAddress().getCity());
        myView.zipcode.setText(responseList.get(i).getAddress().getZipcode());
        myView.latitude.setText(responseList.get(i).getAddress().getGeo().getLat());
        myView.longitude.setText(responseList.get(i).getAddress().getGeo().getLongi());
        myView.phone.setText(responseList.get(i).getPhone());
        myView.website.setText(responseList.get(i).getWebsite());
        myView.bs.setText(responseList.get(i).getCompany().getCompanyname());
        myView.bs.setText(responseList.get(i).getCompany().getCompanyname());
        myView.bs.setText(responseList.get(i).getCompany().getBs());

    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public class myView extends RecyclerView.ViewHolder {
        EditText name, username, email, street,phone, zipcode, suite, city, latitude, longitude,companyName,
        catchphrase,bs,website;

        public myView(@NonNull View itemView) {
            super(itemView);
            name = (EditText) itemView.findViewById(R.id.name);
            username = (EditText) itemView.findViewById(R.id.username);
            email = (EditText) itemView.findViewById(R.id.email);
            street = (EditText) itemView.findViewById(R.id.street);
            suite = (EditText) itemView.findViewById(R.id.suite);
            city = (EditText) itemView.findViewById(R.id.city);
            zipcode = (EditText) itemView.findViewById(R.id.zipcode);
            latitude = (EditText) itemView.findViewById(R.id.latitude);
            longitude=(EditText)itemView.findViewById(R.id.longitude);
            phone = (EditText) itemView.findViewById(R.id.phone);
            companyName = (EditText) itemView.findViewById(R.id.namecompany);
            catchphrase = (EditText) itemView.findViewById(R.id.catchPhrase);
            bs = (EditText) itemView.findViewById(R.id.bs);
            website = (EditText) itemView.findViewById(R.id.website);

        }
    }
}
