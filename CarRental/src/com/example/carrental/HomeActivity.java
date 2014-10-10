package com.example.carrental;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HomeActivity extends Activity implements View.OnClickListener{
	

	Context context = this;
	Button registerBtn, loginBtn;
	EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    	
    	registerBtn = (Button)findViewById(R.id.RegisterBtn);
    	loginBtn = (Button)findViewById(R.id.LoginBtn);
    	username = (EditText)findViewById(R.id.UsernameInput); 
    	password = (EditText)findViewById(R.id.PasswordInput);
    	
    	registerBtn.setOnClickListener(this);
    	loginBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View view) {
		if(view.getId() == R.id.RegisterBtn){
			String info = username.getText().toString() + " " + password.getText().toString();
			Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
			
		}
		
	}
}
