package ru.university.equiprent.dto;

public record CsvImportRowError(int lineNumber, String rawLine, String message) {

}
