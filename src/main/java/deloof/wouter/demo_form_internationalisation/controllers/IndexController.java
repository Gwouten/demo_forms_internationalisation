package deloof.wouter.demo_form_internationalisation.controllers;

import deloof.wouter.demo_form_internationalisation.model.Snack;
import deloof.wouter.demo_form_internationalisation.model.SnackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    SnackDAO dao;

    @ModelAttribute(value = "snacks")
    public Iterable<Snack> getAllSnacks() {
        return dao.findAll();
    }

    @ModelAttribute(value = "nSnack")
    public Snack snackToSave() {
        return new Snack();
    }

    // Show all data from database
    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }

    // Add data to database
    @RequestMapping( value = "/add", method = RequestMethod.POST)
    public String saveSnack(@ModelAttribute("nSnack") @Valid Snack nSnack, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "index";
        }
        dao.save(nSnack);
        return "redirect:/index";
    }

    // Remove data from database
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSnack(@PathVariable(name = "id") int id) {
        dao.deleteById(id);
        return "redirect:/index";
    }
}
