package com.NaserGharbieh.Authentication.Repositories;

import com.NaserGharbieh.Authentication.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {
    SiteUser findByUsername(String username);

}
