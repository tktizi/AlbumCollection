package com.example.albumCollection.Service;

import com.example.albumCollection.Entity.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbums();

    Album saveAlbum(Album album);

    Album getAlbumById(Long id);

    Album updateAlbum(Album album);

    Album deleteAlbumById(Long id);
}
