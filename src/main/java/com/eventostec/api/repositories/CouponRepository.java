package com.eventostec.api.repositories;

import com.eventostec.api.domain.coupon.Coupom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepository extends JpaRepository<Coupom, UUID> {
}
