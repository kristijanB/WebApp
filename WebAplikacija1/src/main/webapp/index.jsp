
<html>
<body>
<h2>Web aplikacija za konverziju valuta</h2>
<form action="GetCurrency" id="form" method="post">

    <input type="text" name="amount" placeholder="1.00">
    <select name="val1" id="val1" required>
    	<option style="display:none;"></option>
				<%=request.getAttribute("value")
		%>
    </select><br>
    u
    <br>
    <input type="number" value="<%=request.getAttribute("iznos") %>" name="iznos" readonly>
    <select name="val2" id="val2">
		<%=request.getAttribute("value")
		%>
    </select><br>

    na dan
    <br>
		<%=request.getAttribute("date")
		%>
        <input type="submit" value="IZRACUNAJ">
    <br>
</form>
</body>
</html>