package com.registro.registroelettronico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TeacherRequestDTO extends UserRequestDTO{

    @NotEmpty
    @Valid
    private List<SubjectClassRequestDTO> materie;

}
