package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class UpdateSarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateSarvlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			int noteId=Integer.parseInt(request.getParameter("noteId"));
			
			Session session=FactoryProvider.getFactory().openSession();
			Transaction tx=session.beginTransaction();
		    Note note=session.get(Note.class, noteId);
		    note.setTitle(title);
		    note.setContent(content);
		    note.setAddedDate(new Date());
		    
			
			tx.commit();
			session.close();
			
			response.sendRedirect("all_notes.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
