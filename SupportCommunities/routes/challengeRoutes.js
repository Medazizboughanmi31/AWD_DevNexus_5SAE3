const express = require('express');
const ChallengeController = require('../controller/challengeController');
const router = express.Router();

// Define routes for challenges
router.post('/', ChallengeController.createChallenge);
router.get('/', ChallengeController.getAllChallenges);
router.post('/:id/join', ChallengeController.joinChallenge);

module.exports = router;
