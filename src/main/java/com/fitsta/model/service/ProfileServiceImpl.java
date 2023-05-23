package com.fitsta.model.service;

import com.fitsta.model.dao.ProfileDao;
import com.fitsta.model.dto.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    private ProfileDao proFileDao;

    @Autowired
    public void setProFileDao(ProfileDao proFileDao) {
        this.proFileDao = proFileDao;
    }


    @Override
    public Profile getProfile(int userId) {
        Profile profile = new Profile();
        profile.setFollowerCount(proFileDao.getFollowerCount(userId));
        profile.setFollowingCount(proFileDao.getFollowingCount(userId));
        profile.setPostList(proFileDao.getPostList(userId));
        profile.setPostCount(profile.getPostList().size());
        profile.setProfileImg(proFileDao.getProfileImg(userId));
        profile.setNickname(proFileDao.getUserNickname(userId));
        return profile;
    }
}
