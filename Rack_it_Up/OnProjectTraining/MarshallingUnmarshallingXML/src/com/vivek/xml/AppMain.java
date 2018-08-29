package com.vivek.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBException;

public class AppMain {

	public static void main(String[] args) {
		
		try {
			Student student = (Student)XMLUtility.unMarshallAsObject(constructXml(), Student.class);
		
			System.out.println(student.getName());
			System.out.println(student.getAddress());
			System.out.println(student.getEmail());
			System.out.println(student.getPhone());
			
			String xml=  XMLUtility.marshallAsXML(student);
			
			
			
			System.out.println("!=============GENERATED XML==============!");
			System.out.println(xml);
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		

	}
	
	
	@SuppressWarnings("resource")
	private static String constructXml(){
		
		StringBuilder sb = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("D:\\Vivek\\OnProjectTraining\\MarshallingUnmarshallingXML\\student.xml")));
			String line;
			sb = new StringBuilder();

			while((line=br.readLine())!= null){
			    sb.append(line.trim());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb.toString());
		
		return sb.toString();
		
		
	}

}
