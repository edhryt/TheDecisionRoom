## The Project Overview

The system solves decision-making problem and allows to predict 
and prophesy consequences. At the same time, it allows to see the 
whole picture and choose the most appropriate way to achieve desired
goal.

The key features include:
- Examining and eliminating biases
- Preventing doing the same mistakes again
- Analyzing decisions
- Brainstorming and reasoning an issue
- Improving decision-making skills
- Exploring trade-offs

The system may be used by both regular users and businesses.
___
## Internals
### Use cases:
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
- CreateDecisionAnalysis
- UpdateDecisionAnalysis
- DeleteRoom
- LeaveRoom