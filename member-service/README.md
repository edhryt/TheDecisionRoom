### Entities:
- Member(id, name, username, createdAt)
- Rating(id, rate)

### Aggregates:
- MemberAggregate:
    - Components:
      - Member
      - Rating
    - Invariants:
      - member cannot change their id
      - member cannot change their createdAt
      - member cannot change their name more than twice a week
      - member cannot change their rate on their own
      - member cannot have more than 1 Rating
      - member's Rating cannot be reassigned