package com.NaserGharbieh.Authentication;

import com.NaserGharbieh.Authentication.models.Post;
import com.NaserGharbieh.Authentication.models.SiteUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostTest {

    @Test
    public void testCreatePost() {
        // Create a new SiteUser
        SiteUser user = new SiteUser("testuser", "password");

        // Create a new Post
        Post post = new Post("Test post", user);


        assertNotNull(post);

        // Verify the attributes of the post object
        assertEquals("Test post", post.getPostText());
        assertEquals(user, post.getPostBySiteUser());
    }

    @Test
    public void testSettersAndGetters() {

        SiteUser user = new SiteUser("testuser", "password");


        Post post = new Post();


        post.setPostId(1L);
        post.setPostText("Test post");
        post.setPostBySiteUser(user);

        // Verify the values using getters
        assertEquals(1L, post.getPostId());
        assertEquals("Test post", post.getPostText());
        assertEquals(user, post.getPostBySiteUser());
    }


}
