import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import org.eclipse.core.internal.runtime.Log;


public class mainclass extends Configured implements Tool{
      public int run(String[] args) throws Exception
      {
            //creating a JobConf object and assigning a job name for identification purposes
            JobConf conf = new JobConf(getConf(), mainclass.class);
            conf.setJobName("SEWS");
String sCurrentLine=" ";
String t1=" ";
int i=0;
conf.setNumMapTasks(1);
            //Setting configuration object with the Data Type of output Key and Value
            conf.setOutputKeyClass(Text.class);
            conf.setOutputValueClass(Text.class);
            /*HashSet<oraerrors> sym_main = new HashSet<oraerrors>();
            HashMap<String,Integer> symnew_main=new HashMap<String,Integer>();
              HashMap<String,oraerrors> pt_main=new HashMap<String,oraerrors>();
              HashSet dic_main=new HashSet();*/
              BufferedReader br2 = new BufferedReader(new FileReader("/home/pah/Desktop/DB_Dic.txt"));
            while((sCurrentLine=br2.readLine())!=null)
			{
            	
            	t1=t1+sCurrentLine+"*";
            	t1=t1.trim();
				/*StringTokenizer tokn = new StringTokenizer(sCurrentLine, "^");
				oraerrors ob=new oraerrors();
				
				t1=tokn.nextToken();
				ob.keyword=t1;
				ob.sev=tokn.nextToken();
				ob.gen=tokn.nextToken();
				sym_main.add(ob);
				pt_main.put(t1, ob);
				dic_main.add(t1);*/
			}
            System.out.println(t1);
            t1=t1+"!";
            BufferedReader br3 = new BufferedReader(new FileReader("/home/pah/Desktop/regular_expressions"));
            String t2="";
            while((sCurrentLine=br3.readLine())!=null)
			{
            	
            	t2=t2+sCurrentLine+"*";
            	t2=t2.trim();
				/*StringTokenizer tokn = new StringTokenizer(sCurrentLine, "^");
				oraerrors ob=new oraerrors();
				
				t1=tokn.nextToken();
				ob.keyword=t1;
				ob.sev=tokn.nextToken();
				ob.gen=tokn.nextToken();
				sym_main.add(ob);
				pt_main.put(t1, ob);
				dic_main.add(t1);*/
			}
            t2=t2+"!";
            //Providing the mapper and reducer class names
            conf.setMapperClass(mapper_2.class);
           System.out.println(t2);
            conf.setReducerClass(reducer.class);
            conf.set("test",t1);
            conf.set("test2",t2);
            //conf.setReducerClass(wordcountreducer.class);
            //We wil give 2 arguments at the run time, one in input path and other is output path
            Path inp = new Path(args[0]);
            Path out = new Path(args[1]);
            //the hdfs input and output directory to be fetched from the command line
            FileInputFormat.addInputPath(conf, inp);
            FileOutputFormat.setOutputPath(conf, out);
          br3.close();
            //System.out.println("%%%%%%%%%%%%%%%%%%%%%%");
            JobClient.runJob(conf);
            return 0;
      }
     
      public static void main(String[] args) throws Exception
      {
            // this main function will call run method defined above.
    	  System.out.println("LLLLLLLLLLLLLLLLLLL");
        int res = ToolRunner.run(new Configuration(), new mainclass(),args);
            System.exit(res);
      }
}