package com.infinite.hibagent;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class AgentShowMain {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query query= session.createQuery("from Agent");
		List<Agent> agentlist =query.list();
		for (Agent agent : agentlist) {
			System.out.println(agent);
		}
		
	}

}
