package com.tatastrive.erp.JAM.Enterprises.dto.assetdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class AssetDto{

        private Long assetId;
        private String assetName;
        private String assetType;

        private Long employeeId;
        private String employeeName;
    }

