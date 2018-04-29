package pers.songyanping.regulatory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleData {
    Integer id;
    String name;
    String description;

    public Integer getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
