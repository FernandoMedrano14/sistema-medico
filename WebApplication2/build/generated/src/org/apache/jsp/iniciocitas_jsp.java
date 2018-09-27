package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class iniciocitas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_form_action;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_submit_value_styleClass_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_form_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.release();
    _jspx_tagPool_html_form_action.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico\" />\n");
      out.write("        <link href=\"css/styleinicio.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Inicio Citas</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("                <img id=\"logo\" src=\"https://res.cloudinary.com/disputebills/image/upload/v1462474206/blue-mark_cnzgry.png\">\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"btn btn-outline-info\" href=\"inicio.jsp\">Inicio <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-outline-info\" href=\"#\">Galeria</a>\n");
      out.write("                    </li>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"btn btn-outline-info dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Opciones\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"inicioproveedores.jsp\">Proveedores</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"inicioFarmacias.jsp\">Farmacias</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"inicioconsultorios.jsp\">Consultorios</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"inicioespecialidades.jsp\">Especialidades</a>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-outline-info\" href=\"mantenimientoFarmacias.jsp\">Agregar Farmacia</a>\n");
      out.write("                    </li>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    ");
      if (_jspx_meth_html_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                    <a href=\"mantenimientoUsuarios.jsp\" class=\"btn btn-outline-info my-2 my-sm-0\" margin=\"2px\">Agregar Usuario</a>\n");
      out.write("                    <p>   </p>\n");
      out.write("                    <a href=\"#\" class=\"btn btn-outline-info disabled\">Configuracion</a>\n");
      out.write("                    <p>   </p>\n");
      out.write("                    <a href=\"loginStruts.jsp\" class=\"btn btn-outline-danger my-2 my-sm-0\">Salir</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("    <center><h2>¡BIENVENIDOS A CITAS!</center></h2>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"demo\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("\n");
      out.write("    <!-- Indicators -->\n");
      out.write("    <ul class=\"carousel-indicators\">\n");
      out.write("        <li data-target=\"#demo\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("        <li data-target=\"#demo\" data-slide-to=\"1\"></li>\n");
      out.write("        <li data-target=\"#demo\" data-slide-to=\"2\"></li>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <!-- The slideshow -->\n");
      out.write("    <div class=\"carousel-inner\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"carousel-item active\">\n");
      out.write("            <img src=\"cit1.jpg\" alt=\"Los Angeles\" width=\"1100\" height=\"500\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"carousel-item\">\n");
      out.write("            <img src=\"cit2.jpg\" alt=\"Chicago\" width=\"1100\" height=\"500\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"carousel-item\">\n");
      out.write("            <img src=\"cit3.png\" alt=\"New York\" width=\"1100\" height=\"500\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Left and right controls -->\n");
      out.write("    <a class=\"carousel-control-prev\" href=\"#demo\" data-slide=\"prev\">\n");
      out.write("        <span class=\"carousel-control-prev-icon\"></span>\n");
      out.write("    </a>\n");
      out.write("    <a class=\"carousel-control-next\" href=\"#demo\" data-slide=\"next\">\n");
      out.write("        <span class=\"carousel-control-next-icon\"></span>\n");
      out.write("    </a>\n");
      out.write("    <style>\n");
      out.write("        /* Make the image fully responsive */\n");
      out.write("        .carousel-inner img {\n");
      out.write("            width: 1650px;\n");
      out.write("            height: 400px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-12\">\n");
      out.write("\n");
      out.write("            <center><h1>\t\n");
      out.write("\n");
      out.write("\n");
      out.write("                    Servicio orientado a agendar citas para usuarios que necesiten atención medica.\n");
      out.write("\n");
      out.write("                </h1></center>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_html_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:form
    org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_html_form_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_form_0.setPageContext(_jspx_page_context);
    _jspx_th_html_form_0.setParent(null);
    _jspx_th_html_form_0.setAction("/MantenimientoFarmacias");
    int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
    if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_html_submit_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_html_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_form_action.reuse(_jspx_th_html_form_0);
      return true;
    }
    _jspx_tagPool_html_form_action.reuse(_jspx_th_html_form_0);
    return false;
  }

  private boolean _jspx_meth_html_submit_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_0 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_0.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_submit_0.setStyleClass("btn btn-outline-info");
    _jspx_th_html_submit_0.setProperty("action");
    _jspx_th_html_submit_0.setValue("Consultar_Farmacias");
    int _jspx_eval_html_submit_0 = _jspx_th_html_submit_0.doStartTag();
    if (_jspx_th_html_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_0);
      return true;
    }
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_0);
    return false;
  }
}
