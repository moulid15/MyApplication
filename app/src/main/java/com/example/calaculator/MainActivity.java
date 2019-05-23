package com.example.calaculator;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {
    private Button mybtn;
    private TextView text_View;
    private TextInputEditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (TextInputEditText)findViewById(R.id.inputvalue);
        text_View=findViewById(R.id.textView);
        mybtn= (Button)findViewById(R.id.button2);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String res=ops(strInput);
                String strInput= input.getText().toString();
                String res=ops(strInput);

                text_View.setText(res);
            }
        });


    }
    String ops(String message){
        char sign;
        int i=0;
        String lefthand="";
        int lefthandi;
        double lefthandi2=0.0;
        String righthand="";
        int righthandi;
        double righthandi2=0.0;
        double result=0.0;
        String ret="";
        while(message.charAt(i)!='+' || message.charAt(i)!='*'|| message.charAt(i)!='/' || message.charAt(i)!='-'){
            if(message.charAt(i)=='+' || message.charAt(i)=='*'|| message.charAt(i)=='/' || message.charAt(i)=='-' ){
                break;
            }

            lefthand+=message.charAt(i);
            i++;
        }
        sign=message.charAt(i);
        lefthandi=Integer.parseInt(lefthand);
        lefthandi2=(double)lefthandi;
        while(i<message.length()-1){
            i++;
            righthand+=message.charAt(i);
        }
        righthandi=Integer.parseInt(righthand);
        righthandi2=(double)righthandi;

        if(sign=='+'){
            result=lefthandi2+righthandi2;
        }
        if(sign=='-'){
            result=lefthandi2-righthandi2;
        }
        if(sign=='*'){
            result=(lefthandi2*righthandi2);
        }
        if(sign=='/'){
            result=(lefthandi2/righthandi2);
        }
        ret+=result;

        return ret;
    }


}
