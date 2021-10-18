/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.ClientDAO.requete;
import static Database.ClientDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Course;

/**
 *
 * @author Antonin
 */
public class CourseDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<Course>  getLesCourses(Connection connection){    
        
        ArrayList<Course> lesCourses = new  ArrayList<Course>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from course");          
            //executer la requete
            rs=requete.executeQuery();
        
            while ( rs.next() ) {  
                Course uneCourse = new Course();
                uneCourse.setId(rs.getInt("course_id"));
                uneCourse.setNom(rs.getString("course_nom"));
                uneCourse.setLieu(rs.getString("course_lieu"));
                uneCourse.setDate(rs.getString("course_date"));
                
                lesCourses.add(uneCourse);
      
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lesCourses ;    
    }
    
    
}
