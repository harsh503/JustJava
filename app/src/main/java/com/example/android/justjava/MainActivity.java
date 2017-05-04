package com.example.android.justjava;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {
        quantity=quantity+1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        if(quantity>1) {
            quantity=quantity-1;
        }
        displayQuantity(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasChocolate,hasWhippedCream);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);




    }
    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream)
    {
        int price=5;
        if(hasChocolate==true)
            price+=2;
        if(hasWhippedCream=true)
            price+=1;
        return quantity*price;
    }

    private String createOrderSummary(String name, int price,boolean hasWhippedCream, boolean hasChocolate)
    {
        String priceMessage = "Name: " + name;
        priceMessage+= "\nAdd whipped cream? " + hasWhippedCream ;
        priceMessage+= "\nAdd chocolate? " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price + "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message)
    {
        TextView orderSmmaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSmmaryTextView.setText(message);
    }

}