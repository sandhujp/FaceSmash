package jp.facesmash;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FeedbackActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeback);

        final EditText name = (EditText) findViewById(R.id.editText1);
        final EditText addy = (EditText) findViewById(R.id.editText2);

        final EditText questions = (EditText) findViewById(R.id.editText4);

        Button email = (Button) findViewById(R.id.button30);
        email.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v){
                //TODO Auto-generated method stub
                Intent email = new Intent(android.content.Intent.ACTION_SEND);


                email.setType("plain/text");
                email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{addy.getText().toString()});
                email.putExtra(android.content.Intent.EXTRA_SUBJECT, "JPs App");
                email.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+name.getText().toString()+'\n'+"address:"+addy.getText().toString()+'\n'+"phone:"+'\n'+'\n'+questions.getText().toString()+'\n'+'\n');


                startActivity(Intent.createChooser(email, "Send mail..."));
            }
        });

    }
}
