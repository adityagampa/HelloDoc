package com.example.hellodoc;

import com.example.hellodoc.Message;
import com.example.hellodoc.MyDb;
import com.example.hellodoc.PatTable;
import com.example.hellodoc.PatientsLogin;
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
import android.widget.Toast;

public class PatientSecondRegistration extends ActionBarActivity implements OnClickListener 
{
	
	EditText usernamep,passwordp,reenterpasswordp;
	Button submitp;
	String susernamep,spasswordp,sreenterpasswordp,snamep,semailp,smobilep;	
	MyDb db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_second_registration);
		usernamep=(EditText )findViewById(R.id.editText1);
		passwordp=(EditText )findViewById(R.id.editText2);
		reenterpasswordp=(EditText )findViewById(R.id.editText3);
		submitp=(Button )findViewById(R.id.button1);
		submitp.setOnClickListener(this);		
		
		Intent intent=getIntent();
		snamep=intent.getStringExtra("snamep2");
		semailp=intent.getStringExtra("semailp2");
		smobilep=intent.getStringExtra("smobilep2");

		db=new MyDb(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_second_registration, menu);
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

	public void getSomeMoreDetailsP()
	{
		susernamep=usernamep.getText().toString();
		spasswordp=passwordp.getText().toString();
		sreenterpasswordp=reenterpasswordp.getText().toString();
	}
	
	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		
		case R.id.button1:
			getSomeMoreDetailsP();
			if(susernamep=="")
			{
				Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show();
			}
			else if(susernamep.length()<6)
			{
				Toast.makeText(this, "Username : min 6 characters", Toast.LENGTH_SHORT).show();
			}
			else if(susernamep.length()>=6)
			{
				if(!db.patUsernameAvailability(susernamep))
				{
					Message.message(this, "username has been already taken..! try another..!");
				}
				else
				{
					if(spasswordp.length()<8)
					{
						Toast.makeText(this, "Password : min 8 characters", Toast.LENGTH_SHORT).show();
					}
					else if(spasswordp.length()>=8)
					{
						if(!sreenterpasswordp.equals(spasswordp))
						{
							Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
						}
						else
						{
							db.addPatient(new PatTable(snamep,semailp,smobilep,susernamep,spasswordp));
							Intent z=new Intent(this,PatientsLogin.class);
							startActivity(z);
						}
					}
				}
			}
			
			break;
		}
		
	}
}
