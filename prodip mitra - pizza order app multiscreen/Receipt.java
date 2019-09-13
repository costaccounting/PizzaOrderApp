package assignment.prog38448.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {
    TextView tv;
    String show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        tv = findViewById(R.id.tv_receipt);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        double total = Double.parseDouble(bundle.get("total").toString());
        double delivery = Double.parseDouble(bundle.get("delivery").toString());
        double tax = (total+delivery)*0.15;
        if (savedInstanceState != null) {
            show = savedInstanceState.getString("show");
        }
        show = "Pizza\t\t$" + String.format( "%.2f",total);
        show += "\nDelivery\t\t$"+ String.format( "%.2f",delivery);
        show += "\nTax\t\t$"+ String.format( "%.2f",tax);
        show += "\nTotal\t\t$"+ String.format( "%.2f",total+delivery+tax);

        tv.setText(show);
    }

    public void onBackBtnClick(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class );
        startActivity(intent);

    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("total", show);

    }
}
