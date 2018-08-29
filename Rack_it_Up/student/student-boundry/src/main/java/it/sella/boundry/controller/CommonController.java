package it.sella.boundry.controller;

import it.sella.boundry.beans.StudentRequestBean;
import it.sella.student.interfaces.AbstractStudent;
import it.sella.student.interfaces.ClassPathEnum;
import it.sella.student.interfaces.CoreInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class CommonController {

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/signup")
	public ModelAndView signup() {
		return new ModelAndView("signup", "command", new StudentRequestBean());
	}

	@RequestMapping(value = "/addme", method = RequestMethod.POST)
	public ModelAndView addme(
			@ModelAttribute("student") StudentRequestBean studentbean) {

		try {
			System.out.println("Student Bean : "+studentbean);
			AbstractStudent student = studentbean;
			System.out.println("Student Bean : "+student);
			Object obj = Class.forName(ClassPathEnum.CORE.getPath()).newInstance();
			CoreInterface core = (CoreInterface) obj;
			core.addme(studentbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("login");

	}

	/*@RequestMapping("/view")
	public ModelAndView view() {
		return new ModelAndView("view");
	}*/

	@RequestMapping(value = "/viewme", method = RequestMethod.GET)
	public ModelAndView viewme(HttpServletRequest request,HttpSession session) {

		
		List<AbstractStudent> studentList = new ArrayList<AbstractStudent>();
		try {
			Object obj = Class.forName(ClassPathEnum.CORE.getPath()).newInstance();
			CoreInterface core = (CoreInterface) obj;
			System.out.println("Session Value : "+(String)session.getAttribute("ustatus"));
			if(session.getAttribute("ustatus").toString().equalsIgnoreCase("valid")){
			studentList = core.viewMe((Integer) session.getAttribute("ID"));
			}else{
				session.invalidate();
				return new ModelAndView("signout");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("show","list",studentList);
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.POST)
	public String signin(HttpServletRequest request,HttpServletResponse response,@RequestParam("uname") Integer uname,@RequestParam("password") String pwd){
		String redirect=null;
		
		try {
			Object obj = Class.forName(ClassPathEnum.CORE.getPath()).newInstance();
			CoreInterface core = (CoreInterface) obj;
			System.out.println(":: Request Values ::");
			System.out.println("UNAME :"+uname);
			System.out.println("Password :"+pwd);
			if(core.signin(uname, pwd)){
				HttpSession session = request.getSession();
				session.setAttribute("ustatus", "valid");
				session.setAttribute("ID", uname);
				Cookie cookie = new Cookie("UID", uname.toString());
				response.addCookie(cookie);
				redirect = "redirect:viewme";
							
			}else{
				redirect = "redirect:fail";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return redirect;
	}
	
	@RequestMapping("/fail")
	public String fail(){
		return "fail";
	}
	
	@RequestMapping("/signout")
	public String signout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "signout";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpSession session){
		
		try {
			Object obj = Class.forName(ClassPathEnum.CORE.getPath()).newInstance();
			CoreInterface core = (CoreInterface) obj;
			System.out.println("Session ID :"+session.getId());
			System.out.println("Session value : "+session.getAttribute("ID"));
			core.delete(Integer.parseInt(session.getAttribute("ID").toString()));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "signout";
	}
}
