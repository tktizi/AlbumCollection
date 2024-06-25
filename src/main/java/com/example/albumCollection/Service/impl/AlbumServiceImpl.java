package com.example.albumCollection.Service.impl;

import com.example.albumCollection.Entity.Album;
import com.example.albumCollection.Repository.AlbumRepository;
import com.example.albumCollection.Service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        super();
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).get();
    }

    @Override
    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
        return null;
    }
}
