package com.eventostec.api.service;

import com.eventostec.api.domain.coupon.Coupom;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.repositories.CouponRepository;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private EventRepository eventRepository;

    public Coupom addCouponToEvent(UUID eventId, CouponRequestDTO couponData){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not Found"));

        Coupom coupon = new Coupom();
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date(couponData.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);

    }
}
