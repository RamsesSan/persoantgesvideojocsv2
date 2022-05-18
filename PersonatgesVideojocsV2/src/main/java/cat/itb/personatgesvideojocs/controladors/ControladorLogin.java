package cat.itb.personatgesvideojocs.controladors;

import cat.itb.personatgesvideojocs.model.entitats.Usuari;
import cat.itb.personatgesvideojocs.model.serveis.ServeiUsuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class ControladorLogin {
    @Autowired
    private ServeiUsuari servei;

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuari", new Usuari());
        return "register";
    }

    @PostMapping("/registration")
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("usuari") Usuari e){
        e.setRol("USER");
        servei.add(e);
        return "redirect:/";
    }
}
