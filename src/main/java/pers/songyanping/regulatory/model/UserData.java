package pers.songyanping.regulatory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    Integer uid;
    String userName;
    String password;
    String email;
    Integer roleId;

    public Integer getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getRoleId() {
        return this.roleId;
    }
}
