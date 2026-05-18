### Entities:
- MemberActivity(id, actorId, targetId, activityType, timestamp)

### Aggregates:
- RoomAggregate:
    - Components:
      - MemberActivity
    - Invariants:
      member cannot exceed authority according to their status in a consortium
      member cannot delete more than 3 issues. If so, they cannot do any activity regarding issues on that day