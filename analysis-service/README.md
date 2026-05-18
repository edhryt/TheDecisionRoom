### Entities:
- DecisionAnalysis(id, issueId, creatorId, conclusion,
  decisionQuality, createdAt)
- Expectation(id, title, isJustified, createdAt)
- Consequence(id, title, type, createdAt)
- Bias(id, name)
- Mistake(id, name, description)

### Aggregates:
- AnalysisAggregate:
    - Components:
      - DecisionAnalysis
    - Invariants:
      - ChoiceAnalysis cannot be specified if the decision isn't made