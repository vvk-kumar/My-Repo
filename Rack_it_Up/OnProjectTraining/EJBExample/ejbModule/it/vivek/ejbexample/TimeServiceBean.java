package it.vivek.ejbexample;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateless;

import weblogic.javaee.JNDIName;


/**
 * Session Bean implementation class TimeServiceBean
 */
@Stateless
@JNDIName("TimeService")
public class TimeServiceBean implements TimeService {

	 @PostConstruct
	 public void init()
	  {
	  System.out.println("Bean is initialized by the container");
	  }
	  public String getTime(String format)
	  {
	  SimpleDateFormat fmter = new SimpleDateFormat(format);
	  Calendar cal = Calendar.getInstance();
	  return fmter.format(cal.getTime());
	  }
	  @Remove
	 public void remove()
	  {
	  System.out.println("Bean is destroyed by the container");
	  }


}
