import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.coolstory.TheBeanRemote;


public class Main {

	public static void main(String[] args) {
		
		Properties p = new Properties();
		
		p.put(Context.PROVIDER_URL,"t3://localhost:7001");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		
		try {
			Context ctx = new InitialContext(p);
			
			TheBeanRemote bean = (TheBeanRemote)ctx.lookup("MrBean#com.coolstory.TheBeanRemote");
			
			
			System.out.println("This is the bean " + bean.sayHi() );
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
