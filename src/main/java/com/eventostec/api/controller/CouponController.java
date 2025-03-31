package com.eventostec.api.controller;

import com.eventostec.api.domain.coupon.Coupom;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.repositories.CouponRepository;
import com.eventostec.api.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping
    public ResponseEntity<Coupom> addCouponsToEvent(@PathVariable UUID eventId, @RequestBody CouponRequestDTO data){
        Coupom coupons = couponService.addCouponToEvent(eventId, data);
        return ResponseEntity.ok(coupons);
    }
}
