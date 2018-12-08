package com.example.administrator.retroitfetchdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.network.auth.AuthApiService;
import com.example.administrator.retroitfetchdata.network.country.LoginRequest;
import com.example.administrator.retroitfetchdata.network.country.LoginResponse;
import com.example.administrator.retroitfetchdata.preference.AuthPreference;
import com.example.administrator.retroitfetchdata.view.activity.SurveyActivity;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    Button loginButton;
    TextView message;

    AuthApiService authApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //TODO: make contact no field
        //TODO: validate contact no field
        emailEditText = (EditText) findViewById(R.id.emailET);
        //TODO: remove it after testing
        emailEditText.setText("arafat@test.com");

        passwordEditText = (EditText) findViewById(R.id.passwordET);
        //TODO: remove it after testing
        passwordEditText.setText("1234");
        loginButton = (Button) findViewById(R.id.loginButton);
        message = (TextView) findViewById(R.id.message);

        authApiService = new AuthApiService(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please enter email or password", Toast.LENGTH_SHORT).show();
                    message.setText("please enter valid email ");
                } else {
                    LoginRequest request = new LoginRequest();
                    request.contactNo = "1234567890";
                    request.emailAddress = emailEditText.getText().toString();
                    request.password = passwordEditText.getText().toString();
                    authApiService.loginUser(request);
                }
            }
        });
    }

    public void onUserLogin(LoginResponse response) {
        if (response.message != null)
            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show();
        if (response.success) {
            AuthPreference.setDeviceToken(this, response.token);
            AuthPreference.setUserLoggedIn(this, true);
            startActivity(new Intent(getApplicationContext(), SurveyActivity.class));
        }

    }
}
