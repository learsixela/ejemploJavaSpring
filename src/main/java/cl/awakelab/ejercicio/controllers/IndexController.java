package cl.awakelab.ejercicio.controllers;

import cl.awakelab.ejercicio.models.Profesor;
import cl.awakelab.ejercicio.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private HttpSession httpSession;

    // Mapea nuestra página base de la página
    @RequestMapping
    public String index(){
        // ruta: (webapp)/WEB-INF/jsp/   index.jsp
        return "index.jsp";
    }

    // Entrega al usuario el formulario de inscripción
    @GetMapping("/profesor")
    public String profesor(Model model) {
        Profesor profesor = new Profesor();
        model.addAttribute("profesorModelo", profesor);
        return "profesor/profesor.jsp";
    }

    // En el formulario inicial, adherimos un nuevo profesor y recuperamos
    // el objeto creado a través de la anotación @ModelAttribute
    @PostMapping("/profesor/add")
    public String addProfesor(@ModelAttribute("profesorModelo") Profesor profesor,
                              Model model) {
        profesor = profesorService.save(profesor);
        httpSession.setAttribute("profesorSession", profesor);
        model.addAttribute("profesorModelo", profesor);
        System.out.println("SAVE");
        return "profesor/add.jsp";
    }

    // Eliminamos de la base de datos y deslogueamos de la sesión
    @RequestMapping("/profesor/delete")
    public String deleteProfesor() {
        Profesor profesorSession = (Profesor) httpSession.getAttribute("profesorSession");
        profesorService.delete(profesorSession.getId());
        System.out.println("DELETE");
        return "redirect:/profesor/logout";
    }

    // Redirigimos el profesor de la sesión para ser actualizado en update.jsp
    @RequestMapping("/profesor/update")
    public String updateProfesor(Model model) {
        Profesor profesorSession = (Profesor) httpSession.getAttribute("profesorSession");
        model.addAttribute("profesorModelo", profesorSession);
        System.out.println("UPDATE");
        return "profesor/update.jsp";
    }

    // Una vez el profesor ha sido actualizado, asignamos este al método .update()
    // (Revisar .jsp para ver el id del profesor oculto utilizado).
    // Además, para efectos prácticos, hacemos un cierre de sesión.
    @RequestMapping("/profesor/update/done")
    public String updateProfesorDone(@ModelAttribute("profesorModelo") Profesor profesor,
                                     Model model) {
        profesorService.update(profesor);
        profesor = profesorService.findOne(profesor.getId());
        httpSession.setAttribute("profesorSession", profesor);
        model.addAttribute("profesorModelo", profesor);
        return "redirect:/profesor/logout";
    }

    // Eliminar el atributo de sesión asignado al profesor
    @RequestMapping("/profesor/logout")
    public String logout(){
        httpSession.invalidate();
        return "index.jsp";
    }
}
