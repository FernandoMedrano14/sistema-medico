package action;

import actionforms.ActionFormClinicas;
import actionforms.ActionFormEspecialidades;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

import persistencia.Clinicas;
import mantenimiento.MantenimientoClinicas;
import mantenimiento.MantenimientoFarmacias;
import persistencia.Farmacias;

public class ActionClinicas extends org.apache.struts.action.Action {

    private static final String Confirmar = "confirmarClinicas";
    private static final String Eliminar = "eliminarClinicas";//
    private static final String Error = "errorClinicas";
    private static final String guardado = "guardadoClinica";//
    private static final String AGREGAR = "irAgregarClinica";//
    private static final String confirmarID = "consultaIdClinica";//
    private static final String consultar = "consultarClinicas";//
    private static final String modificar = "modificarClinica";//
    private static final String irmodificar = "irmodificarClinica";//

    MantenimientoClinicas cli = new MantenimientoClinicas();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        ActionFormClinicas formCli = (ActionFormClinicas) form;
        Integer idClinica = formCli.getIdClinica();
        Integer idFarmacia = formCli.getIdFarmacia();
        String direccion = formCli.getDireccion();
        String horario = formCli.getHorario();
        String action = formCli.getAction();

        if (formCli == null || action == null) {
            return mapping.findForward(Error);
        }

        if (action.equals("Agregar Clinica")) {
            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();
            List<Farmacias> listaFarmacias = farmacia.consultarTodoFarmacias();
            formCli.setListaFarmacias(listaFarmacias);
            request.setAttribute("listaFarmacias", listaFarmacias);
            return mapping.findForward(AGREGAR);
        }
        if (action.equals("Agregar")) {
            String advertencia = "";

            if (idFarmacia == null || idFarmacia.equals("")) {
                advertencia = "Es necesario agregar el campo de farmacias";
            }
            if (direccion == null || direccion.equals("")) {
                advertencia = "es necesario agregar la direcicon";
            }
            if (horario == null || horario.equals("")) {
                advertencia = "es imprescindible agregar el horario";
            }
            if (!advertencia.equals("")) {
                formCli.setError("<span style='color:red'> Complete los campos sin rellenar" + "<br>" + advertencia + "</span>");
                return mapping.findForward(Error);
            }

            MantenimientoClinicas clinicas = new MantenimientoClinicas();
            MantenimientoFarmacias farmacia = new MantenimientoFarmacias();
            String respuesta = cli.guardar(idClinica, idFarmacia, direccion, horario);

            if (respuesta.equals("")) {
                /*List<Farmacias> lista = farmacias.setIdFarmacia(idFarmacia);*/
                formCli.setError("Error al guardar");
                return mapping.findForward(Error);
            }
            List<Farmacias> listaFarmacias = farmacia.consultarTodoFarmacias();
            formCli.setListaFarmacias(listaFarmacias);
            request.setAttribute("listaFarmacias", listaFarmacias);
            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro guardado:</strong> La Clinica ha sido guardada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            return mapping.findForward(guardado);
        }

        if (action.equals("Consultar_Clinicas")) {
            MantenimientoClinicas clinicas = new MantenimientoClinicas();
            List<Clinicas> lista = clinicas.mostrar();
            if (lista == null) {
                formCli.setError("<span style='color:white'>Usuario ya existente" + "<br></span>");
                return mapping.findForward(Error);
            } else {
                formCli.setListaClinicas(lista);
                return mapping.findForward(consultar);
            }
        }

        if (action.equals("Eliminar")) {
            MantenimientoClinicas clinicas = new MantenimientoClinicas();
            int idRecibido = (Integer.parseInt(request.getParameter("id")));

            if (clinicas.eliminar(idRecibido) == 0) {
                formCli.setError("<spam style='color:red'> El registro no existe" + "<br></spam>");
                return mapping.findForward(Error);
            } else {
                List<Clinicas> lista = clinicas.mostrar();
                formCli.setListaClinicas(lista);
                formCli.setIdClinica(idRecibido);
            }
            return mapping.findForward(Eliminar);
        }

        if (action.equals("BuscarId")) {
            MantenimientoClinicas clinicas = new MantenimientoClinicas();
            Integer idRecibido = (Integer.parseInt(request.getParameter("id")));
            Clinicas cl = clinicas.consultarId(idRecibido);
            
            formCli.setIdClinica(cl.getIdClinica());
            formCli.setIdFarmacia(cl.getFarmacias().getIdFarmacia());
            formCli.setDireccion(cl.getDireccion());
            formCli.setHorario(cl.getHorario());
            return mapping.findForward(confirmarID);
            
        }

        if (action.equals("Modificar")) {
            String advertencia = "";
            Clinicas c = new Clinicas();
            c.setIdClinica(idClinica);
            
            Farmacias f = new Farmacias();
            f.setIdFarmacia(idFarmacia);
            c.setFarmacias(f);
            
            c.setDireccion(direccion);
            c.setHorario(horario);

            MantenimientoClinicas cm = new MantenimientoClinicas();
            cm.modificar(idClinica, idFarmacia, direccion, horario);
            formCli.setError("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> La clinica ha sido modificada.\n</div>");
            formCli.setIdFarmacia(c.getFarmacias().getIdFarmacia());
            formCli.setDireccion(c.getDireccion());
            formCli.setHorario(c.getHorario());

            advertencia = ("<div class=\"alert alert-success\">\n<strong>Registro modificado:</strong> La clinica ha sido modificada.\n</div>");
            request.setAttribute("advertencia", advertencia);
            List<Clinicas> listc = cm.mostrar();
            formCli.setListaClinicas(listc);
            return mapping.findForward(consultar);
        }

        if (action.equals("irModificarClinicas")) {
            
            System.out.println("estoy en irModificar");
            String id = request.getParameter("id");
            idClinica = Integer.parseInt(id);
            
            System.out.println(id);
            MantenimientoClinicas clinica = new MantenimientoClinicas();
            Clinicas clinicas = clinica.consultarId(idClinica);
            formCli.setIdClinica(clinicas.getIdClinica());
            formCli.setDireccion(clinicas.getDireccion());

            return mapping.findForward(irmodificar);
        }

        return mapping.findForward(Confirmar);
    }
}
