package com.hotel.booking.services.impl;

import com.hotel.booking.services.StorageService;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public class FileSystemServiceImpl extends StorageService {
    private final Path rootLocation;

    public FileSystemServiceImpl(Path rootLocation) {
        this.rootLocation = rootLocation;
    }

    public String getStoreFileName(MultipartFile file, String id) {
//        String ext = FileNameU
        return "";
    }
}
