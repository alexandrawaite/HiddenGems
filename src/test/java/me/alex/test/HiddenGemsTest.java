package me.alex.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HiddenGemsTest extends ApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllArtists() throws Exception {
        mockMvc.perform(get("/artists")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$[0].name", is("Bomba Estereo")))
            .andExpect(jsonPath("$[1].name", is("Mulatu Astatke")))
            .andExpect(jsonPath("$[2].name", is("Pizzicato Five")));
    }

    @Test
    public void testGetCountries() throws Exception {
        mockMvc.perform(get("/countries")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$[0]", is("Colombia")))
            .andExpect(jsonPath("$[1]", is("Ethiopia")))
            .andExpect(jsonPath("$[2]", is("Japan")));

    }

    @Test
    public void testGetArtist() throws Exception {
        mockMvc.perform(get("/artist/3")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value("3"))
            .andExpect(jsonPath("$.name").value("Pizzicato Five"))
            .andExpect(jsonPath("$.country").value("Japan"));
    }

    @Test
    public void testGetArtistsByCountry() throws Exception {
        mockMvc.perform(get("/artists/colombia")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.Dance[0].id").value("1"))
            .andExpect(jsonPath("$.Dance[0].name").value("Bomba Estereo"));
    }

    @Test
    public void testGetArtistsByCountryAndGenre() throws Exception {
        mockMvc.perform(get("/artists/ethiopia/jazz")).andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$[0].name", is("Mulatu Astatke")));
    }
}
