
package justjava.com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=1;

    boolean isChecked =true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //int price = calculatePrice();
        String priceMessage = createOrderSummary();

        displayMessage(priceMessage);

    }

    public void increment(View view) {

        quantity= quantity + 1;
        display(quantity);

    }

    public void decrement(View view) {
        quantity= quantity - 1;
        display(quantity);


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public int calculatePrice() {
        CheckBox whippedcream = (CheckBox) findViewById(R.id.cream_id);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_id);


        int price = (quantity * 3);

        if (whippedcream.isChecked() && !chocolate.isChecked()) {
            price = price + 1;
            return price;
        }
        if (chocolate.isChecked() && !whippedcream.isChecked()) {
            price = price + 2 ;
            return price;
        }
        if (whippedcream.isChecked() && whippedcream.isChecked()) {
            price = price + 3;
            return price;
        }
        else {
            return price;
        }

    }



    public String whippedCream () {

        CheckBox whippedcream = (CheckBox) findViewById(R.id.cream_id);
        isChecked = whippedcream.isChecked();

        if(isChecked) {
            return "+$1";
        }
        else {
            return "No";
        }
    }

    public String Chocolate () {
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_id);
        isChecked = chocolate.isChecked();

        if(isChecked) {
            return "+$2";
        }
        else {
            return "No";
        }
    }

    public String textFieldOne() {
        EditText textfield = (EditText) findViewById(R.id.textfieldOne);
        String message = textfield.getText().toString();
        Log.v("MainActivity", "Name: " + message);
        return message;
    }


    private String createOrderSummary() {
        String priceMessage = "Name: " + textFieldOne();
        priceMessage += "\nAdd whipped cream? " + whippedCream() ;
        priceMessage += "\nAdd Chocolate? " + Chocolate() ;
        priceMessage+= "\nQuantity: " + quantity;
        priceMessage+= "\nTotal: $" + calculatePrice();
        priceMessage+= "\nThank you!";
        return priceMessage;

    }


    /**
     * This method displays the given text on the screen.
     */


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}