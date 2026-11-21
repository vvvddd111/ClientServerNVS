package ru.university.equiprent.dto;

import java.time.LocalDateTime;

public record ReportRequestedEvent(
        String reportId,
        Long saleId,
        LocalDateTime requestedAt
) {}