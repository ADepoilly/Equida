<%-- 
    Document   : ajouterPays
    Created on : 13 oct. 2021, 09:21:03
    Author     : Donatien
--%>

<%@page import="model.Cheval"%>
<%@page import="model.TypeCheval"%>
<%@page import="java.util.ArrayList"%>
<%@page import="forms.FormCheval"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <head>
        <title>Equida</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <%@include file="../components/css.jsp" %>
    </head>
        
    <body>        
        <%@include file="../components/header.jsp" %>
        
        
        <section class="hero-wrap hero-wrap-2" style="height: 10vh; background-image: url('https://picardie.media.tourinsoft.eu/upload/Hippodrome-Chantilly--1-.jpg');">

</section>

<section>
        <p class="h1 text-center mt-5">Modifier le cheval un cheval</p>
                <%
        Cheval unChevalCible = (Cheval)request.getAttribute("pLeCheval");
        System.out.println("Retour formulaire : "+unChevalCible.getNom());
        %>
        
    <%
                //Cheval Cheval=(Cheval)request.getAttribute("Cheval");
                FormCheval form = (FormCheval)request.getAttribute("form");
            %>
        
            <<form class="text-start" action="ajouterCheval" method="POST" style="display: flex; flex-direction: column; width: 20%; margin-left: 5%;">
                <label for="chevalNom">Nom du cheval </label>
                <input id="codePays" type="text" name="chevalNom" value="<% out.print(unChevalCible.getNom()); %>"  size="10" maxlength="30" style="margin-bottom: 2vh;">
                
                <br><label for="chevalSexe">Sexe du cheval</label>
                <select name="chevalSexe" id="chevalSexe" style="margin-bottom: 2vh;">
                    <%if(unChevalCible.getSexe() == "M"){
                        out.print("<option value='M' selected='true'>Masculin</option>");
                    }else{
                        out.print("<option value='F' selected='true'>Masculin</option>");
                    }%>
                    <option value="M">Masculin</option>
                    <option value="F">Féminin</option>
                </select>
                
                
                <label for="chevalSire">Sire du cheval </label>
                <input id="codePays" type="text" name="chevalSire" value="<% out.print(unChevalCible.getSire()); %>"  size="50" maxlength="50"  style="margin-bottom: 2vh;">       
                
                
                
                <label for="chevalDateNaissance">Date de naissance du cheval </label>
                <input id="codePays" type="date" name="chevalDateNaissance" value="<% out.print(unChevalCible.getDateNaissance()); %>"  size="50" maxlength="50"  style="margin-bottom: 2vh;">                  
                

                <label for="chevalType">Type du cheval</label>
                <select name="chevalType" id="chevalType"  style="margin-bottom: 2vh;">
                   <%
                        ArrayList<TypeCheval> lesTypes = (ArrayList)request.getAttribute("pLesTypeCheval");
                        System.out.println("Size " + lesTypes.size());
                        for (int i=0; i<lesTypes.size();i++){
                            TypeCheval type = lesTypes.get(i);
                            System.out.println("test type avec cheval ciblé : "+unChevalCible.getLeTypeCheval().getLibelle());
                                System.out.println(unChevalCible.getLeTypeCheval().getLibelle()+ " == "+type.getLibelle());
                                if(unChevalCible.getLeTypeCheval().getLibelle()== type.getLibelle()){
                                    out.println("<option value='" + type.getId()+"' selected>" + type.getLibelle()+"</option>" );
                                }else{
                                    out.println("<option value='" + type.getId()+"'>" + type.getLibelle()+"</option>" );
                                }
                            
                        }
                    %>
                </select>

                
                <label for="chevalPere">Père</label>
                <select name="chevalPere" id="chevalPere"  style="margin-bottom: 2vh;">
                   <%
                        ArrayList<Cheval> lesChevauxMales = (ArrayList)request.getAttribute("pLesChevauxMales");
                        for (int i=0; i<lesChevauxMales.size();i++){
                            Cheval unCheval = lesChevauxMales.get(i);
                            if(unChevalCible.getId() == unChevalCible.getPere().getId()){
                                out.println("<option value='" + unChevalCible.getId()+"' selected>" + unChevalCible.getSire()+" - "+ unChevalCible.getNom()+"</option>" );
                           }else{
                                out.println("<option value='" + unCheval.getId()+"'>" + unCheval.getSire()+" - "+ unCheval.getNom()+"</option>" );
                            }
                            
                        }
                    %>
                </select>                
                
                <label for="chevalMere">Mère</label>
                <select name="chevalMere" id="chevalMere"  style="margin-bottom: 2vh;">
                   <%
                       
                        ArrayList<Cheval> lesChevauxFemelles = (ArrayList)request.getAttribute("pLesChevauxFemelles");
                        System.out.println(lesChevauxFemelles.size());
                        for (int i=0; i<lesChevauxFemelles.size();i++){
                            Cheval unCheval = lesChevauxFemelles.get(i);
                            if(unCheval.getId() == unChevalCible.getMere().getId()){
                                out.println("<option value='" + unCheval.getId()+"' selected>" + unCheval.getSire()+" - "+ unCheval.getNom()+"</option>" );
                            }else{
                                out.println("<option value='" + unCheval.getId()+"'>" + unCheval.getSire()+" - "+ unCheval.getNom()+"</option>" );
                            }
                            
                        }
                    %>
                </select>
                
                 
                
                <input type="submit" class="mt-5" name="valider" id="valider" value="Valider"/>
            </form>
    </body>    
        
    
</html>


<%//@include file="../components/footer.jsp" %>
