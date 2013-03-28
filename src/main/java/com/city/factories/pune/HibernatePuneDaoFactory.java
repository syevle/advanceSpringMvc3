package com.city.factories.pune;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.city.model.dao.pun.SiteDao;


/** 
 * DAO factory implementation.
 * @author santosh yevle
 */
@Component
public class HibernatePuneDaoFactory implements ApplicationContextAware, BeanNameAware {
	/** Placeholder for an instance. */
	private static HibernatePuneDaoFactory instance;
	/** Internal state. */
	private static ApplicationContext context = null;
	/** Bean Name. */
	private static String beanName;
	

	/** Return an instance of this class.
	 * @return an instance of this class
	 */
	public static synchronized HibernatePuneDaoFactory getInstance() {
		if (instance == null) {
			instance = (HibernatePuneDaoFactory) context.getBean(beanName);
		}
		return instance;
	}

	/**
	 * Sets a Spring Application Context object.
  	 * @param ctxt ApplicationContext to set
	 * @throws BeansException on spring error
	 */
	@Autowired
	public void setApplicationContext(ApplicationContext ctxt)
			throws BeansException 
	{
		context = ctxt;
	}

	/**
	* 
	* {@inheritDoc}
	* 
	* @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	*/
	public void setBeanName(String name) {
		beanName = name;
	}

	/**
	 * Return the requested bean from the context, throwing a RuntimeException on error.
	 *
	 * @param beanName to return
	 * @return the bean requested.
	 */
	public static Object getBean(String beanName) {
		Object result = context.getBean(beanName);
		if (result == null) { 
			throw new IllegalStateException(String.format("Could not find bean '%s'. Did you set the right component scanning?", beanName));
		} 
		
		return result;
	}

	
	/**
	 * Returns a SiteDao instance.
	 * 
	 * @return a SiteDao instance
	 */
	public static SiteDao  getSiteDao() {
		return (SiteDao) getBean("siteDaoImpl"); 
	}

}
