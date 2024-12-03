package pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.service;

import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {
    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);
}
