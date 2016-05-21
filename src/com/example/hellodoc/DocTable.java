package com.example.hellodoc;

public class DocTable
{
	String  dname, demail, dmobile, dusername, dpassword;
	int did;
	public DocTable()
	{
	}
	public DocTable(int did, String dname, String demail, String dmobile, String dusername, String dpassword)
	{
		this.did=did;
		this.dname=dname;
		this.demail=demail;
		this.dmobile=dmobile;
		this.dusername=dusername;
		this.dpassword=dpassword;
	}
	public DocTable(String dname, String demail, String dmobile, String dusername, String dpassword)
	{
		this.dname=dname;
		this.demail=demail;
		this.dmobile=dmobile;
		this.dusername=dusername;
		this.dpassword=dpassword;
	}
	public void setId(int did)
	{
		this.did=did;
	}
	public void setDocName(String dname)
	{
		this.dname=dname;
	}
	public void setDocEmail(String demail)
	{
		this.demail=demail;
	}
	public void setDocMobile(String dmobile)
	{
		this.dmobile=dmobile;
	}
	public void setDocUsername(String dusername)
	{
		this.dusername=dusername;
	}
	public void setDocPassword(String dpassword)
	{
		this.dpassword=dpassword;
	}
	
	public int getDId()
	{
		return did;
	}
	public String getDocName()
	{
		return dname;
	}
	public String getDocEmail()
	{
		return demail;
	}
	public String getDocMobile()
	{
		return dmobile;
	}
	public String getDocUsername()
	{
		return dusername;
	}
	public String getDocPassword()
	{
		return dpassword;
	}	
}