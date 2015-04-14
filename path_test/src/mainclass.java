import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


public class mainclass extends Configured implements Tool{
      public int run(String[] args) throws Exception
      {
            //creating a JobConf object and assigning a job name for identification purposes
            JobConf conf = new JobConf(getConf(), mainclass.class);
            conf.setJobName("PARSING");
            conf.set("test", args[0]);
            //Setting configuration object with the Data Type of output Key and Value
            conf.setOutputKeyClass(Text.class);
            conf.setOutputValueClass(IntWritable.class);

            //Providing the mapper and reducer class names
            conf. setNumReduceTasks(0);
            conf.setNumMapTasks(1);
            conf.setMapperClass(mapclass.class);
            FileSystem hdfs = FileSystem.get(new Configuration());
            //conf.setReducerClass(wordcountreducer.class);
            //We wil give 2 arguments at the run time, one in input path and other is output path
            Path inp=new Path("hdfs:/usr/local/hadoop/inputlog_temp1");
            if ( hdfs.exists( inp)) { hdfs.delete( inp, true ); }
            Process obj1=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -mkdir hdfs://localhost:54310/usr/local/hadoop/inputlog_temp1");
			obj1.waitFor();
           System.out.println(args[0]);
            Process obj2=Runtime.getRuntime().exec("/usr/local/hadoop/bin/hadoop dfs -copyFromLocal "+ args[0] + " hdfs://localhost:54310/usr/local/hadoop/inputlog_temp1");
			obj2.waitFor();
	
            
            //Path inp=new Path("hdfs:/usr/local/hadoop/inputlog_temp1");//Location of file in HDFS
           Path out=new Path("hdfs:/usr/local/hadoop/outputlog_temp2");//Location of file in HDFS
            //the hdfs input and output directory to be fetched from the command line
            FileInputFormat.addInputPath(conf,inp);
            FileOutputFormat.setOutputPath(conf, out);

            JobClient.runJob(conf);
            return 0;
      }
     
      public static void main(String[] args) throws Exception
      {
            // this main function will call run method defined above.
        int res = ToolRunner.run(new Configuration(), new mainclass(),args);
            System.exit(res);
      }
}