package it.vivek.ejbexample;

import javax.ejb.Remote;
@Remote
public interface TimeService
{
 public String getTime(String format);
 public void remove();
}
