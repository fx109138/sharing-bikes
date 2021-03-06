package com.fx.sharingbikes.bike.service;

import com.fx.sharingbikes.bike.entity.BikeLocation;
import com.fx.sharingbikes.common.exception.SharingBikesException;
import com.fx.sharingbikes.user.entity.UserElement;

public interface BikeService {
    void generateBike() throws SharingBikesException;

    void unLockBike(UserElement currentUser, Long bikeNo) throws SharingBikesException;

    void lockBike(BikeLocation bikeLocation) throws SharingBikesException;

    void reportLocation(BikeLocation bikeLocation) throws SharingBikesException;
}
