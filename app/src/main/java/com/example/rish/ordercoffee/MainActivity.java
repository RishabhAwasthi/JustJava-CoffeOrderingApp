package com.example.rish.ordercoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView show_quant,result;
    private CheckBox cream,choc;
    private Button plus,minus,getTotal;
    private int total_cost,quantity, price=20;
    private EditText name,email;
    private String user_name=null,user_email=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);


        cream= findViewById(R.id.whipped_cream_checkbox);
        choc=findViewById(R.id.chocolate_checkbox);

        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        getTotal=findViewById(R.id.total);

        show_quant=findViewById(R.id.quant);
       // result=findViewById(R.id.res);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity<=0){
                    quantity=0;
                    Toast.makeText(MainActivity.this, "No imaginary coffe", Toast.LENGTH_SHORT).show();
                }
                else {
                    --quantity;
                    show_quant.setText(quantity+"");
                }
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>=10){
                    quantity=10;
                    Toast.makeText(MainActivity.this, "Let others drink as well", Toast.LENGTH_SHORT).show();
                }
                else{
                    quantity++;
                    show_quant.setText(quantity+"");
                }
            }
        });

        getTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_name= name.getText().toString();
                user_email= email.getText().toString();

                if(cream.isChecked())
                {
                    price+=10;
                }
                if(choc.isChecked())
                {
                    price+=10;
                }

                total_cost=price*quantity;
                price=20;
                Toast.makeText(MainActivity.this,user_name,Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this,BillActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("User Name",user_name);
                bundle.putString("User Email",user_email);
                bundle.putString("Total cost",total_cost+"");
                intent.putExtras(bundle);

                startActivity(intent);



                //result.setText(user_name+" you have to pay : Rs"+total_cost+"");
            }
        });

    }
}
