# Assignment

- Customer wants a simple quiz back end for a company event. 
- The most important thing, to the customer is, that TDD principles are implemented and integration tests are avoided.

# Requirements

## Data Entities

### Quiz
- Id
- Name
- Flavour text
- At least five Questions

### Question
- Id
- Challenge
- Answer
- Reward

### Slip
- Id
- Quiz Id (for which quiz?)
- Answers for the challenges
- User id (who submitted?)
- Score

### Receipt
- Id
- Sum of earned reward
- Optional: Show which question were answered correctly

## Controllers

### Quiz

- Get quiz by Id
- Get all available quizzes
- Optional: Receive a quiz-document (with at least five questions), validate and persist

### Slip

- Receive a slip from a user, compare and correct, persist and return receipt
- Get all slips belonging to a Quiz (high score feature)

## Business Requirements

- Spring 3, WEB, JPA and MongoDB
- Serve a quiz from an endpoint GET /api/quiz/{quizId}
- Serve a list of available quizzes on GET /api/quiz/all
- Quizzed created on POST /api/quiz/create
- Accept a slip on POST /api/slip/{quizId} and return a receipt
- Slip is validated against the correct answers and scored is reflected on the receipt
- High score per quiz available at /api/high-score/{quizId}
- M
