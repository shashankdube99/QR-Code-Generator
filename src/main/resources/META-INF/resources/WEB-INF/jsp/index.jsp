<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>QR Code Generator</title>
</head>
<body>
    <h1>Generate QR Code</h1>
    <form action="/api/qr/generate-base64" method="get">
        <input type="text" name="text" placeholder="Enter text" required/>
        <button type="submit">Generate QR</button>
    </form>
</body>
</html>
