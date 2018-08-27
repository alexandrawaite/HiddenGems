package me.alex;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArtistController {

    ArtistMockData artistMockData = ArtistMockData.getInstance();
    CountryMockData countryMockData = CountryMockData.getInstance();

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return artistMockData.getArtists();
    }

    @GetMapping("/countries")
    public List<String> getCountries() {
        return countryMockData.getCountries();
    }

    @GetMapping("/artist/{id}")
    public Artist getArtist(@PathVariable String id) {
        int artistId = Integer.parseInt(id);
        return artistMockData.getArtistById(artistId);
    }

    @GetMapping("/artists/{country}")
    public HashMap<String,List<Artist>> getArtistsByCountry(@PathVariable String country) {
        return artistMockData.getArtistsByCountry(country);
    }

    @GetMapping("/artists/{country}/{genre}")
    public List<Artist> getArtistsByCountryAndGenre(@PathVariable String country, @PathVariable String genre) {
        return artistMockData.getArtistsByCountryAndGenre(country, genre);
    }
}
