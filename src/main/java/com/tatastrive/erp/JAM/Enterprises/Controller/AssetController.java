package com.tatastrive.erp.JAM.Enterprises.Controller;

import com.tatastrive.erp.JAM.Enterprises.Entity.Asset;
import com.tatastrive.erp.JAM.Enterprises.Response.ApiResponse;
import com.tatastrive.erp.JAM.Enterprises.Service.AssetService;
import com.tatastrive.erp.JAM.Enterprises.dto.AssetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RequestMapping("/asset")
@RestController
public class AssetController {
    @Autowired
private AssetService assetService;

    @PostMapping
    public ResponseEntity<ApiResponse> addAsset(@RequestBody Asset asset) {
        try {
            AssetDto savedAsset = assetService.saveAsset(asset);

            return ResponseEntity.status(CREATED)
                    .body(new ApiResponse("Asset Added Successfully", savedAsset));

        } catch (Exception e) {

            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateAsset(
            @PathVariable Long id,
            @RequestBody Asset asset) {

        try {
            AssetDto updatedAsset = assetService.updateAsset(id, asset);

            return ResponseEntity.ok(
                    new ApiResponse("Asset Updated Successfully", updatedAsset)
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping
    public ResponseEntity<ApiResponse> getAllAsset(){
        try {
            List<AssetDto> assets= assetService.getAllAsset();
            return ResponseEntity.ok(new ApiResponse("Sucess",assets));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(),null));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getAssetById(@PathVariable Long id) {
        try {
            AssetDto asset = assetService.getAssetById(id);

            return ResponseEntity.ok(
                    new ApiResponse("Asset Retrieved Successfully", asset)
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAsset(@PathVariable Long id) {
        try {
            assetService.deleteAsset(id);

            return ResponseEntity.ok(
                    new ApiResponse("Asset Deleted Successfully", null)
            );

        } catch (Exception e) {

            return ResponseEntity.status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    }

