
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.eclipse.core.internal.runtime.Log;

public class mapper_2 extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>
{
      private static String N,M;
	public void configure(JobConf job) {
	    N = (job.get("test"));
	    M = (job.get("test2"));
	}
	
 
      public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException
      {
           Text word = new Text();
          List<String> wordList = new ArrayList();
      	HashSet<oraerrors> sym = new HashSet<oraerrors>();
        HashMap<String,Integer> symnew=new HashMap<String,Integer>();
          HashMap<String,oraerrors> pt=new HashMap<String,oraerrors>();
          
          HashSet<String>dic=new HashSet();
          HashSet<String>dic_reg=new HashSet();
     String sCurrentLine=" ";
     String t1=" ";
     String str1,str2,str3,msg,tempi,tempstr;
     int trim,flag;
    		flag=0;
    		oraerrors tempob=new oraerrors();
            oraerrors tempob2=new oraerrors();
             StringTokenizer tokn = new StringTokenizer(N, "*");
             BufferedWriter bw=null;
             FileWriter fw1 = new FileWriter("/home/pah/Desktop/intern/errors",true);
     		try
     		{
     			
     	    	bw = new BufferedWriter(fw1);
     	    	  //bw.write("hello");
     		}
     		catch(Exception e)
     		{
     		e.printStackTrace();
     			
     		}
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
				pt.put(t1, ob);
			
				dic.add(t1);	
            }
            StringTokenizer tokn_reg = new StringTokenizer(M, "*");
   while(tokn_reg.hasMoreTokens())
   {
	   //bw.write("hello");
	   String t3=tokn_reg.nextToken();
	   if(!t3.equals("!"))
	   dic_reg.add(t3);
   }
   String temptokn;
            int flage=0;
      	  
            String line = value.toString();
            Iterator test2 =dic.iterator() ;
           /* while(test2.hasNext())
{
            	
	if(line.contains((String)test2.next()))
	{
		flage=1;
		break;
	}
		
}*/
            
            	flage=1;
            if(flage==1)
            {
          StringTokenizer tokenizer = new StringTokenizer(line);

        	tempstr=" ";
        	int iu=0;
        	while(tokenizer.hasMoreTokens())
        	{
        	wordList.add(tokenizer.nextToken());	
        	}
        	ListIterator<String>itr=wordList.listIterator();
        	while(iu<5 && itr.hasNext())
        	
        
        		{
        		tempstr=tempstr+"  "+itr.next();
        		iu++;
        		}
        	tempi=" ";
        					while(itr.hasNext())
        					{
        	
        		str1=itr.next();
        		str2=" ";
        		if(str1.length()>4)
        		{
        		str2=str1.substring(0,4);
        		}
        		if(str2.equals("ORA-"))
        		{
        			str3=str1.substring(4);
        			trim=Integer.parseInt(str3);
        			str1=str2+String.valueOf(trim);
        		}
        		if(dic.contains(str1))
        		{
        			flag=1;
        			tempob=pt.get(str1);
        			tempob.cnt++;
        			msg=tempob.des;
        				while(itr.hasNext())
        				{
        					tempi=itr.next();
        	        		str2=" ";
        	        		if(tempi.length()>4)
        	        		{
        	        		str2=tempi.substring(0,4);
        	        		}
        	        		if(str2.equals("ORA-")||dic.contains(tempi))
        	        		{
        	        			if(str2.equals("ORA-"))
        	        			{
        	        			str3=tempi.substring(4);
        	        			trim=Integer.parseInt(str3);
        	        			tempi=str2+String.valueOf(trim);
        	        			}
        					
        							
        										
        											if(itr.hasPrevious())
        												itr.previous();
        										msg=msg+"  "+tempi;
        											break;
        										}
        										else
        										{
        											msg=msg+" "+tempi;
        										}
        												
        				}
        					
        	
        				tempob.des=msg;
        				pt.put(str1, tempob);
        			
        		}
        		else 
        		{
        			
        			Iterator<String> iii=dic_reg.iterator();
        			while(iii.hasNext())
        			{
        				String reg_str1=iii.next();
        				int len_reg =reg_str1.length();
        				if(str1.length()>=len_reg)
        				{
        				String reg_str2=str1.substring(0, len_reg);
        				if(reg_str1.equals(reg_str2))
        				{
        					
        					if(symnew.containsKey(str1))
                			{
                				int eee=symnew.get(str1);
                				eee++;
                				symnew.put(str1, eee);
                			}
                			else
                			{
                				
                			bw.write(str1);
                			bw.write('\n');
                				symnew.put(str1, 1);
                			}
        				}
        			}
        			
        		}
        				}
        					
        					
             					Set set = pt.entrySet();
        						Iterator i = set.iterator();
        					      // Display elements
        						try
        						{
        					      while(i.hasNext()) {
        					    	  
        					         Map.Entry me = (Map.Entry)i.next();
        					         
        					         tempob2=(oraerrors) me.getValue();
        					         if(tempob2.cnt!=0)
        					         {
        					         tempob2.timestamp=tempstr;
        					         
        					        	 Text temptext=new Text((String)me.getKey());
        					        	 String argument= tempstr+"@"+String.valueOf(tempob2.cnt)+ "@"+tempob2.des ;
        					    
        					        	 Text temparg=new Text(argument);
        					        	 
        					        	 output.collect(temptext,temparg);
        					         }
        					         tempob2.cnt=0;
        					         tempob2.des=" ";
        	                         pt.put((String)me.getKey(), tempob2);
        					      }
        					      
        						}
        							
        						
        						catch (Exception e) {
        							e.printStackTrace();
        							} 
        								
        					
           
           } 
        					bw.close();
}
}
}