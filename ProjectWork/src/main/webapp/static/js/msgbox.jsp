<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/msgbox.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/js/msgbox.css" />
</head>
<body>
<div class='xgalert'>
        <div class="modal-preview">
            <div class="modal modal-primary">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 id='alert_title' class="modal-title"></h4>
                        </div>
                        <div class="modal-body">
                            <p id='alert_des'></p>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-primary">确定</button>
                            <button type="button" class="btn btn-warning" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>