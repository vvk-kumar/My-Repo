package com.coolstory;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TheBean
 */
@Stateless(mappedName = "MrBean")
@EJB
public class TheBean implements TheBeanRemote {

	@Override
	public String sayHi() {
		// TODO Auto-generated method stub
		return "Hi I Am Vivek";
	}

}
