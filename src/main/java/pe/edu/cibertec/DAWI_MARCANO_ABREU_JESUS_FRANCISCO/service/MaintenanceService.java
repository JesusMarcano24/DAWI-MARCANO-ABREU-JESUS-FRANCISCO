package pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmCreateDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.FilmDto;
import pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto.LanguageDto;

import java.util.List;

public interface MaintenanceService {
    @Cacheable(value = "films")
    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    @CacheEvict(value = "films", allEntries = true)
    Boolean updateFilm(FilmDetailDto filmDetailDto);

    @CacheEvict(value = "films", allEntries = true)
    Boolean createFilm(FilmCreateDto filmCreateDto);

    @Cacheable(value = "languages")
    List<LanguageDto> findAllLanguages();

    @CacheEvict(value = "films", allEntries = true)
    Boolean deleteFilm(int id);
}
