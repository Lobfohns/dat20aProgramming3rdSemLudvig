package com.example.paintings.controllers;

import com.example.paintings.models.Artist;
import com.example.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Artists {
    @Autowired
    ArtistRepository artists;

    @GetMapping("/artists")
    public Iterable<Artist> getArtists() {
        return artists.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist getArtist(@PathVariable Long id) {
        return artists.findById(id).get();
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist newArtist) {
        newArtist.setId(null);
        return artists.save(newArtist);
    }

    @PutMapping("/artists/{id}")
    public String updateArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith) {
        return artists.findById(id).map(foundArtist -> {
            foundArtist.setName(artistToUpdateWith.getName());
            foundArtist.setAge(artistToUpdateWith.getAge());
            foundArtist.setNationality(artistToUpdateWith.getNationality());
            foundArtist.setStyle(artistToUpdateWith.getStyle());
            foundArtist.setBirthDate(artistToUpdateWith.getBirthDate());
            foundArtist.setGender(artistToUpdateWith.getGender());
            artists.save(foundArtist);
            return "Artist updated";
        }).orElse("Artist not found");
    }

    @DeleteMapping("/artists/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artists.deleteById(id);
    }
}
