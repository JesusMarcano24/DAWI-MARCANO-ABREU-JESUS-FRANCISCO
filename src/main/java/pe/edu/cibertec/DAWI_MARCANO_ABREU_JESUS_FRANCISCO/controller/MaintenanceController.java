package pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmCreateDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.LanguageDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.repository.LanguageRepository;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/start")
    private String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
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

    @GetMapping("/create")
    public String create(Model model) {
        List<LanguageDto> languages = maintenanceService.findAllLanguages();
        model.addAttribute("languages", languages);
        return "maintenance_create";
    }

    @PostMapping("/create")
    public String createFilm(@ModelAttribute FilmCreateDto filmCreateDto) {
        boolean success = maintenanceService.createFilm(filmCreateDto);
        if (success) {
            return "redirect:/maintenance/start";
        }
        return "redirect:/maintenance/create";
    }

    @PostMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Integer id, Model model) {
        System.out.println("Eliminando " + id);
        try {
            maintenanceService.deleteFilm(id);
            return "redirect:/maintenance/start";
        } catch (Exception e) {
            return "redirect:/maintenance/start";
        }
    }
}
