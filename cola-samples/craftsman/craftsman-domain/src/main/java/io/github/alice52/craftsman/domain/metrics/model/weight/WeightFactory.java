package io.github.alice52.craftsman.domain.metrics.model.weight;

import io.github.alice52.craftsman.domain.userprofile.model.Role;

public class WeightFactory {
    public static Weight get(Role role) {
        if (role == Role.DEV) {
            return DevWeight.singleton;
        }
        if (role == Role.QA) {
            return QAWeight.singleton;
        }
        return OtherWeight.singleton;
    }
}
