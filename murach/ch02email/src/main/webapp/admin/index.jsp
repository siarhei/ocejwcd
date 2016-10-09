<%@ page import="java.util.Calendar, java.util.Date" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Admin</title>
    </head>
    <body>
        <header>Admin Page</header>
        <%
            Date current = new Date(); Calendar cal = Calendar.getInstance();
            cal.setTime(current);
        %>
        <footer>&copy; <%=cal.get(Calendar.YEAR)%></footer>
    </body>
</html>