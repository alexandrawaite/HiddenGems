# Hidden Gems

A music application to discover hidden gems from around the world. How many of you have heard music from Bangladesh? What about Tanzania? This application allows you to explore artists by countries to unearth musical treasures.

This REST API is built with Java, Spring Boot (version 1.5.9) and Maven. 

# RESTful API Design

The following REST endpoints are available:

| HTTP Verb        | URL           | Description  | Response |
| ------------- |-------------|:-----| ----|
| `GET` | `http://localhost:8080/artists` | Get a list of all artists | `[ { artist object }, { artist object } ... ]` |
| `GET` | `http://localhost:8080/artist/{id}` | Get the artist corresponding to the artist ID | `{ artist object }` |
| `GET` | `http://localhost:8080/countries` | Get a list of country names | `[ country names in strings ]` |
| `GET` | `http://localhost:8080/artists/{country}` | Get lists of artists categorized by genre | `{ genre_name: [ { artists object }, ... ], genre_name2: ... }` |
| `GET` | `http://localhost:8080/artists/{country}/{genre}` | Get a list of artists corresponding to the country and genre | `[ { artist object },  { artist object } ...]` |

 
Artist object:

`{ id, name, country, genre, bio, list of album objects }`

Album object:

`{ id, title, album_art, release_year, list of song objects }`
