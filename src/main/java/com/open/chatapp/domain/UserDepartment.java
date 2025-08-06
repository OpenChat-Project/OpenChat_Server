package com.open.chatapp.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class UserDepartment {

	@EmbeddedId
    private UserDepartmentId id;

    @ManyToOne
    @MapsId("user_id")  // 복합키의 필드 이름과 매핑
    private User user;

    @ManyToOne
    @MapsId("dept_id")
    private Department department;

    // 생성자
    public UserDepartment(User user, Department department) {
        this.user = user;
        this.department = department;
        this.id = new UserDepartmentId(user.getUser_id(), department.getDept_id());
    }
}
