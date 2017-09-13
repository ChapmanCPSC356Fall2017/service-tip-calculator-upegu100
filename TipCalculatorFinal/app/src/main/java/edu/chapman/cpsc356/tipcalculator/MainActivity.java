package edu.chapman.cpsc356.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    //TextViews
    private TextView priceTextView;
    private TextView ratingTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    //EditTexts
    private EditText priceEditText;
    //Buttons
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    //Static Tip Variables
    private static double LOWTIP = 0.1;
    private static double MEDLOWTIP = 0.13;
    private static double MEDTIP = 0.15;
    private static double MEDHIGHTIP = 0.2;
    private static double HIGHTIP = 0.25;
    //Formatting
    private DecimalFormat moneyFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.priceTextView = (TextView) findViewById(R.id.tvEnterPrice);
        this.ratingTextView = (TextView) findViewById(R.id.tvRating);
        this.percentTextView = (TextView) findViewById(R.id.tvPercent);
        this.tipTextView = (TextView) findViewById(R.id.tvTip);
        this.totalTextView = (TextView) findViewById(R.id.tvTotal);
        this.priceEditText = (EditText) findViewById(R.id.etPrice);
        this.button1 = (Button) findViewById(R.id.btn1);
        this.button2 = (Button) findViewById(R.id.btn2);
        this.button3 = (Button) findViewById(R.id.btn3);
        this.button4 = (Button) findViewById(R.id.btn4);
        this.button5 = (Button) findViewById(R.id.btn5);
        this.button6 = (Button) findViewById(R.id.btn6);
        this.button7 = (Button) findViewById(R.id.btn7);
        this.button8 = (Button) findViewById(R.id.btn8);
        this.button9 = (Button) findViewById(R.id.btn9);
        this.button10 = (Button) findViewById(R.id.btn10);


        //Button 1 onClickListener Method
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), LOWTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 2 onClickListener Method
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), LOWTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 3 onClickListener Method
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), LOWTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 4 onClickListener Method
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), MEDLOWTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 5 onClickListener Method
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), MEDLOWTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 6 onClickListener Method
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), MEDTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 7 onClickListener Method
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), MEDTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 8 onClickListener Method
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), MEDHIGHTIP);
                }
                else
                {

                    writeError();
                }
            }
        });

        //Button 9 onClickListener Method
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), MEDHIGHTIP);
                }
                else
                {
                    writeError();
                }
            }
        });

        //Button 10 onClickListener Method
        button10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if (isValidPrice())
                {
                    writeMessage(Double.parseDouble(priceEditText.getText().toString()), HIGHTIP);
                }
                else
                {

                    writeError();
                }
            }
        });
    }

    /*
    calcTip Method
    Input: Positive price as a double, percent between 0 and 1 as a double
    Output: Price times percent
    */
    protected double calcTip(double price, double percent) { return (price*percent); }

    /*
    writeMessage method
    Input: Price as a double, percent between 0 and 1 as a double
    Output: If price is 0, tipTextView.text is set to "Looks like you paid nothing,
            so no need to tip!"
            If price is less than 0.1, tipTextView.text is set to "The price you paid
            is too small to calculate a tip for."
            If price is 0.1 or greater, percentTextView.text is set to the percent value times 100,
            tipTextView.text is set to the tip amount, and totalTextView.text is set to the total
    */
    protected void writeMessage(double price, double percent)
    {
        if (price == 0)
        {
            percentTextView.setVisibility(View.GONE);
            tipTextView.setVisibility(View.VISIBLE);
            totalTextView.setVisibility(View.GONE);
            tipTextView.setText(R.string.looks_like_you_paid_nothing_so_no_need_to_tip);
        }
        else if (price < 0.1)
        {
            percentTextView.setVisibility(View.GONE);
            tipTextView.setVisibility(View.VISIBLE);
            totalTextView.setVisibility(View.GONE);
            tipTextView.setText(R.string.the_price_you_paid_is_too_small_to_calculate_a_tip_for);
        }
        else
        {
            percentTextView.setVisibility(View.VISIBLE);
            tipTextView.setVisibility(View.VISIBLE);
            totalTextView.setVisibility(View.VISIBLE);

            percentTextView.setText(getString(R.string.rate) + ": " + (int) (percent*100) +
                    getString(R.string.percent_symbol));
            tipTextView.setText(getString(R.string.tip) + ": " + getString(R.string.currency_symbol) +
                    moneyFormat.format(calcTip(price, percent)));
            totalTextView.setText(getString(R.string.total) + ": " + getString(R.string.currency_symbol) +
                    moneyFormat.format((price + calcTip(price, percent))));
        }
    }

    /*
    tryParseDouble Method
    Input: Takes a string as input
    Output: Returns true if string can be parsed to a double and false otherwise
    */
    protected static boolean tryParseDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    /*
    correctFormat Method
    Input: Takes a double and DecimalFormat as input
    Output: Returns true if double has the same format as the DecimalFormat and false otherwise
    */
    protected boolean correctFormat(double number, DecimalFormat df)
    {
        return (Double.parseDouble(df.format(number)) == number);
    }

    /*
    writeError Method
    Input: None
    Output: Void; Sets percentTextView and totalTextView visibilities to GONE, and changes
            tipTextView.text to "The price you have entered is invalid"
    */
    protected void writeError()
    {
        percentTextView.setVisibility(View.GONE);
        tipTextView.setVisibility(View.VISIBLE);
        totalTextView.setVisibility(View.GONE);
        tipTextView.setText(R.string.oops_we_cant_understand_what_you_typed_please_check_your_price_and_try_again);
    }


    /*
    isValidPrice Method
    Input: None
    Output: Returns true if priceEditText.test can be parsed to a double, has the correct
            moneyFormat and is not negative.
    */
    protected boolean isValidPrice()
    {
        return((tryParseDouble(priceEditText.getText().toString()))&&
                (correctFormat(Double.parseDouble(priceEditText.getText().toString()),moneyFormat))
                &&Double.parseDouble(priceEditText.getText().toString())>= 0);
    }
}
