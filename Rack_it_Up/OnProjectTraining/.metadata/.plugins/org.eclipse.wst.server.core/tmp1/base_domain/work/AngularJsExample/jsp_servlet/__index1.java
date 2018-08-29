package jsp_servlet;

import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __index1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/index1.jsp", 1471516540999L ,"12.1.1.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Insert title here</title>\r\n\r\n <script src=\"http://code.angularjs.org/1.2.6/angular.js\"></script> \r\n    <script src=\"/AngularJsExample/WebContent/app1.js\"></script>\r\n</head>\r\n<body>\r\n<div ng-controller=\"index1\">\r\n\t<div>\r\n\t\tFavorite word: <input type=\"text\" ng-model=\"favoriteWord\" />\r\n\t\t- {{favoriteWord}}\r\n\t</div>\r\n\t<div>\r\n\t\tFavorite color:\r\n\t\t<input type=\"radio\" name=\"fc\" value=\"Red\" ng-model=\"favoriteColor\">Red</input>\r\n\t\t<input type=\"radio\" name=\"fc\" value=\"Green\" ng-model=\"favoriteColor\">Green</input>\r\n\t\t<input type=\"radio\" name=\"fc\" value=\"Yellow\" ng-model=\"favoriteColor\">Yellow</input>\r\n\t\t<input type=\"radio\" name=\"fc\" value=\"Blue\" ng-model=\"favoriteColor\">Blue</input>\r\n\t\t- {{favoriteColor}}\r\n\t</div>\r\n\t<div>\r\n\t\tFavorite shape:\r\n\t\t<select ng-model=\"favoriteShape\">\r\n\t\t\t<option value=\"Circle\">Circle</option>\r\n\t\t\t<option value=\"Triangle\">Triangle</option>\r\n\t\t\t<option value=\"Square\">Square</option>\r\n\t\t</select>\r\n\t\t- {{favoriteShape}}\r\n\t</div>\r\n</div>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
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
