package com.NaserGharbieh.Authentication.Repositories;

import com.NaserGharbieh.Authentication.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post,Long> {
}
