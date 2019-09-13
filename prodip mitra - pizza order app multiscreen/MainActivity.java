package assignment.prog38448.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Pizza pizza;
    RadioButton rb1;
    RadioButton rb2;// = (RadioButton)findViewById(R.id.rb2);
    RadioButton rb3;// = (RadioButton)findViewById(R.id.rb3);
    CheckBox cb1;// = (CheckBox)findViewById(R.id.cb1);
    CheckBox cb2;// = (CheckBox)findViewById(R.id.cb2);
    CheckBox cb3;// = (CheckBox)findViewById(R.id.cb3);
    Switch sw;// = (Switch)findViewById(R.id.switch1);
    TextView total;// = (TextView)findViewById(R.id.tvTotal);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pizza = new Pizza();
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        sw = (Switch)findViewById(R.id.switch1);
        total = (TextView)findViewById(R.id.tvTotal);

        if (savedInstanceState != null) {
            rb1.setChecked(savedInstanceState.getBoolean("rb1"));
            cb1.setChecked(savedInstanceState.getBoolean("cb1"));
            rb2.setChecked(savedInstanceState.getBoolean("rb2"));
            cb2.setChecked(savedInstanceState.getBoolean("cb2"));
            rb3.setChecked(savedInstanceState.getBoolean("rb3"));
            cb3.setChecked(savedInstanceState.getBoolean("cb3"));
            sw.setChecked(savedInstanceState.getBoolean("sw"));
            total.setText(savedInstanceState.getString("total"));

            if(rb1.isChecked())pizza.setSize(9);
            if(rb2.isChecked())pizza.setSize(11);
            if(rb3.isChecked())pizza.setSize(13);
            if(cb1.isChecked())pizza.setBacon(3);
            if(rb2.isChecked())pizza.setChicken(2);
            if(rb2.isChecked())pizza.setMashroom(1);
            if(sw.isChecked())pizza.setDelivery(5);
        }

        update();

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        sw = (Switch)findViewById(R.id.switch1);
        total = (TextView)findViewById(R.id.tvTotal);

        super.onSaveInstanceState(outState);
        outState.putBoolean("rb1", rb1.isChecked());
        outState.putBoolean("cb1", cb1.isChecked());
        outState.putBoolean("rb2", rb2.isChecked());
        outState.putBoolean("cb2", cb2.isChecked());
        outState.putBoolean("rb3", rb3.isChecked());
        outState.putBoolean("cb3", cb3.isChecked());
        outState.putBoolean("sw", sw.isChecked());
        outState.putString("total", total.getText().toString());


    }

    public void radioClicked(View view) {
        boolean checked  =  ((RadioButton)view).isChecked();
        Log.d("testing", Integer.toString(view.getId()));

        switch(view.getId()){
            case R.id.rb1:
                if(checked)
                    pizza.setSize(9.0);
                break;
            case R.id.rb2:
                if(checked)
                    pizza.setSize(11.0);
                break;
            case R.id.rb3:
                if(checked)
                    pizza.setSize(13.0);
                break;

        }
        Log.d("testing", Double.toString(pizza.getSize()));
        update();
    }

    public void onCheckboxCheck(View view) {
        boolean checked  =  ((CheckBox)view).isChecked();
        Log.d("testing", Integer.toString(view.getId()));
        switch(view.getId()){
            case R.id.cb1:
                if(checked)
                    pizza.setBacon(3);
                else
                    pizza.setBacon(0);
                break;
            case R.id.cb2:
                if(checked)
                    pizza.setChicken(2);
                else
                    pizza.setChicken(0);
                break;
            case R.id.cb3:
                if(checked)
                    pizza.setMashroom(1);
                else
                    pizza.setMashroom(0);
                break;

        }
        Log.d("testing", Double.toString(pizza.getSize()));
        update();

    }

    public void onSwitchChange(View view) {
        if(sw.isChecked()){
            sw.setText("Delivery required");

            pizza.setDelivery(5);

        }else{
            sw.setText("Pickup");
            pizza.setDelivery(0);
        }
        update();
    }

    private void update() {
        total.setText(pizza.getSize()+pizza.getBacon()+pizza.getChicken()+pizza.getMashroom()+pizza.getDelivery()+ "");
    }

    public void sendBtnPress(View view) {
        Intent intent = new Intent(getBaseContext(), Receipt.class );
        intent.putExtra("total",pizza.getSize()+pizza.getBacon()+pizza.getChicken()+pizza.getMashroom());
        intent.putExtra("delivery", pizza.getDelivery());
        startActivity(intent);

    }

    public void helpBtnClick(View view) {
        Intent intent = new Intent(getBaseContext(), HelpActivity.class );
        startActivity(intent);

    }
}
