package com.registro.registroelettronico.dto;

import java.util.UUID;

import com.registro.registroelettronico.enums.SchoolClassLabel;

public record ClassSummaryDTO(UUID id, SchoolClassLabel name) {}
