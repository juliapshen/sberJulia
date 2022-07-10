package com.example.sberJulia.controller;

import com.example.sberJulia.model.*;
import com.example.sberJulia.services.ContentDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contentDelivery")
public class ContentDeliveryController {

    @Autowired
    private ContentDeliveryService contentDeliveryService;

    /**
     * Фиксация просмотра таргетированного предложения
     *
     * @param viewers - ModelViewers [] - содержит список просмотров List<ModelViewed>
     * @return код состояния
     */
    @PostMapping("/saveViewed")
    public ResponseEntity saveViewed(@RequestBody ModelViewers viewers) {
        try {
            return contentDeliveryService.saveViewed(viewers);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }

    }

    /**
     * Хранение и получение информации о содержимом контента от CMS
     *
     * @param content - ModelPublishedContentList [] - содержит список контентов List<ModelPublishedContent>
     * @return код состояния
     */
    @PostMapping("/dataContentFromCMS")
    public ResponseEntity dataContentFromCMS(@RequestBody ModelPublishedContentList content) {

        return contentDeliveryService.saveDataContentFromCMS(content);
    }

    /**
     * Хранение и получение информации о таргете от AMS
     *
     * @param target - ModelTargetOffers []
     * @return код состояния
     */
    @PostMapping("/saveTargetFromAMS")
    public ResponseEntity saveTargetFromAMS(@RequestBody ModelTargetOffers target) {

        return contentDeliveryService.saveTargetFromAMS(target);

    }

    /**
     * Выгрузка информации о просмотрах в AMS
     *
     * @return код состояния
     */
    @PostMapping("/method")
    public ModelViewers method() {
        return contentDeliveryService.getViewed();

    }

    /**
     * Передача таргета пользователю в разрезе страницы с учетом приоритета
     *
     * @param userPage guid пользователя
     * @return код состояния
     */
    @PostMapping("/getOffers")
    public OffersModel getOffers(@RequestBody ModelTargetPage userPage) {
        return contentDeliveryService.getOffers(userPage);
    }
}

