const ChallengeService = require('../services/challengeService');

class ChallengeController {
    static async createChallenge(req, res) {
        try {
            const challenge = await ChallengeService.createChallenge(req.body);
            res.status(201).json(challenge);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async getAllChallenges(req, res) {
        try {
            const challenges = await ChallengeService.getAllChallenges();
            res.status(200).json(challenges);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }

    static async joinChallenge(req, res) {
        try {
            const challenge = await ChallengeService.joinChallenge(req.params.id, req.body.userId);
            res.status(200).json(challenge);
        } catch (err) {
            res.status(500).json({ message: err.message });
        }
    }
}

module.exports = ChallengeController;
