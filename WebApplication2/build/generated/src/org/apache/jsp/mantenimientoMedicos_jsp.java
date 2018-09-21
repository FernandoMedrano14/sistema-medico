package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mantenimientoMedicos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_notEmpty_property_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_option_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_form_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_property;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_iterate_property_name_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_text_size_property_maxlength_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_logic_notEmpty_property_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_submit_value_styleClass_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_option_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_form_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_select_property = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_iterate_property_name_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_text_size_property_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_logic_notEmpty_property_name.release();
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.release();
    _jspx_tagPool_html_option_value.release();
    _jspx_tagPool_html_form_action.release();
    _jspx_tagPool_html_select_property.release();
    _jspx_tagPool_logic_iterate_property_name_id.release();
    _jspx_tagPool_html_text_size_property_maxlength_nobody.release();
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/Style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico\" />\n");
      out.write("        <title>Matenimiento Clinicas</title>\n");
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
      out.write("                            Areas\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu bg-info \" aria-labelledby=\"navbarDropdown\">\n");
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
      out.write("                <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                    <a href=\"mantenimientoUsuarios.jsp\" class=\"btn btn-outline-info my-2 my-sm-0\" margin=\"2px\">Agregar Usuario</a>\n");
      out.write("                    <p>  </p>\n");
      out.write("                    <a href=\"#\" class=\"btn btn-outline-info disabled\">Configuracion</a>\n");
      out.write("                    <p>   </p>\n");
      out.write("                    <a href=\"loginStruts.jsp\" class=\"btn btn-outline-danger my-2 my-sm-0\">Salir</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        ");
      //  html:form
      org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_html_form_action.get(org.apache.struts.taglib.html.FormTag.class);
      _jspx_th_html_form_0.setPageContext(_jspx_page_context);
      _jspx_th_html_form_0.setParent(null);
      _jspx_th_html_form_0.setAction("/MantenimientoMedicos");
      int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
      if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("            <br>\n");
          out.write("            <br>\n");
          out.write("            <br>\n");
          out.write("            <br>\n");
          out.write("            <br>\n");
          out.write("            <br>\n");
          out.write("            <h4 align=\"center\">Formulario de ingreso para nuevo médico</h4>\n");
          out.write("            <h4 align=\"center\">Ingrese la Informacion del médico</h4>\n");
          out.write("            <br>\n");
          out.write("            <div class=\"container\">\n");
          out.write("                <div class=\"row\">\n");
          out.write("                    <div class=\"col-12\">\n");
          out.write("                        <table class=\"table table-striped\">\n");
          out.write("                            <thead align=\"center\">\n");
          out.write("                            <th>Id Especialidad</th>\n");
          out.write("                            <th>Nombres Medico</th>\n");
          out.write("                            <th>Apellidos Medico</th>\n");
          out.write("                            <th>Especialidad</th>\n");
          out.write("                            <th>Teléfono</th>\n");
          out.write("                            <th>Acciones</th>\n");
          out.write("                            <th>Extra</th>\n");
          out.write("                            </thead>\n");
          out.write("                            <tbody align=\"center\">\n");
          out.write("                            <td>\n");
          out.write("                                ");
          //  html:select
          org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_property.get(org.apache.struts.taglib.html.SelectTag.class);
          _jspx_th_html_select_0.setPageContext(_jspx_page_context);
          _jspx_th_html_select_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
          _jspx_th_html_select_0.setProperty("idEspecialidad");
          int _jspx_eval_html_select_0 = _jspx_th_html_select_0.doStartTag();
          if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_html_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_html_select_0.doInitBody();
            }
            do {
              out.write("\n");
              out.write("                                    ");
              //  logic:notEmpty
              org.apache.struts.taglib.logic.NotEmptyTag _jspx_th_logic_notEmpty_0 = (org.apache.struts.taglib.logic.NotEmptyTag) _jspx_tagPool_logic_notEmpty_property_name.get(org.apache.struts.taglib.logic.NotEmptyTag.class);
              _jspx_th_logic_notEmpty_0.setPageContext(_jspx_page_context);
              _jspx_th_logic_notEmpty_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_0);
              _jspx_th_logic_notEmpty_0.setName("ActionFormMedicos");
              _jspx_th_logic_notEmpty_0.setProperty("listaEspecilidad");
              int _jspx_eval_logic_notEmpty_0 = _jspx_th_logic_notEmpty_0.doStartTag();
              if (_jspx_eval_logic_notEmpty_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("                                        ");
                  //  logic:iterate
                  org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = (org.apache.struts.taglib.logic.IterateTag) _jspx_tagPool_logic_iterate_property_name_id.get(org.apache.struts.taglib.logic.IterateTag.class);
                  _jspx_th_logic_iterate_0.setPageContext(_jspx_page_context);
                  _jspx_th_logic_iterate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_notEmpty_0);
                  _jspx_th_logic_iterate_0.setId("ver");
                  _jspx_th_logic_iterate_0.setName("ActionFormMedicos");
                  _jspx_th_logic_iterate_0.setProperty("listaEspecilidad");
                  int _jspx_eval_logic_iterate_0 = _jspx_th_logic_iterate_0.doStartTag();
                  if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_logic_iterate_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_logic_iterate_0.doInitBody();
                    }
                    do {
                      out.write("\n");
                      out.write("                                            ");
                      if (_jspx_meth_html_option_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_logic_iterate_0, _jspx_page_context))
                        return;
                      out.write("\n");
                      out.write("                                        ");
                      int evalDoAfterBody = _jspx_th_logic_iterate_0.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_logic_iterate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_logic_iterate_property_name_id.reuse(_jspx_th_logic_iterate_0);
                    return;
                  }
                  _jspx_tagPool_logic_iterate_property_name_id.reuse(_jspx_th_logic_iterate_0);
                  out.write("\n");
                  out.write("                                    ");
                  int evalDoAfterBody = _jspx_th_logic_notEmpty_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_logic_notEmpty_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_0);
                return;
              }
              _jspx_tagPool_logic_notEmpty_property_name.reuse(_jspx_th_logic_notEmpty_0);
              out.write("\n");
              out.write("                                ");
              int evalDoAfterBody = _jspx_th_html_select_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_html_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_html_select_property.reuse(_jspx_th_html_select_0);
            return;
          }
          _jspx_tagPool_html_select_property.reuse(_jspx_th_html_select_0);
          out.write("\n");
          out.write("                            </td>\n");
          out.write("                            <td>");
          if (_jspx_meth_html_text_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
            return;
          out.write("</td>\n");
          out.write("                            <td>");
          if (_jspx_meth_html_text_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
            return;
          out.write("</td>\n");
          out.write("                            <td>");
          if (_jspx_meth_html_text_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
            return;
          out.write("</td>\n");
          out.write("                            <td>");
          if (_jspx_meth_html_text_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
            return;
          out.write("</td>\n");
          out.write("                            <td>");
          if (_jspx_meth_html_submit_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
            return;
          out.write("</td>\n");
          out.write("                            <td>");
          if (_jspx_meth_html_submit_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
            return;
          out.write("</td>\n");
          out.write("                            </tbody>\n");
          out.write("                        </table>\n");
          out.write("                        <p align=\"center\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${advertencia}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                    </div>\n");
          out.write("                </div>\n");
          out.write("            </div>\n");
          out.write("            <div class=\"row\">\n");
          out.write("                <div class=\"col-4\">\n");
          out.write("                    <h4>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h4> \n");
          out.write("                </div>\n");
          out.write("            </div>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_html_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_html_form_action.reuse(_jspx_th_html_form_0);
        return;
      }
      _jspx_tagPool_html_form_action.reuse(_jspx_th_html_form_0);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_html_option_0(javax.servlet.jsp.tagext.JspTag _jspx_th_logic_iterate_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:option
    org.apache.struts.taglib.html.OptionTag _jspx_th_html_option_0 = (org.apache.struts.taglib.html.OptionTag) _jspx_tagPool_html_option_value.get(org.apache.struts.taglib.html.OptionTag.class);
    _jspx_th_html_option_0.setPageContext(_jspx_page_context);
    _jspx_th_html_option_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
    _jspx_th_html_option_0.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ver.idEspecialidad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_html_option_0 = _jspx_th_html_option_0.doStartTag();
    if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_option_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_option_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                                ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ver.idEspecialidad}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_html_option_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_option_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_option_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_option_value.reuse(_jspx_th_html_option_0);
      return true;
    }
    _jspx_tagPool_html_option_value.reuse(_jspx_th_html_option_0);
    return false;
  }

  private boolean _jspx_meth_html_text_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_0 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_0.setPageContext(_jspx_page_context);
    _jspx_th_html_text_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_text_0.setProperty("nombre");
    _jspx_th_html_text_0.setSize("40");
    _jspx_th_html_text_0.setMaxlength("100");
    int _jspx_eval_html_text_0 = _jspx_th_html_text_0.doStartTag();
    if (_jspx_th_html_text_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_0);
      return true;
    }
    _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_0);
    return false;
  }

  private boolean _jspx_meth_html_text_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_1 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_1.setPageContext(_jspx_page_context);
    _jspx_th_html_text_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_text_1.setProperty("apellido");
    _jspx_th_html_text_1.setSize("20");
    _jspx_th_html_text_1.setMaxlength("100");
    int _jspx_eval_html_text_1 = _jspx_th_html_text_1.doStartTag();
    if (_jspx_th_html_text_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_1);
      return true;
    }
    _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_1);
    return false;
  }

  private boolean _jspx_meth_html_text_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_2 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_2.setPageContext(_jspx_page_context);
    _jspx_th_html_text_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_text_2.setProperty("especialidad");
    _jspx_th_html_text_2.setSize("20");
    _jspx_th_html_text_2.setMaxlength("100");
    int _jspx_eval_html_text_2 = _jspx_th_html_text_2.doStartTag();
    if (_jspx_th_html_text_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_2);
      return true;
    }
    _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_2);
    return false;
  }

  private boolean _jspx_meth_html_text_3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:text
    org.apache.struts.taglib.html.TextTag _jspx_th_html_text_3 = (org.apache.struts.taglib.html.TextTag) _jspx_tagPool_html_text_size_property_maxlength_nobody.get(org.apache.struts.taglib.html.TextTag.class);
    _jspx_th_html_text_3.setPageContext(_jspx_page_context);
    _jspx_th_html_text_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_text_3.setProperty("telefono");
    _jspx_th_html_text_3.setSize("20");
    _jspx_th_html_text_3.setMaxlength("100");
    int _jspx_eval_html_text_3 = _jspx_th_html_text_3.doStartTag();
    if (_jspx_th_html_text_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_3);
      return true;
    }
    _jspx_tagPool_html_text_size_property_maxlength_nobody.reuse(_jspx_th_html_text_3);
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
    _jspx_th_html_submit_0.setStyleClass("btn btn-info");
    _jspx_th_html_submit_0.setProperty("action");
    _jspx_th_html_submit_0.setValue("Agregar");
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
    _jspx_th_html_submit_1.setStyleClass("btn btn-outline-info");
    _jspx_th_html_submit_1.setProperty("action");
    _jspx_th_html_submit_1.setValue("Consultar Medicos");
    int _jspx_eval_html_submit_1 = _jspx_th_html_submit_1.doStartTag();
    if (_jspx_th_html_submit_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_1);
      return true;
    }
    _jspx_tagPool_html_submit_value_styleClass_property_nobody.reuse(_jspx_th_html_submit_1);
    return false;
  }
}
