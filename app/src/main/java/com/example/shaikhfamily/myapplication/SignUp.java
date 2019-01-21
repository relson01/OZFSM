package com.example.shaikhfamily.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaikhfamily.myapplication.performLogin.retroInstance;
import com.example.shaikhfamily.myapplication.performLogin.ApiInterface;
import com.example.shaikhfamily.myapplication.performLogin.modeling;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUp extends AppCompatActivity {

    private TextView username, email, password, reEnterPassword;
    private TextView btnSignup;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiter);

        username = findViewById(R.id.input_name);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        reEnterPassword = findViewById(R.id.input_reEnterPassword);
        btnSignup = findViewById(R.id.btn_signup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }


    private void login() {

        String user = username.getText().toString();
        String pass = password.getText().toString();
        String mail = email.getText().toString();

        ApiInterface apiInterface = retroInstance.setRetrofit().create(ApiInterface.class);
        Call<modeling> call = apiInterface.setInfo(user, mail, pass);
        call.enqueue(new Callback<modeling>() {
            @Override
            public void onResponse(Call<modeling> call, Response<modeling> response) {
                if(response.body().getResponse().equals("Registered Successfully"))
                {
                    Toast.makeText(SignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else if(response.body().getResponse().equals("Already exist"))
                {
                    Toast.makeText(SignUp.this, "Already exist", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SignUp.this, "Error occured", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<modeling> call, Throwable t) {
                Toast.makeText(SignUp.this, "Onfailure", Toast.LENGTH_SHORT).show();
            }
            private void performRegistration() {

                if(!checkUsername()){
                    return;
                }
                if(!checkPassword())
                {
                    return;
                }
            }

            private boolean checkUsername() {
                String user = username.getText().toString();
                if(user.equals(""))
                {
                    username.setError("cannot be empty");
                    return false;

                }
                return true;
            }

            private boolean checkPassword() {
                String pass = password.getText().toString();
                String confirmPassword = reEnterPassword.getText().toString();

                if(password.equals("")) {
                    password.setError("Cannot be empty");
                    return false;
                }
                else if(confirmPassword.equals("")) {
                    reEnterPassword.setError("Cannot be empty");
                    return  false;
                }
                else if(!password.equals(confirmPassword)) {
                    reEnterPassword.setError("Password doesnot match");
                    return false;
                }
                return true;
            }



    });
    }
}
