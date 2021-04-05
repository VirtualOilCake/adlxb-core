package com.oilman.adlxb.core;

import java.util.Date;

import static com.oilman.adlxb.core.CoreConstants.postNumberIncreaseSpeed;
import static com.oilman.adlxb.core.OwnerEnum.*;


/**
 * Possible owners of a post
 *
 * @author oilman
 * @version 2.0.0
 * @since 2.0.0
 */
enum OwnerEnum {
    USER, ROBOT, TEST
}

/**
 * Bot post
 *
 * @author oilman
 * @version 2.0.0
 * @see IslandPost
 * @since 2.0.0
 */
class BotPost extends IslandPost {
    public BotPost(String content) {
        super(content, ROBOT);
    }
}

/**
 * User post
 *
 * @author oilman
 * @version 2.0.0
 * @see IslandPost
 * @since 2.0.0
 */
class UserPost extends IslandPost {
    public UserPost(String content) {
        super(content, USER);
    }
}

/**
 * A Post is part of a Thread.
 * Contents information about the cookie, actual contents, etc.
 *
 * @author oilman
 * @version 2.0.0
 * @since 2.0.0
 */
public class IslandPost implements Comparable<IslandPost> {
    public static long basePostNumber = 35741657 + IslandUtils.random().nextInt(postNumberIncreaseSpeed);
    private final long postNumber;
    private final String cookie;
    private final String content;
    private final Date createTime;
    private final OwnerEnum owner;

    /**
     * the most complex constructor
     *
     * @param postNumber  the "No." thing of this post
     * @param cookie      cookie of this post
     * @param content     content of this post
     * @param createdTime created time of this post
     * @param owner       owner of this post (USER or ROBOT)
     * @throws IllegalArgumentException when the cookie or content is null or blank
     */
    public IslandPost(long postNumber, String cookie, String content, Date createdTime, OwnerEnum owner)
        throws IllegalArgumentException {
        if (content == null || cookie == null) {
            throw new IllegalArgumentException("Error when creating the Post: content or cookie is null");
        }
        if (content.isBlank() || cookie.isBlank()) {
            throw new IllegalArgumentException("Error when creating the Post: content or cookie is blank");
        }
        this.postNumber = postNumber;
        this.cookie = cookie;
        this.content = content;
        this.createTime = createdTime;
        this.owner = owner;
    }

    /**
     * Constructor that only used for test!
     */
    public IslandPost() {
        this(0, "test_cookie", "test_content", new Date(), TEST);
    }

    /**
     * The simplest constructor
     * Create a object with random index (0-100) and cookie
     *
     * @param content content in the post
     * @param owner   owner of the post (USER or ROBOT)
     */
    public IslandPost(String content, OwnerEnum owner) {
        this(basePostNumber, content, owner);
        basePostNumber += IslandUtils.random().nextInt(postNumberIncreaseSpeed) + 1;
    }

    /**
     * Constructor with random cookie and specified index
     *
     * @param postNumber index of this post
     * @param content    content in the post
     * @param owner      owner of the post (USER or ROBOT)
     */
    public IslandPost(long postNumber, String content, OwnerEnum owner) {
        this(postNumber, IslandUtils.getANewCookie(), content, new Date(), owner);
    }


    /**
     * compare the contents
     *
     * @param islandPost another object
     * @return true if the contents are the same, false otherwise
     */
    public boolean contentsAreTheSame(IslandPost islandPost) {
        return islandPost.content.equals(this.content);
    }

    /**
     * @return a String that describes this object
     */
    @Override
    public String toString() {
        return "No. " + postNumber +
            " | Cookie: " + cookie +
            " | Content: " + content +
            " | Created Time: " + createTime +
            " | Owner: " + owner.toString()
            ;
    }

    /**
     * User Index to determine the order
     *
     * @param o Another IslandPost object
     * @return int bigger than one if this index is bigger
     * smaller if smaller
     * 0 if they are the same
     */
    @Override
    public int compareTo(IslandPost o) {
        return (int) (this.postNumber - o.postNumber);
    }


    /**
     * Getter for the cookie.
     *
     * @return cookie
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * Getter for content
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * Getter for create time
     *
     * @return createTime
     */
    public Date getCreatedTime() {
        return createTime;
    }

    /**
     * Getter for post number
     *
     * @return post number
     */
    public long getPostNumber() {
        return postNumber;
    }

    /**
     * Getter for the owner
     *
     * @return the owner
     */
    public OwnerEnum getOwner() {
        return owner;
    }

}
