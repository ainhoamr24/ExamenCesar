package com.cipfpmislata.examen2daw1eval.controller;

import com.cipfpmislata.examen2daw1eval.domain.exception.ValidationException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.domain.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    void shouldReturnMovieListCorrectly() throws Exception {
        Movie movie = new Movie(1L, "Test Movie", 2020, 120, "Description",
                new Crew(1L, "Director", 1980, null), List.of());
        Page<Movie> page = new Page<>(List.of(movie), 1, 20, 1);

        when(movieService.findAll(anyInt(), anyInt())).thenReturn(page);

        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].title").value("Test Movie"));
    }

    @Test
    void shouldReturn401WhenInsertingInvalidMovie() throws Exception {
        doThrow(new ValidationException("Validation Error")).when(movieService).create(any());

        String json = """
                {
                    "title": "Invalid",
                    "year": 2020,
                    "runtime": 120,
                    "description": "Desc",
                    "directorId": 1,
                    "actorIds": []
                }
                """;

        mockMvc.perform(post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isUnauthorized());
    }
}
