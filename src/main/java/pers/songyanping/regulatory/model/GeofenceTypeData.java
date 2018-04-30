package pers.songyanping.regulatory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeofenceTypeData {
    Integer fencingTypeId;
    String fencingTypeName;

    public Integer getFencingTypeId () {
        return this.fencingTypeId;
    }
}
