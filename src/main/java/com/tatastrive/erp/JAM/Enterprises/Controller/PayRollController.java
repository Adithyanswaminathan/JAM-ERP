package com.tatastrive.erp.JAM.Enterprises.Controller;

import com.tatastrive.erp.JAM.Enterprises.Entity.PayRoll;
import com.tatastrive.erp.JAM.Enterprises.Service.PayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayRollController
{
    @Autowired
    private PayRollService payRollService;
    @PostMapping("/add")
    public ResponseEntity<PayRoll> generatePayroll(@RequestBody PayRoll payroll) {
        return new ResponseEntity<>(payRollService.generatePayRoll(payroll),
                HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PayRoll>> getAllPayrolls() {
        return ResponseEntity.ok(payRollService.getAllPayRolls());
    }
}
