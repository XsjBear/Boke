package com.boke.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//@WebListener
public class ApplicationListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
        
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	String path = "pics";
    	String temp = arg0.getServletContext().getInitParameter("uploadPath");
    	if (temp != null && !"".equals(temp)){
    		path = temp;
    	}
    	
    	String basePath = arg0.getServletContext().getRealPath("/");
    	File f1 = new File(basePath,"../" + path);
    	if (!f1.exists()){
    		f1.mkdirs();
    	}
    }
	
}
