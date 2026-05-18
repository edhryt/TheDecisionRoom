## Use cases:
- CreateMember
- UpdateMember
- UpdateMemberRating
- CreateRoom
- JoinRoom
- UpdateRoom
- PublishIssue
- ChooseOption
- OpenDiscussion
- SendMessage
- CloseDiscussion
- ExamineBiases
- OmitPastMistakes (hashtags of mistakes)
- MakeFinalDecision
  - the votes number
  - the overall rates number of all voters of an option
  - the result of a discussion
  - the suitable way to the goal
  - the result of omitting biases 
  - preventing making the same mistakes again
- CloseIssue
- Create(Decision/Option)Analysis
- Update(Decision/Option)Analysis
- DeleteRoom
- LeaveRoom

## Domain:
### Entities:
- Member(id, name, username, createdAt)
- Rating(id, rate, memberId)
- member cannot change their id
- member cannot change their createdAt
- member cannot change their name more than twice a week
- member cannot change their rate on their own
- member cannot have more than 1 Rating
- member's Rating cannot be reassigned


- Room(id, name, username, createdAt)
- MemberRoomDetails(id, memberId, roomId, memberStatus (MEMBER, MODERATOR, OWNER))
- member cannot join non-existent room
- member cannot join twice a room
- member cannot join more than 20 rooms
- member cannot leave a room if they aren't its participant
- member cannot rejoin a room if they were banned
- member cannot create more than 20 rooms


- Issue(id, roomId, creatorId, discussionId, chosenOptionId, 
title, status, createdAt)
- ChoiceOption(id, issueId, title)
- ChoiceOptionVoters(id, choiceOptionId, memberId)
- ChoiceRisk(id, riskName, probabilityPercentage)
- member cannot publish an issue if the previous one isn't solved
- if many members try to publish an issue, the right is granted to the first one
- an issue can be updated or deleted only within the trial period
  which is less than the time required to make a final decision
- member cannot delete non-existent issue
- member cannot choose a non-existent option
- member cannot choose more than 1 option
- member cannot revoke their selected option
- member cannot choose an option if the decision is already made
- only one option can be selected as a decision of an issue
- option cannot be reassigned after selection


- ChoiceAnalysis:
    - id
    - premises
    - bias
    - consequence
    - conclusion
    - creatorId
    - choiceOptionId
    - createdAt
- ChoiceAnalysis cannot be specified if the decision isn't made


- Discussion:
    - id
    - roomId
    - issueId
- Message:
    - id
    - senderId
    - discussionId
    - content
    - sentAt
- discussion cannot exist without consortium (consortiumId != null)
- discussion cannot exist without issue (issueId != null)
- discussion cannot be opened if an issue wasn't published yet
- only one discussion can belong to a particular issue (UNIQUE(issueId))
- Issue.consortiumId must be equal to consortiumId (?)
- discussion cannot be opened for closed issue
- discussion cannot be deleted if it has messages
- message cannot exist without discussion
- message cannot exist without sender
- message content cannot be empty or blank
- message content cannot exceed 5000 symbols
- message createdAt cannot be changed
- senderId must belong to the same consortium (otherwise anyone can send messages to any discussion)
- message cannot be sent to archived/closed discussion
- message cannot be edited/updated after 1 hour
- message cannot be created in future (createdAt <= now)


- MemberActivity(id, actorId, targetId, activityType, timestamp)
- member cannot exceed authority according to their status in a consortium
- member cannot delete more than 3 issues. If so, they cannot do
  any activity regarding issues on that day