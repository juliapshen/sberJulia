package com.example.sberJulia.repository;

import com.example.sberJulia.model.ModelContent;

import java.util.List;

public interface TargetForUsersImlp {
    List<ModelContent> getTargetForUsers(String userGuid);
}
