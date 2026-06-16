package com.tatastrive.erp.JAM.Enterprises.Service.ServiceImplementation;


import com.tatastrive.erp.JAM.Enterprises.Entity.PayRoll;
import com.tatastrive.erp.JAM.Enterprises.Repository.PayRollRepository;
import com.tatastrive.erp.JAM.Enterprises.Service.PayRollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayRoleImplimentation implements PayRollService
{
    private final PayRollRepository payRollRepository;

    @Override
    public PayRoll generatePayRoll(PayRoll payRoll)
    {
        double basicSalary = payRoll.getBasicSalary();
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        double  tax = basicSalary * 0.05;
        double netSalary = basicSalary + hra + da + payRoll.getBonus() - tax - payRoll.getDeduction();
        payRoll.setNetSalary(netSalary);
        return payRollRepository.save(payRoll);
    }

    @Override
    public List<PayRoll> getAllPayRolls() {
        return payRollRepository.findAll();
    }
}
