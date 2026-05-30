package room.decision.the.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import room.decision.the.entity.MemberStatus;

public record UpdateMemberRequest(@JsonProperty("member_status") MemberStatus memberStatus,
                                  @JsonProperty("initiator_id") Long initiatorId) {
}
