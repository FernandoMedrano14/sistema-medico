package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inicio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_form_styleClass_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_submit_value_styleClass_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_form_styleClass_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.release();
    _jspx_tagPool_html_form_styleClass_action.release();
    _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <!--<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("         <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("         <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>-->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico\" />\n");
      out.write("        <link href=\"css/styleinicio.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Inicio</title>\n");
      out.write("        <style>\n");
      out.write("            body {font-family: Arial, Helvetica, sans-serif;}\n");
      out.write("\n");
      out.write("            /* Full-width input fields */\n");
      out.write("            input[type=text], input[type=password] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 12px 20px;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                display: inline-block;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Set a style for all buttons */\n");
      out.write("            button {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            button:hover {\n");
      out.write("                opacity: 0.8;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Extra styles for the cancel button */\n");
      out.write("            .cancelbtn {\n");
      out.write("                width: auto;\n");
      out.write("                padding: 10px 18px;\n");
      out.write("                background-color: #f44336;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Center the image and position the close button */\n");
      out.write("            .imgcontainer {\n");
      out.write("                text-align: center;\n");
      out.write("                margin: 24px 0 12px 0;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            img.avatar {\n");
      out.write("                width: 80%;\n");
      out.write("                border-radius: 20%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                padding: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            span.psw {\n");
      out.write("                float: right;\n");
      out.write("                padding-top: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* The Modal (background) */\n");
      out.write("            .modal {\n");
      out.write("                display: none; /* Hidden by default */\n");
      out.write("                position: fixed; /* Stay in place */\n");
      out.write("                z-index: 1; /* Sit on top */\n");
      out.write("                left: 0;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%; /* Full width */\n");
      out.write("                height: 100%; /* Full height */\n");
      out.write("                overflow: auto; /* Enable scroll if needed */\n");
      out.write("                background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("                padding-top: 60px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Modal Content/Box */\n");
      out.write("            .modal-content {\n");
      out.write("                background-color: #fefefe;\n");
      out.write("                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\n");
      out.write("                border: 1px solid #888;\n");
      out.write("                width: 40%; /* Could be more or less, depending on screen size */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* The Close Button (x) */\n");
      out.write("            .close {\n");
      out.write("                position: absolute;\n");
      out.write("                right: 25px;\n");
      out.write("                top: 0;\n");
      out.write("                color: #000;\n");
      out.write("                font-size: 35px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .close:hover,\n");
      out.write("            .close:focus {\n");
      out.write("                color: red;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Add Zoom Animation */\n");
      out.write("            .animate {\n");
      out.write("                -webkit-animation: animatezoom 0.6s;\n");
      out.write("                animation: animatezoom 0.6s\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @-webkit-keyframes animatezoom {\n");
      out.write("                from {-webkit-transform: scale(0)} \n");
      out.write("                to {-webkit-transform: scale(1)}\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @keyframes animatezoom {\n");
      out.write("                from {transform: scale(0)} \n");
      out.write("                to {transform: scale(1)}\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Change styles for span and cancel button on extra small screens */\n");
      out.write("            @media screen and (max-width: 300px) {\n");
      out.write("                span.psw {\n");
      out.write("                    display: block;\n");
      out.write("                    float: none;\n");
      out.write("                }\n");
      out.write("                .cancelbtn {\n");
      out.write("                    width: 100%;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("// Get the modal\n");
      out.write("            var modal = document.getElementById('id01');\n");
      out.write("\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (event.target == modal) {\n");
      out.write("                    modal.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">\n");
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
      out.write("                        <a class=\"btn btn-outline-info\" href=\"inicio.jsp\">Inicio<span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"btn btn-outline-info\" href=\"#\">Galeria</a>\n");
      out.write("                    </li>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"btn btn-outline-info dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Areas\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu bg-info \" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"iniciopacientes.jsp\"><b>Pacientes</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"iniciomedicamentos.jsp\"><b>Medicamentos</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"iniciomedicos.jsp\"><b>Medicos</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"inicioclinicas.jsp\"><b>Clinicas</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"inicioproveedores.jsp\"><b>Proveedores</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"inicioFarmacias.jsp\"><b>Farmacias</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"inicioconsultorios.jsp\"><b>Consultorios</b></a>\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item bg-info text-white\" href=\"inicioespecialidades.jsp\"><b>Especialidades</b></a>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                ");
      if (_jspx_meth_html_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("            <div onload=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\"></div>\n");
      out.write("        <div id=\"id01\" class=\"modal\">\n");
      out.write("\n");
      out.write("            <div class=\"modal-content animate\">\n");
      out.write("                <div class=\"imgcontainer\">\n");
      out.write("                    <span onclick=\"document.getElementById('id01').style.display = 'none'\" class=\"close\" title=\"Close Modal\">&times;</span>\n");
      out.write("                    <img src=\"ACCESODENEGADO.png\" alt=\"Avatar\" class=\"avatar\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <h4 style=\"text-align: center\">El acceso fue negado porque la accion<br/>requiere permisos de administración</h4>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"container\" style=\"background-color:#f1f1f1\">\n");
      out.write("                    <button type=\"button\" onclick=\"document.getElementById('id01').style.display = 'none'\" class=\"btn btn-info\">Aceptar</button>                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("    <center><h2>¡ESTE ES NUESTRO SISTEMA MEDICO A SU SERVICIO!</center></h2>\n");
      out.write("<br>\n");
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
      out.write("            <img src=\"hos3.jpg\" alt=\"Los Angeles\" width=\"1100\" height=\"500\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"carousel-item\">\n");
      out.write("            <img src=\"hos4.jpg\" alt=\"Chicago\" width=\"1100\" height=\"500\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"carousel-item\">\n");
      out.write("            <img src=\"hos8.jpg\" alt=\"New York\" width=\"1100\" height=\"500\">\n");
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
      out.write("\n");
      out.write("    <style>\n");
      out.write("        /* Make the image fully responsive */\n");
      out.write("        .carousel-inner img {\n");
      out.write("            width: 1650px;\n");
      out.write("            height: 700px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</div>\n");
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
    org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_html_form_styleClass_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_form_0.setPageContext(_jspx_page_context);
    _jspx_th_html_form_0.setParent(null);
    _jspx_th_html_form_0.setAction("/AgregarUsuario");
    _jspx_th_html_form_0.setStyleClass("form-inline my-2 my-lg-0");
    int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
    if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_html_submit_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
          return true;
        out.write("<p>  </p>\n");
        out.write("                    ");
        if (_jspx_meth_html_submit_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
          return true;
        out.write("<p>  </p>\n");
        out.write("                    ");
        if (_jspx_meth_html_submit_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_html_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_form_styleClass_action.reuse(_jspx_th_html_form_0);
      return true;
    }
    _jspx_tagPool_html_form_styleClass_action.reuse(_jspx_th_html_form_0);
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
    _jspx_th_html_submit_0.setProperty("action");
    _jspx_th_html_submit_0.setValue("Agregar Usuario");
    _jspx_th_html_submit_0.setStyleClass("btn btn-outline-info my-2 my-sm-0");
    int _jspx_eval_html_submit_0 = _jspx_th_html_submit_0.doStartTag();
    if (_jspx_th_html_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_0);
      return true;
    }
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_0);
    return false;
  }

  private boolean _jspx_meth_html_submit_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_1 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_1.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_submit_1.setProperty("action");
    _jspx_th_html_submit_1.setValue("Configuracion");
    _jspx_th_html_submit_1.setStyleClass("btn btn-outline-info disabled");
    int _jspx_eval_html_submit_1 = _jspx_th_html_submit_1.doStartTag();
    if (_jspx_th_html_submit_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_1);
      return true;
    }
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_1);
    return false;
  }

  private boolean _jspx_meth_html_submit_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_2 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_2.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_submit_2.setProperty("action");
    _jspx_th_html_submit_2.setValue("Cerrar Sesion");
    _jspx_th_html_submit_2.setStyleClass("btn btn-outline-danger my-2 my-sm-0");
    _jspx_th_html_submit_2.setOnclick("return confirm('Esta apunto de cerrar sesion\\n¿Desea cerrar la sesion')");
    int _jspx_eval_html_submit_2 = _jspx_th_html_submit_2.doStartTag();
    if (_jspx_th_html_submit_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.reuse(_jspx_th_html_submit_2);
      return true;
    }
    _jspx_tagPool_html_submit_value_styleClass_property_onclick_nobody.reuse(_jspx_th_html_submit_2);
    return false;
  }
}
