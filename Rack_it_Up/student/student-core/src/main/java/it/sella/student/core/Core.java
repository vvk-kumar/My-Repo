package it.sella.student.core;

import it.sella.student.interfaces.AbstractStudent;
import it.sella.student.interfaces.CoreInterface;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;


public class Core implements CoreInterface{

	
	private static Hashtable<Integer, AbstractStudent> hashtable = new Hashtable<Integer, AbstractStudent>();
	
	public void addme(AbstractStudent student) {
		System.out.println("Inside addme");
		System.out.println("Student : "+student);
		hashtable.put(student.getId(), student);
		Iterator iterator = hashtable.keySet().iterator();
		Integer key=null;
		while(iterator.hasNext()){
			key = (Integer) iterator.next();
			System.out.println("Key : "+key+" Value : "+hashtable.get(key));
		}
	}
	
	public ArrayList<AbstractStudent> viewMe(Integer id) {
		List<AbstractStudent> studentList = new ArrayList<AbstractStudent>();
		studentList.add((AbstractStudent)hashtable.get(id));
		return (ArrayList<AbstractStudent>) studentList;
	}

	public boolean signin(Integer uid, String passwd) {
		boolean status=false;
		System.out.println("Core Uname : "+uid);
		System.out.println("Core Passwd : "+passwd);
		
		
		if(hashtable.containsKey(uid)){
			System.out.println("Contains Key Validation Success");
			System.out.println("Hashtable Retrieved Student : "+hashtable.get(uid));
			if(hashtable.get(uid).getPassword().equalsIgnoreCase(passwd)){
			status=true;
			}
		}
		return status;
	}

	
	public void delete(Integer id) {
		if(hashtable.containsKey(id)){
			hashtable.remove(id);
		}
		
	}
}
