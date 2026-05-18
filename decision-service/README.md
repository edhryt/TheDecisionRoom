### Entities:
- Issue(id, roomId, discussionId, creatorId, status, createdAt)
- IssueContext(id, aim, constraints, givenKnowledge, budget, requirements, deadline)
- ChoiceOption(id, title)
- MemberViewpoint(id, chosenOption, memberId, reasoning)
- MetDecision(id, chosenOption, explanation, madeAt)
- OptionAdvantage(id, title, choiceOption)
- OptionDisadvantage(id, title, choiceOption)

### Aggregates:
- IssueAggregate:
    - Components:
      - Issue
      - IssueContext
      - ChoiceOption
      - MemberViewpoint
      - MetDecision
      - OptionAdvantage
      - OptionDisadvantage
    - Invariants:
      - member cannot publish an issue if the previous one isn't solved
      - if many members try to publish an issue, the right is granted to the first one
      - an issue can be updated or deleted only within the trial period which is less than the time required to make a final decision
      - member cannot delete non-existent issue
      - member cannot choose a non-existent option
      - member cannot choose more than 1 option
      - member cannot revoke their selected option
      - member cannot choose an option if the decision is already made
      - only one option can be selected as a decision of an issue
      - option cannot be reassigned after selection