<%@ page contentType="text/html; charset=UTF-8" import="webframe.SVC.svcHost,java.io.BufferedReader,java.io.InputStreamReader"%><% 
svcHost host = new svcHost();
String ret = "";
ret = host.serviceHandler(request, response, session);
%><%=ret%>