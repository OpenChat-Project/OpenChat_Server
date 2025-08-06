package com.open.chatapp.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserDepartmentId implements Serializable {

    private Long user_id;
    private Long dept_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDepartmentId)) return false;
        UserDepartmentId that = (UserDepartmentId) o;
        return Objects.equals(user_id, that.user_id) &&
               Objects.equals(dept_id, that.dept_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, dept_id);
    }

}
