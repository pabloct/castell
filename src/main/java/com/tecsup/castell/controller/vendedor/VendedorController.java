package com.tecsup.castell.controller.vendedor;

import com.tecsup.castell.helper.CastellException;
import com.tecsup.castell.model.Persona;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("persona")
@RequestMapping("/adm/vendedor")
public class VendedorController {

    @Autowired
    VendedorService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("vendedores", service.allVendedor());
        return "vendedor/index";
    }

    @RequestMapping("create")
    public String create(Model model) {

        model.addAttribute("persona", new Persona());
        return "vendedor/formulario";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {

        Persona persona = service.findVendedor(id);
        model.addAttribute("persona", persona);
        return "vendedor/formulario";
    }

    @RequestMapping("save")
    public String save(@ModelAttribute @Valid Persona persona, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "vendedor/formulario";
        }
        service.save(persona);
        return "redirect:/adm/vendedor";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {

        service.delete(id);
        return "redirect:/adm/vendedor";
    }

    @RequestMapping("estado/{id}")
    public String changeEstado(@PathVariable("id") Long id) {

        service.changeEstado(id);
        return "redirect:/adm/vendedor";
    }
    
    /* primera prueba captar error via tomcat
    @ExceptionHandler(CastellException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Error en el flujo")
    public void handlerException(){
        
    }*/
    
    /* seguda prueba captar error via nueva vista
    @ExceptionHandler(CastellException.class)
    public ModelAndView handlerException(HttpServletRequest rq, Exception ex){
        ModelAndView vistaError = new ModelAndView();
        
        vistaError.setViewName("helper/error");
        vistaError.addObject("mensaje", ex.getMessage());
        return vistaError;
                
    }*/
}
