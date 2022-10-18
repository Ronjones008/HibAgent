package com.infinite.hibagent;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.infinite.hibagent.Agent;

public class AgentDeleteMain {
	public static void main(String[] args) {
		int agentId;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Agent Id:");
		agentId=sc.nextInt();
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query query= session.createQuery("from Agent where agentId="+agentId);
		List<Agent> agentsList = query.list();
		if(agentsList.size()==1){
			Transaction trans = session.beginTransaction();
			session.delete(agentsList.get(0));
			trans.commit();
			System.out.println("Record Deleted");
		}else{
				System.out.println("***Record Not Found***");
			}
		
	}
	}


