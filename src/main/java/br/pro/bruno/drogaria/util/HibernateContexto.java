package br.pro.bruno.drogaria.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Quando liga o tomCat
		HibernateUtil.getFabricaDeSessoes();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent evente) {
		// Quando desliga o tomCat
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

}
