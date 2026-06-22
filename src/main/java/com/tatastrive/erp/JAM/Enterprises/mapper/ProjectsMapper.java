package com.tatastrive.erp.JAM.Enterprises.mapper;

import com.tatastrive.erp.JAM.Enterprises.Entity.Projects;
import com.tatastrive.erp.JAM.Enterprises.dto.ProjectsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {

    @Mapping(source = "projectId", target = "projectId")
    ProjectsDto toDTO(Projects projects);

    Projects toEntity(ProjectsDto dto);
}
