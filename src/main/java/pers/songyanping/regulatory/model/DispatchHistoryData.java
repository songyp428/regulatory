package pers.songyanping.regulatory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DispatchHistoryData {
    Integer id;
    String inputPoint;
    String inputLngLat;
    String outputPoint;
    String outputLngLat;
    Long deliveryTime;
}
