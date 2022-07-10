package com.example.sberJulia.services;

import com.example.sberJulia.model.*;
import com.example.sberJulia.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentDeliveryService {

    @Autowired
    private DataContentFromCMSImlp dataContentFromCMS;
    @Autowired
    private TargetFromAMSImlp targetFromAMSI;
    @Autowired
    private TargetForUsersImlp targetForUsers;
    @Autowired
    private ViewedImpl viewed;
    @Autowired
    private ViewedRepo viewedRepo;

    public ResponseEntity saveDataContentFromCMS(ModelPublishedContentList dataContent) {
        for (ModelPublishedContent content : dataContent.getContent()) {
            dataContentFromCMS.setDataContent(content.getContentGuid(), content.getData());
        }
        return printLineDone();
    }

    public ResponseEntity saveTargetFromAMS(ModelTargetOffers targetOffers) {
        String page = targetOffers.getPage();
        Date startDate = targetOffers.getStartDate();
        Date endDate = targetOffers.getEndDate();
        for (ModelTarget target : targetOffers.getTarget()) {
            String userGuid = target.getUserGuid();
            for (ModelOffersTarget offersTarget : target.getOffers()) {
                String contentGuid = offersTarget.getContentGuid();
                int priority = offersTarget.getPriority();
                targetFromAMSI.setTarget(userGuid, contentGuid, page, priority, startDate, endDate);
            }
        }
        return printLineDone();
    }

    public ResponseEntity saveViewed(ModelViewers viewers) {
        for (ModelViewed view : viewers.getViewed()) {
            String contentGuid = view.getContentGuid();
            String userGuid = view.getUserGuid();
            viewed.setViewed(contentGuid, userGuid);
        }
        return printLineDone();
    }

    public ModelViewers getViewed() {
        return viewedRepo.getViewedForAms();
    }

    public OffersModel getOffers(ModelTargetPage userPage) {
        var result = targetForUsers.getTargetForUsers(userPage.getUser_guid());
        List<ModelOffers> offers = new ArrayList<>();
        for (var model : result) {
            offers.add(new ModelOffers(model));
        }
        return new OffersModel(offers);
    }

    private ResponseEntity printLineDone() {
        return ResponseEntity.ok("Выполнено добавление данных!");
    }

}

