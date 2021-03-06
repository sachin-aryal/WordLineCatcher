package com.project.wordlinecatcher;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by iam on 10/21/16.
 */
public class StartDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        String input = "input/wordLineList.csv";

        Configuration configuration = new Configuration();
        configuration.set("inputWord", args[0]);
        Job wordLineCatcher = Job.getInstance(configuration);

        FileInputFormat.setInputPaths(wordLineCatcher, input);
        FileOutputFormat.setOutputPath(wordLineCatcher,new Path("wordLineOutput.csv"));

        wordLineCatcher.setInputFormatClass(TextInputFormat.class);
        wordLineCatcher.setOutputFormatClass(TextOutputFormat.class);

        wordLineCatcher.setOutputKeyClass(Text.class);
        wordLineCatcher.setOutputValueClass(Text.class);

        wordLineCatcher.setMapperClass(WordLineCatcherMapper.class);

        wordLineCatcher.setJarByClass(StartDriver.class);
        wordLineCatcher.setJobName("Hadoop Word Line Catcher");

        wordLineCatcher.waitForCompletion(true);
    }
}
