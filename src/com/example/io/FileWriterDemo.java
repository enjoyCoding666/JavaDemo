package com.example.io;

import java.io.File;
import java.io.FileWriter;

public class FileWriterDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        File file=new File("E:\\�ļ�����.txt");
		FileWriter fw=new FileWriter(file,true);
		String str="\n�ú�ѧϰ����������";
		fw.write(str);
		fw.close();
	}

}
