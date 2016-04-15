package com.example.vladislavapaskova.buttonbrowser10;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private Button browse;
    private EditText inputURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browse = (Button)findViewById(R.id.browserButton);
        View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                //get url from user
                inputURL = (EditText) findViewById(R.id.inputURL);
                String url = inputURL.getText().toString();

                //check if URL is complete
                if (!url.startsWith("http://") && !url.startsWith("https://")){
                    if (!url.startsWith("http://www.") && !url.startsWith("https://www.")){
                        url = "http://www." + url;
                    }
                    else{
                        url = "http://" + url;
                    }
                }

                //initiate browser
                try {
                    Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "No application found that can handle the request", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }

        };
        browse.setOnClickListener(listener);

    }

}
