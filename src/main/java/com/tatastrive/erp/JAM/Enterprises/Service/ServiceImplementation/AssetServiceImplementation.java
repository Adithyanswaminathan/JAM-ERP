package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.Repository.AssetRepository;
import com.tatastrive.erp.JAM.Enterprises.Repository.AttendanceRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetServiceImplementation implements AssetService {
    @Autowired
    private AssetRepository assetRepository;



    @Override
    public Asset saveAsset(Asset asset){
       return assetRepository.save(asset);

    }

    @Override
    public List<Asset> getAllAsset() {
        return assetRepository.findAll();
    }
@Override
    public void deleteAsset(Long id) {
     assetRepository.deleteById(id);
}
}
