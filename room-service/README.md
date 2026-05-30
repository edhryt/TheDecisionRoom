### Entities:
- Room(id, name, username, createdAt)
- MemberDetails(id, memberId, roomId, memberStatus)

### Invariants:
- member cannot join non-existent room
- member cannot join twice a room
- member cannot leave a room if they aren't its participant
- member cannot rejoin a room if they were banned
- the overall member's room count cannot be greater than 10