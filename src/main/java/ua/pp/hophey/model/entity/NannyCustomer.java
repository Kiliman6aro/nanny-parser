package ua.pp.hophey.model.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class NannyCustomer {

    private Long externalId;

    private String phoneNumber;

    private final NannyProfile profile;

    private final NannyInfo info;

    private final NannyExperience experience;

    private final NannyPreferencesPosition preferencesPositionDto;
}
