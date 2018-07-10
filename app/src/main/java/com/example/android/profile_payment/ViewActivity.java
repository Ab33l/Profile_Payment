package com.example.android.profile_payment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewActivity extends AppCompatActivity {
    private TextView TextUsername, TextEmail, TextPhone;
    private Button buttonEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        TextUsername = findViewById(R.id.TextUsername);
        TextEmail = findViewById(R.id.TextEmail);
        TextPhone = findViewById(R.id.TextPhone);
        User user = SharedPrefManager.getInstance(this).getUser();
        /*if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }*/
        //setting the values to the textviews
        TextEmail.setText(user.getDonorEmail());
        TextUsername.setText(user.getDonorUserName());
        TextPhone.setText(user.getDonorPhoneNumber());
        findViewById(R.id.buttonEdit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(ViewActivity.this, PersonalActivity.class));
            }
        });
         //when the user presses logout button
        //calling the logout method
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
     DonorClient donorClient = APIServiceProvider.createService(DonorClient.class);
    Call<Donor> donorClient = donorClient.donor(int id);
     APIHelper.enqueWithRetry(donationItemsCall, new Callback<List<Donation>>() {
      @Override
      public void onResponse(@NonNull Call<Donor> call, @NonNull Response<Donor> response) {
        donorClient = response.body();
        Log.d(TAG, response.toString());
      }

      @Override
      public void onFailure(@NonNull Call<Donor> call, @NonNull Throwable t) {
        Log.e(TAG, t.getMessage());
      }
    });

  }
}
}
