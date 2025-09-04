package com.registro.registroelettronico.dto;

import com.registro.registroelettronico.enums.SchoolClassLabel;

import java.util.UUID;

public record StudentSummaryDTO(UUID id, String firstName, String lastName){}