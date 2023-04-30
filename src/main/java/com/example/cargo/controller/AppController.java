package com.example.cargo.controller;

import java.util.List;


import com.example.cargo.Entity.Cargo;
import com.example.cargo.Service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @Autowired
    private CargoService service;


    @RequestMapping("/home")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Cargo> listCargos = service.listAll(keyword);
        model.addAttribute("listCargos", listCargos);
        model.addAttribute("keyword", keyword);
        return "index";
    }


    @RequestMapping("/new")
    public String showNewCargoForm(Model model) {
        Cargo cargo = new Cargo();
        model.addAttribute("cargo", cargo);
        return "new_cargo";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCargo(@ModelAttribute("cargo") Cargo cargo) {
        service.save(cargo);
        return "redirect:/home";
    }

    @RequestMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String showEditCargoForm(@PathVariable(value = "id") Long id, Model model) {
        Cargo cargo = service.get(id);
        model.addAttribute("cargo", cargo);
        return "edit_cargo";
    }

    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteCargo(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return "redirect:/home";
    }

    @RequestMapping("/gist")
    public String gist(Model model, @Param("keyword") String keyword) {
        List<Cargo> listCargos = service.listAll(keyword);
        model.addAttribute("listCargos", listCargos);
        model.addAttribute("keyword", keyword);
        return "gist";
    }


}
