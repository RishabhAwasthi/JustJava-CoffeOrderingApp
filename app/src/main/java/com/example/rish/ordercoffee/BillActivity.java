package com.example.rish.ordercoffee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {

    private String name,email,total_cost;
    private TextView user_name,user_amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Intent intent= getIntent();
        Bundle bundle=intent.getExtras();
        name=bundle.getString("User Name");
        email=bundle.getString("User Email");
        total_cost=bundle.getString("Total cost");

        user_name=findViewById(R.id.user_name);
        user_amount=findViewById(R.id.user_amount);

        user_name.setText(name);
        user_amount.setText(total_cost);

        Button send_email = findViewById(R.id.send_email);
        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",email, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bill");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Thank you for shopping"+ name+" Total Amount: "+total_cost);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });

        Button call = findViewById(R.id.contact);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9550822772"));
                startActivity(intent);

            }
        });
    }
}
