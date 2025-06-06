package com.pratik.restaurant.services;

import jakarta.annotation.Resource; // For dependency injection or resource references (might not be needed here)
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

/**
 * StorageService defines the contract for storing and retrieving files
 * in a storage system (e.g., file system, cloud, database).
 */
public interface StorageService {

    /**
     * Stores a file with a custom filename.
     *
     * @param file     the uploaded file to store (usually from a client)
     * @param filename the desired name to store the file as
     * @return the storage ID or filename used to retrieve the file later
     */
    String store(MultipartFile file, String filename);

    /**
     * Loads a file as a Resource by its ID or filename.
     *
     * @param id the identifier used to locate the file
     * @return an Optional containing the Resource if found, or empty if not
     */
    Optional<Resource> loadAsResource(String id);
}
