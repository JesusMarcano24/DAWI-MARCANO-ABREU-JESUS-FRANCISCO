package pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    private String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        //Mandamos aributos a la vista html como si fuera un viewbag
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail( @PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @GetMapping("/edit/{id}")
    public String edit( @PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }
}
