package com.tatastrive.erp.JAM.Enterprises.mapper;
import org.mapstruct.Mapper;
import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.dto.AssetDto;

@Mapper(componentModel = "spring")
public interface AssetMapper {

    AssetDto toDTO(Asset asset);

    Asset toEntity(AssetDto dto);
}
