package com.tatastrive.erp.JAM.Enterprises.Service;

import com.tatastrive.erp.JAM.Enterprises.Entity.PayRoll;

import java.util.List;

public interface PayRollService
{
    PayRoll generatePayRoll(PayRoll payRoll);
    List<PayRoll> getAllPayRolls();
}
