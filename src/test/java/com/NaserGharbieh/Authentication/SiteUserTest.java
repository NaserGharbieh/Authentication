package com.NaserGharbieh.Authentication;
import com.NaserGharbieh.Authentication.models.Post;
import com.NaserGharbieh.Authentication.models.SiteUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SiteUserTest {

    @Test
    public void testCreateSiteUser() {
        // Create a new SiteUser
        SiteUser user = new SiteUser("testuser", "password");

        // Verify that the user object is not null
        assertNotNull(user);

        // Verify the attributes of the user object
        assertEquals("testuser", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a new SiteUser
        SiteUser user = new SiteUser();

        // Set attributes using setters
        user.setId(1L);
        user.setUsername("testuser");
        user.setPassword("password");

        // Verify the values using getters
        assertEquals(1L, user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testPostsAttribute() {
        // Create a new SiteUser
        SiteUser user = new SiteUser();

        // Create a list of posts
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("Post 1", user);
        Post post2 = new Post("Post 2", user);
        posts.add(post1);
        posts.add(post2);

        // Set the posts attribute
        user.setPosts(posts);

        // Verify that the posts attribute is set correctly
        assertEquals(2, user.getPosts().size());
        assertEquals("Post 1", user.getPosts().get(0).getPostText());
        assertEquals("Post 2", user.getPosts().get(1).getPostText());
    }
}
