package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public SaveNoteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		try {
			
		 String title=request.getParameter("title");
		 String content=request.getParameter("content");
		 
		 Note note=new Note(title, content, new Date());
		 
//		 System.out.println(note.getId()+" : "+note.getTitle());
		 
		  Session session= FactoryProvider.getFactory().openSession();
		  Transaction tx=session.beginTransaction();
		  session.save(note);
		  tx.commit();
		  PrintWriter out=response.getWriter();
		  response.setContentType("text/html");
		  out.println("<h2 style='text-align:center;'>Note is added successfully</h2>");
		  out.println("<h2 style='text-align:center;'><a href='all_notes.jsp'>View all notes</a></h2>");
		  
		  
		  
		  session.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
