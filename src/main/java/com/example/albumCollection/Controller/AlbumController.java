package com.example.albumCollection.Controller;

import com.example.albumCollection.Entity.Album;
import com.example.albumCollection.Service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    //handler method to handle list albums and return mode and view
    @GetMapping("/albums")
    public String listAlbums(Model model, @RequestParam(value = "success", required = false) String success) {
        if (success != null) {
            model.addAttribute("deleteMessage", "Album deleted successfully!");
        }
        model.addAttribute("albums", albumService.getAllAlbums());
        return "albums";
    }


    @GetMapping("/albums/new")
    public String createAlbumForm(Model model) {

        // create album object to hold album form data
        Album album = new Album();
        model.addAttribute("album", album);
        return "create_album";
    }

    @PostMapping("/albums")
    public String saveAlbum(@ModelAttribute("album") Album album) {
        albumService.saveAlbum(album);
        return "redirect:/albums";
    }

    @GetMapping("/albums/edit/{id}")
    public String editAlbumForm(@PathVariable Long id, Model model) {
        model.addAttribute("album", albumService.getAlbumById(id));
        return "edit_album";
    }

    @PostMapping("/albums/{id}")
    public String updateAlbum(@PathVariable Long id,
            @ModelAttribute("album") Album album,
            Model model) {

        //get album from db by Id
        Album existingAlbum = albumService.getAlbumById(id);
        existingAlbum.setId(id);
        existingAlbum.setTitle(album.getTitle());
        existingAlbum.setArtist(album.getArtist());
        existingAlbum.setYear(album.getYear());
        existingAlbum.setGenre(album.getGenre());
        existingAlbum.setRating(album.getRating());

        // save updated album object
        albumService.updateAlbum(existingAlbum);
        return "redirect:/albums";
    }

    //handler method to handle delete album requests
    @GetMapping("/albums/{id}")
    public String deleteAlbum(@PathVariable Long id, Model model) {
        albumService.deleteAlbumById(id);
        model.addAttribute("deleteMessage", "Album deleted successfully!");
        return "redirect:/albums?success";
    }

}

