package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __index extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/index.jsp", 1471516005750L ,"12.1.1.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!-- index.html -->\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <!-- CSS ===================== -->\r\n    <!-- load bootstrap -->\r\n    <link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css\"> \r\n    <style>\r\n        body    { padding-top:30px; }\r\n    </style>\r\n    \r\n    <!-- JS ===================== -->\r\n    <!-- load angular -->\r\n    <script src=\"http://code.angularjs.org/1.2.6/angular.js\"></script> \r\n    <script src=\"app.js\"></script>\r\n</head>\r\n\r\n<!-- apply angular app and controller to our body -->\r\n<body ng-app=\"validationApp\" ng-controller=\"mainController\">\r\n<div class=\"container\">\r\n<div class=\"col-sm-8 col-sm-offset-2\">\r\n    \r\n    <!-- PAGE HEADER -->\r\n    <div class=\"page-header\"><h1>AngularJS Form Validation</h1></div>\r\n   \r\n    <!-- FORM -->\r\n    <!-- pass in the variable if our form is valid or invalid -->\r\n    <form name=\"userForm\" ng-submit=\"submitForm(userForm.$valid)\" novalidate> <!-- novalidate prevents HTML5 validation since we will be validating ourselves -->\r\n\r\n        <!-- NAME -->\r\n        <div class=\"form-group\">\r\n            <label>Name</label>\r\n            <input type=\"text\" name=\"name\" class=\"form-control\" ng-model=\"name\" required>\r\n        </div>\r\n\r\n        <!-- USERNAME -->\r\n        <div class=\"form-group\">\r\n            <label>Username</label>\r\n            <input type=\"text\" name=\"username\" class=\"form-control\" ng-model=\"user.username\" ng-minlength=\"3\" ng-maxlength=\"8\">\r\n        </div>\r\n        \r\n        <!-- EMAIL -->\r\n        <div class=\"form-group\">\r\n            <label>Email</label>\r\n            <input type=\"email\" name=\"email\" class=\"form-control\" ng-model=\"email\">\r\n        </div>\r\n        \r\n        <!-- SUBMIT BUTTON -->\r\n        <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n        \r\n    </form>\r\n\r\n</div><!-- col-sm-8 -->\r\n</div><!-- /container -->\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            __ee.setStackTrace(weblogic.jsp.internal.jsp.utils.SMAPUtils.loadSMAP(this.getClass()).processStackTrace(__ee.getStackTrace()));
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
