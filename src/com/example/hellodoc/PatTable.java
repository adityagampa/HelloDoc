package com.example.hellodoc;

public class PatTable
{
	String  pname, pemail, pmobile, pusername, ppassword;
	int pid;
	public PatTable()
	{
	}
	public PatTable(int pid, String pname, String pemail, String pmobile, String pusername, String ppassword)
	{
		this.pid=pid;
		this.pname=pname;
		this.pemail=pemail;
		this.pmobile=pmobile;
		this.pusername=pusername;
		this.ppassword=ppassword;
	}
	public PatTable(String pname, String pemail, String pmobile, String pusername, String ppassword)
	{
		this.pname=pname;
		this.pemail=pemail;
		this.pmobile=pmobile;
		this.pusername=pusername;
		this.ppassword=ppassword;
	}
	public void setPId(int pid)
	{
		this.pid=pid;
	}
	public void setPatName(String pname)
	{
		this.pname=pname;
	}
	public void setPatEmail(String pemail)
	{
		this.pemail=pemail;
	}
	public void setPatMobile(String pmobile)
	{
		this.pmobile=pmobile;
	}
	public void setPatUsername(String pusername)
	{
		this.pusername=pusername;
	}
	public void setPatPassword(String ppassword)
	{
		this.ppassword=ppassword;
	}
	
	public int getPId()
	{
		return pid;
	}
	public String getPatName()
	{
		return pname;
	}
	public String getPatEmail()
	{
		return pemail;
	}
	public String getPatMobile()
	{
		return pmobile;
	}
	public String getPatUsername()
	{
		return pusername;
	}
	public String getPatPassword()
	{
		return ppassword;
	}	
}
