<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
<div>
    <form action="/upload" method="POST" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="上传">
    </form>
</div>
</body>
</html>