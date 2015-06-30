package org;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Symptom_2 {

	/**
	 * @param args
	 */
	
	String error;
	public String [] reasons;
	public String links;
	public String [] outcomes;
	String gs;
	
	String severity;
	int cnt;
	public String [] timestamps;
	public HashMap<String,attributes> ts_cnt=new HashMap<String,attributes>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getError()
	{
		return this.error;
	}
	public String getReason()
	{
		String ts="[";
		for(int i=0;i<reasons.length;i++)
		{
			ts=ts+reasons[i]+",";
		}
		ts=ts+"]";
		return ts;
		
	}
	public String getLinks()
	{
		
		return this.links;
		
	}
	public String getOutcome()
	{
		String ts="[";
		for(int i=0;i<outcomes.length;i++)
		{
			ts=ts+outcomes[i]+",";
		}
		ts=ts+"]";
		return ts;
	}
	public String getGs()
	{
		return this.gs;
	}
	
	public String getSeverity()
	{
		return this.severity;
	}
	public int getCnt()
	{
		return this.cnt;
	}
	public HashMap<String,attributes> getTimestamps()
	{
		
		return ts_cnt;
	}
	public void setError(String error)
	{
		this.error=error;
	}
	public void setReason(String reason)
	{
		System.out.println("In fun"+ reason);
		StringTokenizer itok=new StringTokenizer(reason,",");
		int i=0;
		int c=itok.countTokens();
		this.reasons=new String[c];
		while(itok.hasMoreTokens())
		{
			this.reasons[i]=new String();
			this.reasons[i]=itok.nextToken();
			i++;
		}
		System.out.println("number of reasons:"+reasons.length);
	}
	public void setLinks(String link)
	{
		this.links=link;
		
	}
	public void setOutcome(String outcome)
	{
		StringTokenizer itok=new StringTokenizer(outcome,",");
		int i=0;
		int c=itok.countTokens();
		this.outcomes=new String[c];
		while(itok.hasMoreTokens())
		{
			
			this.outcomes[i]=itok.nextToken();
			i++;
		}
	}
	public void setGs(String gs)
	{
		this.gs=gs;
	}
	
	public void setSeverity(String sev)
	{
		this.severity=sev;
	}
	public void setcnt(int cnt)
	{
		this.cnt=cnt;
	}
	public void setTimestamps(String timestamps)
	{
		attributes obj_att=new attributes();
		StringTokenizer itok=new StringTokenizer(timestamps,"@");
		String time_key=itok.nextToken();
		Integer cnt_val=Integer.parseInt(itok.nextToken());
		String des_val=itok.nextToken();
		obj_att.cnt=cnt_val;
		obj_att.file_des=des_val;
		ts_cnt.put(time_key, obj_att);
		System.out.println("k");
	}
	
			
			  @Override
			  public String toString() {
			return "Symptom [error=" + error + ",reason=" + reasons + ", outcome="+ outcomes + ", GeneralDescription=" + gs +", Severity=" + severity + ", count=" + cnt +", Timestamps=" + timestamps +"]";
			  }


}
