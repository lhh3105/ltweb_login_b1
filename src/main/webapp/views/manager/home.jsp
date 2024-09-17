<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
 <%@ taglib prefix="fmt" uri = "jakarta.tags.fmt" %>
 <%@ taglib prefix="fn" uri = "jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}

.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #e8c901;
    color: white;
    padding: 15px 30px;
}

.header h1 {
    margin: 0;
}

.logout-btn {
    background-color: #dc3545;
    color: white;
    padding: 10px 15px;
    text-decoration: none;
    border-radius: 5px;
}

.logout-btn:hover {
    background-color: #c82333;
}

.admin-dashboard {
    background-color: white;
    padding: 20px;
    margin-top: 20px;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<div class="container">
        <div class="header">
            <h1>Welcome, ${username } !</h1>
            <a href="/ltweb4/logout" class="logout-btn">Log Out</a>
        </div>
        <div class="manager-dashboard">
            <h2>Manager Dashboard</h2>
            <!-- Content for admin dashboard -->
        </div>
    </div>
</body>
</html>