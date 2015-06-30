public class oraerrors
{
	public
	String timestamp;
	String keyword;
	String sev;
	String des;
	String gen;
	String reasons;
	String outcomes;
	String links;
	int cnt;
	 
	oraerrors(String ss,String sevv,String dess)
	{
	
		keyword=ss;
		cnt=0;
		sev=sevv;
        gen=dess;
		des="in file description::";
		reasons=" ";
		outcomes=" ";
		links=" ";
	}
	oraerrors()
	{
		keyword=" ";
		cnt=0;
		sev=" ";
		des=" ";
		reasons=" ";
		outcomes=" ";
		links=" ";
	}
	
}