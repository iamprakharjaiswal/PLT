package com.example.gauravpc.plt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PostFix extends AppCompatActivity {

    char[] input;
    char[] s;
    char[] temp;
    int top=-1;
    TextView postFixExp;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_fix);


        Intent i = getIntent();
        String input1 = i.getStringExtra(a1.INP);

        button=(Button)findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PostFix.this,a1.class);
                startActivity(intent);
                finish();
            }
        });

        int len = input1.length();
        System.out.println("yayayayyayay");
        System.out.println(input1);
        System.out.println(len);
        input = new char[100];
        s= new char[100];
        temp = new char[len];

        input = input1.toCharArray();
        postFixExp = (TextView)findViewById(R.id.postFixExp);
        push('#');
        char c,x;
        int l=0,k=0;
        while(l<len) {
            c=input[l++];
            if(c=='(')
                push(c);
            else if(alphanum(c))
                temp[k++]=c;
            else if(c==')')
            {
                while(s[top]!='(')
                    temp[k++]=pop();
                x=pop();
            }
            else
            {
                while(precede(s[top])>=precede(c))
                    temp[k++]=pop();
                push(c);
            }
        }
        while(s[top]!='#')
            temp[k++]=pop();
        //temp[k]='\0';
        System.out.println(temp);
        System.out.println(temp.toString());
        postFixExp.setText(temp,0,len);


    }
    void push(char c)
    {
        s[++top]=c;
    }
    char pop()
    {
        return s[top--];
    }
    int precede( char c)
    {
        switch(c)
        {
            case '#':return 0;
            case '(': return 1;
            case '+':
            case '-': return 2;
            case '*':
            case '/': return 3;
            case '=': return 4;
        }
        return 0;
    }
    boolean alphanum(char c)
    {
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))
            return true;
        return false;
    }


}
