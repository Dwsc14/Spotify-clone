package com.Utilities;

import java.util.ArrayList;
import java.util.List;

import com.Models.Playlist;

public class UserPreferenceAnalyzer {
    
    //  dựa trên playlist có chung tác giả nhiều nhất, sau đó lấy ra 10 bài ngẫu nhiên trong
    // playlist đấy không trùng với bài đã có

    private final DatabaseConnector db;

    public UserPreferenceAnalyzer() throws Exception {
        db = new DatabaseConnector();
    }
}
