package pers.songyanping.regulatory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleData {
    String bikeId;
    String enterprise;
    long deliveryTime;
    String cardType;
}
