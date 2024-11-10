const Challenge = require('../models/challenge');

class ChallengeService {
    // Create a new challenge
    static async createChallenge(challengeData) {
        const { name, description, goal, startDate, endDate } = challengeData;
        try {

            const newChallenge = new Challenge({
                name,
                description,
                goal,
                startDate: startDate || new Date(),  //
                endDate,
                status: 'Active',
            });
            const challenge = await newChallenge.save();
            return challenge;
        } catch (err) {

            throw new Error('Error creating challenge: ' + err.message);
        }
    }

    // Get all challenges
    static async getAllChallenges() {
        try {
            return await Challenge.find();  // Removed the populate part
        } catch (err) {
            throw new Error('Error retrieving challenges: ' + err.message);
        }
    }


    // Get challenge by ID
    static async getChallengeById(challengeId) {
        try {
            return await Challenge.findById(challengeId);
        } catch (err) {
            throw new Error('Error retrieving challenge: ' + err.message);
        }
    }

    // Join a challenge
    static async joinChallenge(challengeId, userId) {
        try {
            const challenge = await Challenge.findById(challengeId);
            if (!challenge) throw new Error('Challenge not found');

            challenge.participants.push(userId);
            return await challenge.save();
        } catch (err) {
            throw new Error('Error joining challenge: ' + err.message);
        }
    }

    // Update challenge status
    static async updateChallengeStatus(challengeId, status) {
        try {
            const challenge = await Challenge.findByIdAndUpdate(challengeId, { status }, { new: true });
            if (!challenge) throw new Error('Challenge not found');
            return challenge;
        } catch (err) {
            throw new Error('Error updating challenge: ' + err.message);
        }
    }
}

module.exports = ChallengeService;
