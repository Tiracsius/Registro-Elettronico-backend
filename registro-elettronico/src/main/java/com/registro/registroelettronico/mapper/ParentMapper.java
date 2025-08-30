package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.ParentRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.enums.UserRole;

import org.springframework.stereotype.Component;

@Component
public class ParentMapper {

    public ParentInfo toEntity(ParentRequestDTO request) {
        return ParentInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

    }
    
    public UserResponseDTO toUserResponse(ParentInfo parent) {
   	 return UserResponseDTO.builder()
   			 .id(parent.getId())
   			 .firstName(parent.getFirstName())
   			 .lastName(parent.getLastName())
   			 .role(UserRole.PARENT)
   			 .email(parent.getEmail())
   			 .build();
   }
}
