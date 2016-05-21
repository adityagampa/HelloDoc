package com.example.hellodoc;

import com.example.hellodoc.PatientSecondRegistration;
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

public class PatientRegistration extends ActionBarActivity  implements OnClickListener
{
	EditText namep,emailp,mobilep;
	Button nextp,loginp;
	String snamep,semailp,smobilep;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_registration);
		namep=(EditText )findViewById(R.id.editText1);
		emailp=(EditText )findViewById(R.id.editText2);
		mobilep=(EditText )findViewById(R.id.editText3);
		nextp=(Button )findViewById(R.id.button1);
		loginp=(Button )findViewById(R.id.button2);
		nextp.setOnClickListener(this);
		loginp.setOnClickListener(this);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.patient_registration, menu);
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

	public void getDetailsP()
	{
		snamep=namep.getText().toString();
		semailp=emailp.getText().toString();
		smobilep=mobilep.getText().toString();
	}
	
	
	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.button1:
			getDetailsP();
			if(snamep.equals(""))
			{
				Toast.makeText(this, "name can't be empty", Toast.LENGTH_SHORT).show();
			}
			else if(snamep.length()<6)
			{
				Toast.makeText(this, "name : min 6 characters", Toast.LENGTH_SHORT).show();
			}
			else if(snamep.length()>=6)
			{
				if( !semailp.contains("@") || (!semailp.contains("gmail.com") && !semailp.contains("yahoo.com") && !semailp.contains("outlook.com")) )
				{
					Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
				}
				else
				{
					if(smobilep.length()!=10)
					{
						Toast.makeText(this, "Invalid Mobile", Toast.LENGTH_SHORT).show();
					}
					else
					{
						Intent l=new Intent(this,PatientSecondRegistration.class);
						l.putExtra("snamep2", snamep);
						l.putExtra("semailp2", semailp);
						l.putExtra("smobilep2", smobilep);
						startActivity(l);
						
					}
				}
			}
			
			break;
		case R.id.button2:
			
			Intent z=new Intent(this,PatientsLogin.class);
			startActivity(z);
			
			break;
		}
	}
		
}
