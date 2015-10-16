<%-- 
    Document   : index
    Created on : Oct 15, 2015, 13:13:13 PM
    Author     : prongbang
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.mono.entity.Users"%>
<%@page import="com.mono.service.impl.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD</title>
        <%@include file="./fragments/taglib.jsp" %> 
    </head>
    <body>
        <%@include file="./fragments/header.jsp" %>
        <%

            UserService userService = new UserService();

            Users user = new Users();

            // Prepare data to object 
            // @insert
            user.setId(1);
            user.setName("prong");
            user.setSurname("bang");
            int rs = userService.insert(user);
            user.setId(2);
            user.setName("prong");
            user.setSurname("bang");
            rs = userService.insert(user);
            if (rs == 1) {
                out.println("Insert Success.<br>");
            }

            out.print("<br>List User");
            
            // @findUsersAccount // กรณีที่ Join กับตารางอื่น โดย Users ไปสืบทอด class Account มา
            for (Users u : userService.findUsersAccount()) {
                out.println("<li>" + u.getId() + "</li>");
                out.println("<li>" + u.getName() + "</li>");
                out.println("<li>" + u.getSurname() + "</li>");
                out.println("<li>" + u.getUsername() + "</li>");
                out.println("<li>" + u.getPassword() + "</li>");
            }

            out.print("<br>List Map");

            // @findUserAccount Map // กรณีที่ Join กับตารางอื่นแล้วไม่อย่างเขียน Entity เพิ่ม
            List<Map<String, Object>> userAccountMap = userService.findUserAccount();
            for(Map<String,Object> userAccount : userAccountMap){
                out.println("<li>" + userAccount.get("id") + "</li>");
                out.println("<li>" + userAccount.get("name") + "</li>");
                out.println("<li>" + userAccount.get("surname") + "</li>");
                out.println("<li>" + userAccount.get("username") + "</li>");
                out.println("<li>" + userAccount.get("password") + "</li>");
            }
            
            out.print("<br>Find All");
            
            // @findAll
            for (Users u : userService.findAll()) {
                out.println("<li>" + u.getId() + "</li>");
                out.println("<li>" + u.getName() + "</li>");
                out.println("<li>" + u.getSurname() + "</li>");
            }

            // @update
            user.setId(1);
            user.setName("Ex4");
            rs = userService.update(user);
            if (rs == 1) {
                out.println("Update Success.<br>");
            }

            out.print("<br>Find By Pk");

            // @findByPk
            Users u = userService.findByPK(user.getId());
            out.println("<li>" + u.getId() + "</li>");
            out.println("<li>" + u.getName() + "</li>");
            out.println("<li>" + u.getSurname() + "</li>");

            // @delete
            user.setId(1);
            rs = userService.delete(user);

            user.setId(2);
            rs = userService.delete(user);
            if (rs == 1) {
                out.println("Delete Success.<br>");
            }

        %> 
        <button id="button">Alert</button>

        <script src="./js/index.controller.js"></script>

        <%@include file="./fragments/footer.jsp" %>

    </body>
</html>
