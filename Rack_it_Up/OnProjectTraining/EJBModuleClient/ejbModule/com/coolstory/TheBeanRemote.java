package com.coolstory;

import javax.ejb.Remote;

@Remote
public interface TheBeanRemote {

	public String sayHi();
}
