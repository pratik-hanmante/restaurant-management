package com.pratik.restaurant.services.impl;

// Import interfaces and classes for storage service functionality
import com.pratik.restaurant.services.StorageService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

// Marks this class as a Spring service for component scanning
@Service
// Enables logging with Lombok's @Slf4j annotation
@Slf4j
public class FileSystemStorageService implements StorageService {

    // Injects the value of 'app.storage.location' from application properties, defaults to 'uploads' if not set
    @Value("${app.storage.location:uploads}")
    private String storageLocation;

    // Root directory path for file storage
    private Path rootLocation;

    // Method called after dependency injection is complete to initialize storage directory
    @PostConstruct
    public void init() {
        // Set the root location using the injected storage location
        rootLocation = Paths.get(storageLocation);
        try {
            // Create the directory (and parent directories) if they do not exist
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            // Throw an unchecked exception if the directory cannot be created
            throw new SecurityException("could not initialze storage location", e);
        }
    }

    // Stores a file with the specified filename
    @Override
    public String store(MultipartFile file, String filename) {
        // Method not implemented yet, returns empty string
        return "";
    }

    // Loads a resource by its ID
    @Override
    public Optional<Resource> loadAsResource(String id) {
        // Method not implemented yet, returns Optional.empty()
        return Optional.empty();
    }
}