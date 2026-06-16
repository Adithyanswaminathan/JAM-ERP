package com.tatastrive.erp.JAM.Enterprises.Controller;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/asset")
@RestController
public class AssetController {
    @Autowired
private AssetService assetService;

    @PostMapping("/saveAsset")
    public Asset saveAsset(@RequestBody Asset asset){
        return assetService.saveAsset(asset);

    }
    @GetMapping("/getAsset")
    public List<Asset> getAllAsset(){
        return assetService.getAllAsset();
    }
    @DeleteMapping("/{id}")
public void deleteAsset(@PathVariable Long id){
         assetService.deleteAsset(id);

    }
}
