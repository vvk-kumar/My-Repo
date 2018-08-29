package it.sella.student.interfaces;

import java.util.ArrayList;


public interface CoreInterface {

		public void addme(AbstractStudent student);
		public ArrayList<AbstractStudent> viewMe(Integer id);
		public boolean signin(Integer uname,String passwd);
		public void delete(Integer id);
}
