package com.example.tronku.quizgame;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.RemoteViews;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView question;
    Button option1;
    Button option2;
    Button option3;
    TextView score;
    TextView quesno;
    LinearLayout li;
    LinearLayout main;
    public int ques_no = 1;
    public int score_total = 0;
    boolean op1;
    boolean op2;
    boolean op3;
    public String ques = "Ques no. ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = (TextView) findViewById(R.id.ques);
        option1 = (Button) findViewById(R.id.op1);
        option2 = (Button) findViewById(R.id.op2);
        option3 = (Button) findViewById(R.id.op3);
        score = (TextView) findViewById(R.id.value);
        quesno = (TextView) findViewById(R.id.ques_no);
        li = (LinearLayout) findViewById(R.id.linearlayout);
        main = (LinearLayout) findViewById(R.id.main);
    }
    public void op1(View view)
    {
        op1 = true;
        checkAns();
    }
    public void op2(View view)
    {
        op2 = true;
        checkAns();
    }
    public void op3(View view)
    {
        op3 = true;
        checkAns();
    }

    public void winner()
    {
        li.setVisibility(LinearLayout.INVISIBLE);
        main.setBackgroundResource(R.drawable.winner);
    }

    public void quit()
    {
        question.setText(getResources().getString(R.string.over));
        question.setTextColor(getResources().getColor(R.color.wrong));

        option1.setText(getResources().getString(R.string.score));
        option1.setTextSize(10);

        option2.setText(score_total);
        option2.setTextSize(30);

        option3.setVisibility(Button.INVISIBLE);

        score.setVisibility(TextView.INVISIBLE);
    }

    public void next()
    {

        question.setText(getResources().getString(R.string.q2));

        option1.setText(getResources().getString(R.string.q2_op1));

        option2.setText(getResources().getString(R.string.q2_op2));

        option3.setText(getResources().getString(R.string.q2_op3));

        score.setText(score_total);

        ques = ques + ques_no;
        quesno.setText(ques);

        if(ques_no == 3)
        {
            li.setBackgroundResource(R.drawable.innovation);
        }
    }

    public void checkAns()
    {

        if(ques_no == 1)
        {
            if(op2)
            {
                ques_no++;
                score_total +=50;

                option2.setText(R.string.right);
                option2.setBackgroundColor(getResources().getColor(R.color.right));
                op2 = false;
                next();
            }
            else
                quit();
        }
        if(ques_no == 2)
        {
            if(op1)
            {
                ques_no++;
                score_total +=50;
                option1.setText(R.string.right);
                option1.setBackgroundColor(getResources().getColor(R.color.right));
                op1 = false;
                next();
            }
            else
                quit();
        }
        if(ques_no == 3)
        {
            if(op2)
                winner();
            else
                quit();
        }
    }
}
