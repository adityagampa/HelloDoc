package com.example.hellodoc;

import com.example.hellodoc.DoctorLogin;
import com.example.hellodoc.DoctorSecondRegistration;
import com.example.hellodoc.Message;
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

public class DoctorRegistration extends ActionBarActivity implements OnClickListener
{

	EditText name,email,mobile;
	Button next,login;
	String sname,semail,smobile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor_registration);
		name=(EditText )findViewById(R.id.editText1);
		email=(EditText )findViewById(R.id.editText2);
		mobile=(EditText )findViewById(R.id.editText3);
		next=(Button )findViewById(R.id.button1);
		login=(Button )findViewById(R.id.button2);
		next.setOnClickListener(this);
		login.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.doctor_registration, menu);
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
	public void getDetails()
	{
		sname=name.getText().toString();
		semail=email.getText().toString();
		smobile=mobile.getText().toString();
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.button1:
			getDetails();
			if(sname.equals(""))
			{
				Toast.makeText(this, "name can't be empty", Toast.LENGTH_SHORT).show();
			}
			else if(sname.length()<6)
			{
				Toast.makeText(this, "name : min 6 characters", Toast.LENGTH_SHORT).show();
			}
			else if(sname.length()>=6)
			{
				if( !semail.contains("@") || (!semail.contains("gmail.com") && !semail.contains("yahoo.com") && !semail.contains("outlook.com")) )
				{
					Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
				}
				else
				{
					if(smobile.length()!=10)
					{
						Toast.makeText(this, "Invalid Mobile", Toast.LENGTH_SHORT).show();
					}
					else
					{
						Intent k=new Intent(this,DoctorSecondRegistration.class);
						k.putExtra("sname2", sname);
						k.putExtra("semail2", semail);
						k.putExtra("smobile2", smobile);
						startActivity(k);
					}
				}
			}
			
			break;
		case R.id.button2:
			
			Intent l=new Intent(this,DoctorLogin.class);
			
			startActivity(l);
			
			break;
		}
	}
}
