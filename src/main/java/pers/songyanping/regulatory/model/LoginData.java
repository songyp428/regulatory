package pers.songyanping.regulatory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
    String userName;
    String password;

    public String getName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}
