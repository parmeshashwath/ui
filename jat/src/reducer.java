
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, Text, Text, Text>
{
      //reduce method accepts the Key Value pairs from mappers, do the aggregation based on keys and produce the final out put
	private static String N;
	public void configure(JobConf job) {
	    N = (job.get("test"));
	}
	public void reduce(Text key, Iterator<Text> values, OutputCollector<Text,Text> output, Reporter reporter) throws IOException
      {
            
            /*iterates through all the values available with a key and add them together and give the
            final result as the key and sum of its values*/
		 
		//ObjectWritable ob=null;
		HashSet<oraerrors> sym = new HashSet<oraerrors>();
        HashMap<String,Integer> total_cnt=new HashMap<String,Integer>();
          HashMap<String,oraerrors> pt=new HashMap<String,oraerrors>();
          HashSet dic=new HashSet();
          HashSet<String> dic_reg=new HashSet();
     String t1=" ";
     String sCurrentLine="";
     BufferedWriter bw=null;
     BufferedReader br =null;
     FileWriter fw1 = new FileWriter("/home/pah/Desktop/errors");
		try
		{
			 br = new BufferedReader(new FileReader("/home/pah/Desktop/intern/errors"));
	    	bw = new BufferedWriter(fw1);
	    	  //bw.write("hello");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		while((sCurrentLine=br.readLine())!=null)
		{
			if(dic_reg.contains(sCurrentLine))
			{
				
			}
			else
			{
				dic_reg.add(sCurrentLine);
				bw.write(sCurrentLine);
				bw.write('\n');
			}
		}
		StringTokenizer tokn = new StringTokenizer(N, "*");
        while(tokn.countTokens()>6)
        {
           	oraerrors ob=new oraerrors();
        	t1=tokn.nextToken();
			ob.keyword=t1;
			ob.sev=tokn.nextToken();
			ob.gen=tokn.nextToken();
			ob.reasons=tokn.nextToken();
			ob.outcomes=tokn.nextToken();
			ob.links=tokn.nextToken();
			sym.add(ob);
			total_cnt.put(t1,0);
			pt.put(t1, ob);
			dic.add(t1);	
        }
		

		 Text ob=new Text();
    	  String orr="*"+ pt.get(key.toString()).gen+ "*" +"{{"+"   "+"{"+pt.get(key.toString()).reasons+"}"+"{"+pt.get(key.toString()).outcomes+"}"+" }}"+"*"; 
    	  
   
          while(values.hasNext())
          {
        	  orr=orr+"{";
        	  ob=values.next();
        	  orr=orr+ ob.toString();
        	  orr=orr+"}";
          StringTokenizer token=new StringTokenizer(ob.toString(),"@");
          int eee = total_cnt.get(key.toString());
          
          token.nextToken();
          eee+=Integer.parseInt(token.nextToken());
          total_cnt.put(key.toString(), eee);
          
          }
          orr=orr+" "+"}} "+"*"+total_cnt.get(key.toString())+"*"+pt.get(key.toString()).sev+"*"+pt.get(key.toString()).links;
          Text temptext=new Text(orr);
          
   br.close();
   bw.close();
          output.collect(key, temptext);
         
      
      }
}