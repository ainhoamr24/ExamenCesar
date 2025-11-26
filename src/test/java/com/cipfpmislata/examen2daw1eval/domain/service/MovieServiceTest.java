package com.cipfpmislata.examen2daw1eval.domain.service;

import com.cipfpmislata.examen2daw1eval.domain.exception.ValidationException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.domain.repository.MovieRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private CrewRepository crewRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    void shouldThrowExceptionWhenDirectorDoesNotExist() {
        Movie movie = new Movie(null, "Title", 2020, 120, "Desc",
                new Crew(99L, null, null, null), List.of());

        when(crewRepository.findDirectorById(99L)).thenReturn(Optional.empty());

        assertThrows(ValidationException.class, () -> movieService.create(movie));
        verify(crewRepository).findDirectorById(99L);
        verify(crewRepository, never()).findActorById(anyLong());
        verify(movieRepository, never()).save(movie);
    }

    @Test
    void shouldThrowExceptionWhenActorDoesNotExist() {
        Movie movie = new Movie(null, "Title", 2020, 120, "Desc",
                new Crew(1L, null, null, null),
                List.of(new Crew(99L, null, null, null)));

        when(crewRepository.findDirectorById(1L)).thenReturn(Optional.of(new Crew(1L, "Director", 1980, null)));
        when(crewRepository.findActorById(99L)).thenReturn(Optional.empty());

        assertThrows(ValidationException.class, () -> movieService.create(movie));
        verify(crewRepository).findDirectorById(1L);
        verify(crewRepository).findActorById(99L);
        verify(movieRepository, never()).save(movie);
    }
}
