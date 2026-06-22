package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.Repository.AssetRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.AssetService;
import com.tatastrive.erp.JAM.Enterprises.dto.AssetDto;
import com.tatastrive.erp.JAM.Enterprises.mapper.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
public class AssetServiceImplementation implements AssetService {

    @Autowired
    private AssetMapper assetMapper;
    @Autowired
    private AssetRepository assetRepository;



    @Override
    public AssetDto saveAsset(Asset asset) {
        Asset savedAsset = assetRepository.save(asset);
        return assetMapper.toDTO(savedAsset);
    }


    public AssetDto updateAsset(Long id, Asset asset) {

        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset Not Found"));

        existingAsset.setAssetName(asset.getAssetName());
        existingAsset.setAssetType(asset.getAssetType());
        existingAsset.setEmployee(asset.getEmployee());

        Asset updatedAsset = assetRepository.save(existingAsset);

        return assetMapper.toDTO(updatedAsset);
    }

    @Override
    public List<AssetDto> getAllAsset() {
        return assetRepository.findAll()
         .stream()
                .map(assetMapper::toDTO)
                .toList();
    }

    public AssetDto getAssetById(Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset Not Found"));
        return assetMapper.toDTO(asset);
    }
@Override
    public void deleteAsset(Long id) {
    Asset asset = assetRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Asset Not Found"));

    assetRepository.delete(asset);
}
}
