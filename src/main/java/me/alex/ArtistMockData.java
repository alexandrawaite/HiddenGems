package me.alex;

import java.util.*;

public class ArtistMockData {
    private List<Artist> artists;

    private static ArtistMockData instance = null;
    public static ArtistMockData getInstance() {
        if (instance == null) {
            instance = new ArtistMockData();
        }

        return instance;
    }

    public ArtistMockData() {
        artists = new ArrayList<Artist>();

        artists.add(new Artist(1, "Bomba Estereo", "Colombia", "Dance", "Bomba Estereo is a Colombian group based in Bogota that weds tropical, cumbia, vallenato, and champeta rhythms to electro, reggae, and pop in a unique form of dance music."));
        artists.add(new Artist(2, "Mulatu Astatke", "Ethiopia", "Jazz", "Ethiopian musician, composer, and arranger Mulatu Astatke is a household name in his native country, where he is known as the father of Ethio-jazz, a unique blend of pop, modern jazz, traditional Ethiopian music, Latin rhythms, Caribbean reggae, and Afro-funk."));
        artists.add(new Artist(3, "Pizzicato Five", "Japan", "J-Pop", "Pizzicato Five was a Japanese pop band formed in Tokyo. The group, widely credited with spearheading the Shibuya-kei movement of Tokyo in the 1990s, is known for electric and energetic compositions that often pay homage to late 1960s English-language pop music."));
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public Artist getArtistById(int id) {
        for (Artist a: artists) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public HashMap<String,List<Artist>> getArtistsByCountry(String country) {
        List<Artist> artistsByGenre = new ArrayList<Artist>();

        HashMap<String, List<Artist>> artistsByCountry = new HashMap<String, List<Artist>>();

        for (Artist a: artists) {
            if (a.getCountry().toLowerCase().equals(country.toLowerCase())) {
                Set <Map.Entry <String, List<Artist>>> entrySet = artistsByCountry.entrySet();
                artistsByCountry.put(a.getGenre(), artistsByGenre);

                for (Map.Entry entry : entrySet) {
                    if (entry.getKey() == a.getGenre()) {
                        artistsByCountry.get(entry.getKey()).add(a);
                    }
                }
            }
        }

        return artistsByCountry;
    }


    public List<Artist> getArtistsByCountryAndGenre(String country, String genre) {
        List<Artist> artistsByCountryAndGenre = new ArrayList<Artist>();

        for (Artist a: artists) {
            if (a.getCountry().toLowerCase().equals(country.toLowerCase()) && a.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                artistsByCountryAndGenre.add(a);
            }
        }

        return artistsByCountryAndGenre;
    }
}
