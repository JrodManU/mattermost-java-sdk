package com.jrodmanu.mattermostjavasdk.models.common;

/**
 * Representation of Mattermost File
 */
public class FileInfo {
    public String id;
    public String userId;
    public String postId;
    public long createAt;
    public long updateAt;
    public long deleteAt;
    public String name;
    public String extension;
    public int size;
    public int mimeType;
    public int width;
    public int height;
    public boolean hasPreviewImage;
}
