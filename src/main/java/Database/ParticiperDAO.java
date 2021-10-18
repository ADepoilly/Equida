/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.ParticiperDAO.requete;
import static Database.ParticiperDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Participer;
import model.Cheval;
import model.Course;

/**
 *
 * @author Antonin
 */
public class ParticiperDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<Participer>  getLesParticipations(Connection connection, String idCourse){    
        
        ArrayList<Participer> lesParticipations = new  ArrayList<Participer>();
        
         System.out.println("PARTICPERDAO" + idCourse);
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from participer, cheval, course where course_id = par_courseId and par_cheId = che_id and par_courseId = ?");
           
            requete.setString(1, idCourse);
            System.out.println("getlesparticipations" + requete);
            //executer la requete
            rs=requete.executeQuery();
          
            while ( rs.next() ) {  
                Participer uneParticipation = new Participer();
                uneParticipation.setId(rs.getInt("par_id"));
                uneParticipation.setPlace(rs.getInt("par_place"));
                
                Cheval unCheval = new Cheval();             
                unCheval.setId(rs.getInt("che_id"));
                unCheval.setNom(rs.getString("che_nom"));
                                
                uneParticipation.setCheval(unCheval);
                
                Course uneCourse = new Course();
                uneCourse.setId(rs.getInt("course_id"));
                uneCourse.setNom(rs.getString("course_nom"));
                uneCourse.setLieu(rs.getString("course_lieu"));
                uneCourse.setDate(rs.getString("course_date"));
                
                uneParticipation.setCourse (uneCourse);
                
                lesParticipations.add(uneParticipation);
      
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesParticipations ;    
    }
    
}
