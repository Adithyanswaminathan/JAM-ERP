package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.dto.AssetDto;

import java.util.List;

public interface AssetService {

    AssetDto saveAsset(Asset asset);

    AssetDto updateAsset(Long id, Asset asset);

    List<AssetDto> getAllAsset();

    AssetDto getAssetById(Long id);

    void deleteAsset(Long id);
}

