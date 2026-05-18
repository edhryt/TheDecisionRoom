### Entities:
- Room(id, name, username, createdAt)
- MemberRoomDetails(id, memberId, status)

### Aggregates:
- RoomAggregate:
  - Components:
    - Room
    - MemberRoomDetails
  - Invariants:
    - member cannot join non-existent room
    - member cannot join twice a room
    - member cannot join more than 20 rooms
    - member cannot leave a room if they aren't its participant
    - member cannot rejoin a room if they were banned
    - member cannot create more than 20 rooms