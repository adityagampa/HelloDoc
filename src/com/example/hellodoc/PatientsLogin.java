package com.example.hellodoc;

import com.example.hellodoc.Message;
import com.example.hellodoc.MyDb;
import com.example.hellodoc.PatientsAppointments;
import com.example.hellodoc.R;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PatientsLogin extends ActionBarActivity implements OnClickListener 
{
	
	EditText username,password;
	Button login;
	String susernamep,spasswordp;
	MyDb db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patients_login);
		username= (EditText )findViewById(R.id.editText1);
		password= (EditText )findViewById(R.id.editText2);
		login= (Button )findViewById(R.id.button1);
		db=new MyDb(this);
		
		login.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patients_login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void getDetails()
	{
		susernamep=username.getText().toString();
		spasswordp=password.getText().toString();
	}
	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.button1 :
			getDetails();
			if(db.searchPat(susernamep,spasswordp))
			{
				Intent i=new Intent(this,PatientsAppointments.class);
				i.putExtra("u1", susernamep);
				i.putExtra("p1", spasswordp);
				
				startActivity(i);	
			}
			else
			{
				Message.message(this, " Invalid Username or Password ");
			}
			
			break;
		}
		
	}
}
