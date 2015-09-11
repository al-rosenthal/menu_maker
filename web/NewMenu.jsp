<%-- 
    Document   : NewMenu
    Created on : Sep 11, 2015, 1:52:43 PM
    Author     : alfre_000
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/extrastyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.Menu.getName()}</title>
    </head>
    <body>

        <div class="container">            
            <div class="col-md-2"></div>

            <div class="col-md-8">
                <h1>${sessionScope.Menu.getName()}</h1>
                <c:forEach var="sec" items="${sessionScope.Menu.getSections()}" varStatus="SectionCount">
                    <div class="box">
                        <h3><c:out value="${sec.getName()}" /></h3><br>
                        <i><c:out value="${sec.getDescription()}" /></i><br>
                        <c:forEach var="dish" items="${sec.getDishes()}">
                            <div class="dishes">
                                <strong><c:out value="${dish.getName()}" /></strong>
                                <span class="pull-right dollar">$<c:out value="${dish.getPrice()}" /></span>
                            </div><br><br>
                        </c:forEach>
                        <form name="addDish" action="DishController">
                            <div class="form-group">
                                Dish name:
                                <input class="form-control" type="text" name="name" value="" />
                                Price: 
                                <input class="form-control" type="number" step="0.01" min="0.00" max="9999" name="price" value="" /><br>
                            </div>
                            <button class="btn btn-primary" type="submit" name="section" value="${SectionCount.getIndex()}">Add a Dish</button>
                        </form>
                    </div>
                </c:forEach>
                
                
                <br>
                <h4>Add a new section:</h4>
                <form name="addsection" action="SectionController">
                    <div class="form-group">
                        Section Name:
                        <input class="form-control" type="text" name="name" value="" />
                        Section Description:
                        <textarea class="form-control" name="description" rows="2"></textarea>
                    </div>

                    <input class="btn btn-primary" type="submit" value="Add Section" name="add_section_button" />
                </form>
                <br>
            </div>
        </div>
    </body>
</html>
