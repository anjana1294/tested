package com.example.admin.demoretrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.SortedList;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.demoretrofit.apiService.ApiService;
import com.example.admin.demoretrofit.apiService.RestClient;
import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.Response;


public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login_btn;
    SharedPreferencesManager sharedPreferencesManager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login_btn = (Button) findViewById(R.id.login_button);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unsuccessfull !", Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        });

        sharedPreferencesManager = SharedPreferencesManager.getInstance();
        sharedPreferencesManager.initSharedPreferences(MainActivity.this);
        signUp();
    }

    private void signUp() {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(" Wait.....");
        progressDialog.show();

        JsonObject jsonLoginRequest = new JsonObject();
        jsonLoginRequest.addProperty("email", username.getText().toString().trim());
        jsonLoginRequest.addProperty("password", password.getText().toString());

        ApiService service = RestClient.getClient();
        /*retrofit2.Call<LoginInResponse> call = service.login(jsonLoginRequest);

        call.enqueue(new SortedList.Callback<LoginInResponse>() {
            @Override
            public void onResponse(Call<LoginInResponse> call, Response<LoginInResponse> response) {
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Please Wait");
                progressDialog.show();
                sharedPreferencesManager.putStringValue("userID", response.body().userData.getUserId());
                sharedPreferencesManager.putStringValue("username", response.body().userData.getUserName());
                sharedPreferencesManager.putStringValue("email", response.body().userData.getEmail());
                sharedPreferencesManager.putStringValue("phone", response.body().userData.getPhoneNo());
                sharedPreferencesManager.putBooleanValue("isLoggedIn", true);
                sharedPreferencesManager.putStringValue("profileImage", response.body().getUserData().getProfilePic());

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("userData", response.body().getUserData());
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<LoginInResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

}
