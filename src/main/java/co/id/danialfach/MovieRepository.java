package co.id.danialfach;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    private List<Movie> mockMovies;
    @PostConstruct
    public void initializeMockMovies() {
        mockMovies = new ArrayList<>(List.of(
                new Movie(1, "Ngodeng Sampek Mati", 1999, List.of("Action", "Sci-Fi"), "Mas Roni 27"),
                new Movie(2, "Di PHP Bapak", 2003, List.of("sedih", "Sci-Fi"), "The Wachowskis"),
                new Movie(3, "The Matrix Revolutions", 2003, List.of("Action", "Sci-Fi"), "The sicks")
        )
        );
    }

    public Movie getById(Long id) {
        return mockMovies.stream().filter(movie -> movie.id().equals(id)).findFirst().orElse(null);
    }

    public void addMovie(Movie movie) {
        mockMovies.add(movie);
    }
}
