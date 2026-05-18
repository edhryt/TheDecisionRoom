### Entities:
- Discussion(id, issueId)
- Message(id, senderId, content, discussion, sentAt)

### Aggregates:
- RoomAggregate:
    - Components:
      - Discussion
      - Message
    - Invariants:
      discussion cannot exist without consortium (consortiumId != null)
      discussion cannot exist without issue (issueId != null)
      discussion cannot be opened if an issue wasn't published yet
      only one discussion can belong to a particular issue (UNIQUE(issueId))
      Issue.consortiumId must be equal to consortiumId (?)
      discussion cannot be opened for closed issue
      discussion cannot be deleted if it has messages
      message cannot exist without discussion
      message cannot exist without sender
      message content cannot be empty or blank
      message content cannot exceed 5000 symbols
      message createdAt cannot be changed
      senderId must belong to the same consortium (otherwise anyone can send messages to any discussion)
      message cannot be sent to archived/closed discussion
      message cannot be edited/updated after 1 hour
      message cannot be created in future (createdAt <= now)