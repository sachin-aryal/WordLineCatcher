package com.project.wordlinecatcher;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iam on 10/21/16.
 */
public class WordLineCatcherMapper extends Mapper<LongWritable, Text, Text, Text>{

    private String word;
    private int lineNumber;
    private List<Integer> wordLine;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        word = context.getConfiguration().get("inputWord");
        wordLine = new ArrayList<Integer>();
        lineNumber = 1;
//        !Nock_out9
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if(value.toString().contains(word)){
            context.write(new Text(""),value);
        }
    }
}
