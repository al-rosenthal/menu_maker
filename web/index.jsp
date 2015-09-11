<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Sep 10, 2015, 4:10:40 PM
    Author     : alfre_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Maker</title>
    </head>
    <body>
        <div class="container">
            <div class="col-md-3"></div>
            <div class="col-md-4">
                <h2>Create a new menu</h2>
                <p>Name your new menu here!</p>
                <form name="menu_name" action="MenuController">
                    <input type="text" name="menu_name" value="" />
                    <input type="submit" value="New Menu" />
                </form>
                
            </div>
        </div>
    </body>
</html>
