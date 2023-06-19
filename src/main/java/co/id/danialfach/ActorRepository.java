package co.id.danialfach;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class ActorRepository {
    @Repository
    public class ActorRepository {

        private List<Actor> mockActors;
        private MovieRepository movieRepository;

        public ActorRepository(MovieRepository movieRepository) {
            this.movieRepository = movieRepository;
        }

        @PostConstruct
        private void initializeMockActors() {
            mockActors = new ArrayList<>(List.of(
                    new Actor(1, "Ega Gofur", "1964-09-02", List.of(movieRepository.getById(1L), movieRepository.getById(2L), movieRepository.getById(3L))),
                    new Actor(2, "Abin News", "1964-09-02", List.of(movieRepository.getById(1L), movieRepository.getById(2L), movieRepository.getById(3L)))
            )
            );
        }

        public Actor getById(Long id) {
            return mockActors
                    .stream()
                    .filter(actor -> actor.id().equals(id))
                    .findFirst()
                    .orElse(null);
        }
    }
}
