package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;

import java.util.List;

public interface AssetService {
    public Asset saveAsset(Asset asset);

    List<Asset> getAllAsset();

    public void deleteAsset(Long id);
}
