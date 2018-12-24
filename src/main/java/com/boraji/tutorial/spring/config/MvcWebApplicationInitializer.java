package com.boraji.tutorial.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	   @Override
	   protected Class<?>[] getRootConfigClasses() {
	      return null;
	   }

	   @Override
	   protected Class<?>[] getServletConfigClasses() {
	      return new Class[] { MvcWebConfig.class,WebSocketConfig.class, SpringSSEConfiguration.class };
	   }

	   @Override
	   protected String[] getServletMappings() {
	      return new String[] { "/" };
	   }
}
