package pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.dto;

public record FilmCreateDto(String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures) {
}